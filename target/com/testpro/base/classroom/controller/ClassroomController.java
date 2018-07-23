package com.testpro.base.classroom.controller;

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

import com.testpro.base.classroom.bean.Classroom;
import com.testpro.base.classroom.bean.ClassroomSearch;
import com.testpro.base.classroom.service.spi.IClassroomService;

/**
 * Controller of Classroom
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/classroom")
public class ClassroomController {

	private Logger logger = Logger.getLogger(ClassroomController.class);
	
	@Autowired
	private IClassroomService classroomServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ClassroomSearch search){
		if (search == null) {
			search = new ClassroomSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", classroomServiceImpl.page(Classroom.class, search));
		return "base/classroom/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/classroom/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/classroom/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/classroom/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/classroom/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Classroom classroom) {
		classroomServiceImpl.save(classroom);
		return "redirect:/classroom";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Classroom classroom) {
		classroomServiceImpl.update(classroom);
		return "redirect:/classroom";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		classroomServiceImpl.delete(Classroom.class, id);
		return "redirect:/classroom";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Classroom getJson(Model model, @PathVariable Integer id){
		return classroomServiceImpl.find(Classroom.class, id);
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
