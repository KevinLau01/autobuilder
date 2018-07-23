package com.testpro.base.class.controller;

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

import com.testpro.base.class.bean.Class;
import com.testpro.base.class.bean.ClassSearch;
import com.testpro.base.class.service.spi.IClassService;

/**
 * Controller of Class
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/class")
public class ClassController {

	private Logger logger = Logger.getLogger(ClassController.class);
	
	@Autowired
	private IClassService classServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ClassSearch search){
		if (search == null) {
			search = new ClassSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", classServiceImpl.page(Class.class, search));
		return "base/class/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/class/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/class/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/class/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/class/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Class class) {
		classServiceImpl.save(class);
		return "redirect:/class";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Class class) {
		classServiceImpl.update(class);
		return "redirect:/class";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		classServiceImpl.delete(Class.class, id);
		return "redirect:/class";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Class getJson(Model model, @PathVariable Integer id){
		return classServiceImpl.find(Class.class, id);
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
