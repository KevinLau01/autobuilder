package com.testpro.logOperation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testpro.logOperation.bean.LogOperation;
import com.testpro.logOperation.bean.LogOperationSearch;
import com.testpro.logOperation.service.spi.ILogOperationService;

/**
 * Controller of LogOperation
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/logOperation")
public class LogOperationController {

	private Logger logger = Logger.getLogger(LogOperationController.class);
	
	@Autowired
	private ILogOperationService logOperationServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, LogOperationSearch search){
		if (search == null) {
			search = new LogOperationSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", logOperationServiceImpl.page(LogOperation.class, search));
		return "logOperation/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "logOperation/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "logOperation/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "logOperation/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "logOperation/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(LogOperation logOperation) {
		logOperationServiceImpl.save(logOperation);
		return "redirect:/logOperation";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(LogOperation logOperation) {
		logOperationServiceImpl.update(logOperation);
		return "redirect:/logOperation";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		logOperationServiceImpl.delete(LogOperation.class, id);
		return "redirect:/logOperation";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public LogOperation getJson(Model model, @PathVariable Integer id){
		return logOperationServiceImpl.find(LogOperation.class, id);
	}
	
	/**
	 * 后台接收Date转换
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
