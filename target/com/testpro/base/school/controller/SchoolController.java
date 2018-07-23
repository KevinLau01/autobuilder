package com.testpro.base.school.controller;

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

import com.testpro.base.school.bean.School;
import com.testpro.base.school.bean.SchoolSearch;
import com.testpro.base.school.service.spi.ISchoolService;

/**
 * Controller of School
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

	private Logger logger = Logger.getLogger(SchoolController.class);
	
	@Autowired
	private ISchoolService schoolServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, SchoolSearch search){
		if (search == null) {
			search = new SchoolSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", schoolServiceImpl.page(School.class, search));
		return "base/school/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/school/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/school/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/school/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/school/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(School school) {
		schoolServiceImpl.save(school);
		return "redirect:/school";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(School school) {
		schoolServiceImpl.update(school);
		return "redirect:/school";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		schoolServiceImpl.delete(School.class, id);
		return "redirect:/school";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public School getJson(Model model, @PathVariable Integer id){
		return schoolServiceImpl.find(School.class, id);
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
