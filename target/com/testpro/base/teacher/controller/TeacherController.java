package com.testpro.base.teacher.controller;

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

import com.testpro.base.teacher.bean.Teacher;
import com.testpro.base.teacher.bean.TeacherSearch;
import com.testpro.base.teacher.service.spi.ITeacherService;

/**
 * Controller of Teacher
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

	private Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	private ITeacherService teacherServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, TeacherSearch search){
		if (search == null) {
			search = new TeacherSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", teacherServiceImpl.page(Teacher.class, search));
		return "base/teacher/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/teacher/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/teacher/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/teacher/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/teacher/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Teacher teacher) {
		teacherServiceImpl.save(teacher);
		return "redirect:/teacher";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Teacher teacher) {
		teacherServiceImpl.update(teacher);
		return "redirect:/teacher";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		teacherServiceImpl.delete(Teacher.class, id);
		return "redirect:/teacher";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Teacher getJson(Model model, @PathVariable Integer id){
		return teacherServiceImpl.find(Teacher.class, id);
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
