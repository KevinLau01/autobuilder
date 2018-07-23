package com.testpro.recommendQuestion.controller;

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

import com.testpro.recommendQuestion.bean.RecommendQuestion;
import com.testpro.recommendQuestion.bean.RecommendQuestionSearch;
import com.testpro.recommendQuestion.service.spi.IRecommendQuestionService;

/**
 * Controller of RecommendQuestion
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/recommendQuestion")
public class RecommendQuestionController {

	private Logger logger = Logger.getLogger(RecommendQuestionController.class);
	
	@Autowired
	private IRecommendQuestionService recommendQuestionServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RecommendQuestionSearch search){
		if (search == null) {
			search = new RecommendQuestionSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", recommendQuestionServiceImpl.page(RecommendQuestion.class, search));
		return "recommendQuestion/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "recommendQuestion/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "recommendQuestion/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "recommendQuestion/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "recommendQuestion/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RecommendQuestion recommendQuestion) {
		recommendQuestionServiceImpl.save(recommendQuestion);
		return "redirect:/recommendQuestion";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RecommendQuestion recommendQuestion) {
		recommendQuestionServiceImpl.update(recommendQuestion);
		return "redirect:/recommendQuestion";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		recommendQuestionServiceImpl.delete(RecommendQuestion.class, id);
		return "redirect:/recommendQuestion";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RecommendQuestion getJson(Model model, @PathVariable Integer id){
		return recommendQuestionServiceImpl.find(RecommendQuestion.class, id);
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
