package com.testpro.data.postvideoStatus.controller;

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

import com.testpro.data.postvideoStatus.bean.PostvideoStatus;
import com.testpro.data.postvideoStatus.bean.PostvideoStatusSearch;
import com.testpro.data.postvideoStatus.service.spi.IPostvideoStatusService;

/**
 * Controller of PostvideoStatus
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/postvideoStatus")
public class PostvideoStatusController {

	private Logger logger = Logger.getLogger(PostvideoStatusController.class);
	
	@Autowired
	private IPostvideoStatusService postvideoStatusServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, PostvideoStatusSearch search){
		if (search == null) {
			search = new PostvideoStatusSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", postvideoStatusServiceImpl.page(PostvideoStatus.class, search));
		return "data/postvideoStatus/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/postvideoStatus/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/postvideoStatus/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/postvideoStatus/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/postvideoStatus/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(PostvideoStatus postvideoStatus) {
		postvideoStatusServiceImpl.save(postvideoStatus);
		return "redirect:/postvideoStatus";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(PostvideoStatus postvideoStatus) {
		postvideoStatusServiceImpl.update(postvideoStatus);
		return "redirect:/postvideoStatus";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		postvideoStatusServiceImpl.delete(PostvideoStatus.class, id);
		return "redirect:/postvideoStatus";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public PostvideoStatus getJson(Model model, @PathVariable Integer id){
		return postvideoStatusServiceImpl.find(PostvideoStatus.class, id);
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
