package com.testpro.feedImpress.controller;

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

import com.testpro.feedImpress.bean.FeedImpress;
import com.testpro.feedImpress.bean.FeedImpressSearch;
import com.testpro.feedImpress.service.spi.IFeedImpressService;

/**
 * Controller of FeedImpress
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/feedImpress")
public class FeedImpressController {

	private Logger logger = Logger.getLogger(FeedImpressController.class);
	
	@Autowired
	private IFeedImpressService feedImpressServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, FeedImpressSearch search){
		if (search == null) {
			search = new FeedImpressSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", feedImpressServiceImpl.page(FeedImpress.class, search));
		return "feedImpress/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "feedImpress/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "feedImpress/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "feedImpress/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "feedImpress/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FeedImpress feedImpress) {
		feedImpressServiceImpl.save(feedImpress);
		return "redirect:/feedImpress";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(FeedImpress feedImpress) {
		feedImpressServiceImpl.update(feedImpress);
		return "redirect:/feedImpress";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		feedImpressServiceImpl.delete(FeedImpress.class, id);
		return "redirect:/feedImpress";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public FeedImpress getJson(Model model, @PathVariable Integer id){
		return feedImpressServiceImpl.find(FeedImpress.class, id);
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
