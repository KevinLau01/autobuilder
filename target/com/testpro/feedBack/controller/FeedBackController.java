package com.testpro.feedBack.controller;

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

import com.testpro.feedBack.bean.FeedBack;
import com.testpro.feedBack.bean.FeedBackSearch;
import com.testpro.feedBack.service.spi.IFeedBackService;

/**
 * Controller of FeedBack
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/feedBack")
public class FeedBackController {

	private Logger logger = Logger.getLogger(FeedBackController.class);
	
	@Autowired
	private IFeedBackService feedBackServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, FeedBackSearch search){
		if (search == null) {
			search = new FeedBackSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", feedBackServiceImpl.page(FeedBack.class, search));
		return "feedBack/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "feedBack/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "feedBack/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "feedBack/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "feedBack/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FeedBack feedBack) {
		feedBackServiceImpl.save(feedBack);
		return "redirect:/feedBack";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(FeedBack feedBack) {
		feedBackServiceImpl.update(feedBack);
		return "redirect:/feedBack";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		feedBackServiceImpl.delete(FeedBack.class, id);
		return "redirect:/feedBack";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public FeedBack getJson(Model model, @PathVariable Integer id){
		return feedBackServiceImpl.find(FeedBack.class, id);
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
