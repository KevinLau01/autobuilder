package com.testpro.data.originTable.controller;

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

import com.testpro.data.originTable.bean.OriginTable;
import com.testpro.data.originTable.bean.OriginTableSearch;
import com.testpro.data.originTable.service.spi.IOriginTableService;

/**
 * Controller of OriginTable
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/originTable")
public class OriginTableController {

	private Logger logger = Logger.getLogger(OriginTableController.class);
	
	@Autowired
	private IOriginTableService originTableServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, OriginTableSearch search){
		if (search == null) {
			search = new OriginTableSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", originTableServiceImpl.page(OriginTable.class, search));
		return "data/originTable/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/originTable/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/originTable/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/originTable/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/originTable/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(OriginTable originTable) {
		originTableServiceImpl.save(originTable);
		return "redirect:/originTable";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(OriginTable originTable) {
		originTableServiceImpl.update(originTable);
		return "redirect:/originTable";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		originTableServiceImpl.delete(OriginTable.class, id);
		return "redirect:/originTable";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public OriginTable getJson(Model model, @PathVariable Integer id){
		return originTableServiceImpl.find(OriginTable.class, id);
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
