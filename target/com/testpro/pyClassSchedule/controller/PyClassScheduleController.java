package com.testpro.pyClassSchedule.controller;

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

import com.testpro.pyClassSchedule.bean.PyClassSchedule;
import com.testpro.pyClassSchedule.bean.PyClassScheduleSearch;
import com.testpro.pyClassSchedule.service.spi.IPyClassScheduleService;

/**
 * Controller of PyClassSchedule
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/pyClassSchedule")
public class PyClassScheduleController {

	private Logger logger = Logger.getLogger(PyClassScheduleController.class);
	
	@Autowired
	private IPyClassScheduleService pyClassScheduleServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, PyClassScheduleSearch search){
		if (search == null) {
			search = new PyClassScheduleSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", pyClassScheduleServiceImpl.page(PyClassSchedule.class, search));
		return "pyClassSchedule/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "pyClassSchedule/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "pyClassSchedule/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "pyClassSchedule/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "pyClassSchedule/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(PyClassSchedule pyClassSchedule) {
		pyClassScheduleServiceImpl.save(pyClassSchedule);
		return "redirect:/pyClassSchedule";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(PyClassSchedule pyClassSchedule) {
		pyClassScheduleServiceImpl.update(pyClassSchedule);
		return "redirect:/pyClassSchedule";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		pyClassScheduleServiceImpl.delete(PyClassSchedule.class, id);
		return "redirect:/pyClassSchedule";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PyClassSchedule getJson(Model model, @PathVariable Integer id){
		return pyClassScheduleServiceImpl.find(PyClassSchedule.class, id);
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
