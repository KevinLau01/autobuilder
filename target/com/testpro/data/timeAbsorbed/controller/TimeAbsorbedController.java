package com.testpro.data.timeAbsorbed.controller;

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

import com.testpro.data.timeAbsorbed.bean.TimeAbsorbed;
import com.testpro.data.timeAbsorbed.bean.TimeAbsorbedSearch;
import com.testpro.data.timeAbsorbed.service.spi.ITimeAbsorbedService;

/**
 * Controller of TimeAbsorbed
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/timeAbsorbed")
public class TimeAbsorbedController {

	private Logger logger = Logger.getLogger(TimeAbsorbedController.class);
	
	@Autowired
	private ITimeAbsorbedService timeAbsorbedServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, TimeAbsorbedSearch search){
		if (search == null) {
			search = new TimeAbsorbedSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", timeAbsorbedServiceImpl.page(TimeAbsorbed.class, search));
		return "data/timeAbsorbed/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/timeAbsorbed/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/timeAbsorbed/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/timeAbsorbed/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/timeAbsorbed/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(TimeAbsorbed timeAbsorbed) {
		timeAbsorbedServiceImpl.save(timeAbsorbed);
		return "redirect:/timeAbsorbed";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(TimeAbsorbed timeAbsorbed) {
		timeAbsorbedServiceImpl.update(timeAbsorbed);
		return "redirect:/timeAbsorbed";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		timeAbsorbedServiceImpl.delete(TimeAbsorbed.class, id);
		return "redirect:/timeAbsorbed";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public TimeAbsorbed getJson(Model model, @PathVariable Integer id){
		return timeAbsorbedServiceImpl.find(TimeAbsorbed.class, id);
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
