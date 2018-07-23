package com.testpro.data.classFocus.controller;

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

import com.testpro.data.classFocus.bean.ClassFocus;
import com.testpro.data.classFocus.bean.ClassFocusSearch;
import com.testpro.data.classFocus.service.spi.IClassFocusService;

/**
 * Controller of ClassFocus
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/classFocus")
public class ClassFocusController {

	private Logger logger = Logger.getLogger(ClassFocusController.class);
	
	@Autowired
	private IClassFocusService classFocusServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ClassFocusSearch search){
		if (search == null) {
			search = new ClassFocusSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", classFocusServiceImpl.page(ClassFocus.class, search));
		return "data/classFocus/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/classFocus/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/classFocus/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/classFocus/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/classFocus/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ClassFocus classFocus) {
		classFocusServiceImpl.save(classFocus);
		return "redirect:/classFocus";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ClassFocus classFocus) {
		classFocusServiceImpl.update(classFocus);
		return "redirect:/classFocus";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		classFocusServiceImpl.delete(ClassFocus.class, id);
		return "redirect:/classFocus";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ClassFocus getJson(Model model, @PathVariable Integer id){
		return classFocusServiceImpl.find(ClassFocus.class, id);
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
