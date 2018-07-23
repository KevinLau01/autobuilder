package com.testpro.data.stuVideo.controller;

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

import com.testpro.data.stuVideo.bean.StuVideo;
import com.testpro.data.stuVideo.bean.StuVideoSearch;
import com.testpro.data.stuVideo.service.spi.IStuVideoService;

/**
 * Controller of StuVideo
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuVideo")
public class StuVideoController {

	private Logger logger = Logger.getLogger(StuVideoController.class);
	
	@Autowired
	private IStuVideoService stuVideoServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuVideoSearch search){
		if (search == null) {
			search = new StuVideoSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuVideoServiceImpl.page(StuVideo.class, search));
		return "data/stuVideo/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/stuVideo/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/stuVideo/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/stuVideo/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/stuVideo/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuVideo stuVideo) {
		stuVideoServiceImpl.save(stuVideo);
		return "redirect:/stuVideo";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuVideo stuVideo) {
		stuVideoServiceImpl.update(stuVideo);
		return "redirect:/stuVideo";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuVideoServiceImpl.delete(StuVideo.class, id);
		return "redirect:/stuVideo";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuVideo getJson(Model model, @PathVariable Integer id){
		return stuVideoServiceImpl.find(StuVideo.class, id);
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
