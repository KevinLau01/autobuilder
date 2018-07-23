package com.testpro.data.postvideo.controller;

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

import com.testpro.data.postvideo.bean.Postvideo;
import com.testpro.data.postvideo.bean.PostvideoSearch;
import com.testpro.data.postvideo.service.spi.IPostvideoService;

/**
 * Controller of Postvideo
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/postvideo")
public class PostvideoController {

	private Logger logger = Logger.getLogger(PostvideoController.class);
	
	@Autowired
	private IPostvideoService postvideoServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, PostvideoSearch search){
		if (search == null) {
			search = new PostvideoSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", postvideoServiceImpl.page(Postvideo.class, search));
		return "data/postvideo/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/postvideo/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/postvideo/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/postvideo/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/postvideo/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Postvideo postvideo) {
		postvideoServiceImpl.save(postvideo);
		return "redirect:/postvideo";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Postvideo postvideo) {
		postvideoServiceImpl.update(postvideo);
		return "redirect:/postvideo";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		postvideoServiceImpl.delete(Postvideo.class, id);
		return "redirect:/postvideo";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Postvideo getJson(Model model, @PathVariable Integer id){
		return postvideoServiceImpl.find(Postvideo.class, id);
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
