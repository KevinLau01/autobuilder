package com.testpro.data.stuActive.controller;

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

import com.testpro.data.stuActive.bean.StuActive;
import com.testpro.data.stuActive.bean.StuActiveSearch;
import com.testpro.data.stuActive.service.spi.IStuActiveService;

/**
 * Controller of StuActive
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuActive")
public class StuActiveController {

	private Logger logger = Logger.getLogger(StuActiveController.class);
	
	@Autowired
	private IStuActiveService stuActiveServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuActiveSearch search){
		if (search == null) {
			search = new StuActiveSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuActiveServiceImpl.page(StuActive.class, search));
		return "data/stuActive/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/stuActive/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/stuActive/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/stuActive/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/stuActive/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuActive stuActive) {
		stuActiveServiceImpl.save(stuActive);
		return "redirect:/stuActive";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuActive stuActive) {
		stuActiveServiceImpl.update(stuActive);
		return "redirect:/stuActive";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuActiveServiceImpl.delete(StuActive.class, id);
		return "redirect:/stuActive";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuActive getJson(Model model, @PathVariable Integer id){
		return stuActiveServiceImpl.find(StuActive.class, id);
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
