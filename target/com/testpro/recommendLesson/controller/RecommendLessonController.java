package com.testpro.recommendLesson.controller;

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

import com.testpro.recommendLesson.bean.RecommendLesson;
import com.testpro.recommendLesson.bean.RecommendLessonSearch;
import com.testpro.recommendLesson.service.spi.IRecommendLessonService;

/**
 * Controller of RecommendLesson
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/recommendLesson")
public class RecommendLessonController {

	private Logger logger = Logger.getLogger(RecommendLessonController.class);
	
	@Autowired
	private IRecommendLessonService recommendLessonServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RecommendLessonSearch search){
		if (search == null) {
			search = new RecommendLessonSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", recommendLessonServiceImpl.page(RecommendLesson.class, search));
		return "recommendLesson/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "recommendLesson/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "recommendLesson/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "recommendLesson/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "recommendLesson/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RecommendLesson recommendLesson) {
		recommendLessonServiceImpl.save(recommendLesson);
		return "redirect:/recommendLesson";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RecommendLesson recommendLesson) {
		recommendLessonServiceImpl.update(recommendLesson);
		return "redirect:/recommendLesson";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		recommendLessonServiceImpl.delete(RecommendLesson.class, id);
		return "redirect:/recommendLesson";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RecommendLesson getJson(Model model, @PathVariable Integer id){
		return recommendLessonServiceImpl.find(RecommendLesson.class, id);
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
