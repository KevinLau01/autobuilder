package com.testpro.remarkChange.controller;

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

import com.testpro.remarkChange.bean.RemarkChange;
import com.testpro.remarkChange.bean.RemarkChangeSearch;
import com.testpro.remarkChange.service.spi.IRemarkChangeService;

/**
 * Controller of RemarkChange
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/remarkChange")
public class RemarkChangeController {

	private Logger logger = Logger.getLogger(RemarkChangeController.class);
	
	@Autowired
	private IRemarkChangeService remarkChangeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RemarkChangeSearch search){
		if (search == null) {
			search = new RemarkChangeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", remarkChangeServiceImpl.page(RemarkChange.class, search));
		return "remarkChange/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "remarkChange/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "remarkChange/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "remarkChange/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "remarkChange/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RemarkChange remarkChange) {
		remarkChangeServiceImpl.save(remarkChange);
		return "redirect:/remarkChange";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RemarkChange remarkChange) {
		remarkChangeServiceImpl.update(remarkChange);
		return "redirect:/remarkChange";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		remarkChangeServiceImpl.delete(RemarkChange.class, id);
		return "redirect:/remarkChange";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RemarkChange getJson(Model model, @PathVariable Integer id){
		return remarkChangeServiceImpl.find(RemarkChange.class, id);
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
