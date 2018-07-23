package com.testpro.base.stu.controller;

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

import com.testpro.base.stu.bean.Stu;
import com.testpro.base.stu.bean.StuSearch;
import com.testpro.base.stu.service.spi.IStuService;

/**
 * Controller of Stu
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stu")
public class StuController {

	private Logger logger = Logger.getLogger(StuController.class);
	
	@Autowired
	private IStuService stuServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuSearch search){
		if (search == null) {
			search = new StuSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuServiceImpl.page(Stu.class, search));
		return "base/stu/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/stu/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/stu/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/stu/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/stu/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Stu stu) {
		stuServiceImpl.save(stu);
		return "redirect:/stu";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Stu stu) {
		stuServiceImpl.update(stu);
		return "redirect:/stu";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuServiceImpl.delete(Stu.class, id);
		return "redirect:/stu";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Stu getJson(Model model, @PathVariable Integer id){
		return stuServiceImpl.find(Stu.class, id);
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
