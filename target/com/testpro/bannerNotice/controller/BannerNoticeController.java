package com.testpro.bannerNotice.controller;

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

import com.testpro.bannerNotice.bean.BannerNotice;
import com.testpro.bannerNotice.bean.BannerNoticeSearch;
import com.testpro.bannerNotice.service.spi.IBannerNoticeService;

/**
 * Controller of BannerNotice
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/bannerNotice")
public class BannerNoticeController {

	private Logger logger = Logger.getLogger(BannerNoticeController.class);
	
	@Autowired
	private IBannerNoticeService bannerNoticeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, BannerNoticeSearch search){
		if (search == null) {
			search = new BannerNoticeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", bannerNoticeServiceImpl.page(BannerNotice.class, search));
		return "bannerNotice/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "bannerNotice/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "bannerNotice/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "bannerNotice/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "bannerNotice/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(BannerNotice bannerNotice) {
		bannerNoticeServiceImpl.save(bannerNotice);
		return "redirect:/bannerNotice";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BannerNotice bannerNotice) {
		bannerNoticeServiceImpl.update(bannerNotice);
		return "redirect:/bannerNotice";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		bannerNoticeServiceImpl.delete(BannerNotice.class, id);
		return "redirect:/bannerNotice";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public BannerNotice getJson(Model model, @PathVariable Integer id){
		return bannerNoticeServiceImpl.find(BannerNotice.class, id);
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
