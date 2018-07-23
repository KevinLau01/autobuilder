package com.testpro.base.course.controller;

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

import com.testpro.base.course.bean.Course;
import com.testpro.base.course.bean.CourseSearch;
import com.testpro.base.course.service.spi.ICourseService;

/**
 * Controller of Course
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/course")
public class CourseController {

	private Logger logger = Logger.getLogger(CourseController.class);
	
	@Autowired
	private ICourseService courseServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, CourseSearch search){
		if (search == null) {
			search = new CourseSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", courseServiceImpl.page(Course.class, search));
		return "base/course/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/course/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/course/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/course/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/course/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Course course) {
		courseServiceImpl.save(course);
		return "redirect:/course";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Course course) {
		courseServiceImpl.update(course);
		return "redirect:/course";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		courseServiceImpl.delete(Course.class, id);
		return "redirect:/course";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Course getJson(Model model, @PathVariable Integer id){
		return courseServiceImpl.find(Course.class, id);
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
