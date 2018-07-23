package com.testpro.data.timeEmotion.controller;

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

import com.testpro.data.timeEmotion.bean.TimeEmotion;
import com.testpro.data.timeEmotion.bean.TimeEmotionSearch;
import com.testpro.data.timeEmotion.service.spi.ITimeEmotionService;

/**
 * Controller of TimeEmotion
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/timeEmotion")
public class TimeEmotionController {

	private Logger logger = Logger.getLogger(TimeEmotionController.class);
	
	@Autowired
	private ITimeEmotionService timeEmotionServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, TimeEmotionSearch search){
		if (search == null) {
			search = new TimeEmotionSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", timeEmotionServiceImpl.page(TimeEmotion.class, search));
		return "data/timeEmotion/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/timeEmotion/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/timeEmotion/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/timeEmotion/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/timeEmotion/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(TimeEmotion timeEmotion) {
		timeEmotionServiceImpl.save(timeEmotion);
		return "redirect:/timeEmotion";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(TimeEmotion timeEmotion) {
		timeEmotionServiceImpl.update(timeEmotion);
		return "redirect:/timeEmotion";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		timeEmotionServiceImpl.delete(TimeEmotion.class, id);
		return "redirect:/timeEmotion";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public TimeEmotion getJson(Model model, @PathVariable Integer id){
		return timeEmotionServiceImpl.find(TimeEmotion.class, id);
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
