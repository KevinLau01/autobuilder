package com.testpro.data.timeAttitude.controller;

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

import com.testpro.data.timeAttitude.bean.TimeAttitude;
import com.testpro.data.timeAttitude.bean.TimeAttitudeSearch;
import com.testpro.data.timeAttitude.service.spi.ITimeAttitudeService;

/**
 * Controller of TimeAttitude
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/timeAttitude")
public class TimeAttitudeController {

	private Logger logger = Logger.getLogger(TimeAttitudeController.class);
	
	@Autowired
	private ITimeAttitudeService timeAttitudeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, TimeAttitudeSearch search){
		if (search == null) {
			search = new TimeAttitudeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", timeAttitudeServiceImpl.page(TimeAttitude.class, search));
		return "data/timeAttitude/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/timeAttitude/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/timeAttitude/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/timeAttitude/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/timeAttitude/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(TimeAttitude timeAttitude) {
		timeAttitudeServiceImpl.save(timeAttitude);
		return "redirect:/timeAttitude";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(TimeAttitude timeAttitude) {
		timeAttitudeServiceImpl.update(timeAttitude);
		return "redirect:/timeAttitude";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		timeAttitudeServiceImpl.delete(TimeAttitude.class, id);
		return "redirect:/timeAttitude";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public TimeAttitude getJson(Model model, @PathVariable Integer id){
		return timeAttitudeServiceImpl.find(TimeAttitude.class, id);
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
