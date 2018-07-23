package com.testpro.recommendQuestionType.controller;

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

import com.testpro.recommendQuestionType.bean.RecommendQuestionType;
import com.testpro.recommendQuestionType.bean.RecommendQuestionTypeSearch;
import com.testpro.recommendQuestionType.service.spi.IRecommendQuestionTypeService;

/**
 * Controller of RecommendQuestionType
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/recommendQuestionType")
public class RecommendQuestionTypeController {

	private Logger logger = Logger.getLogger(RecommendQuestionTypeController.class);
	
	@Autowired
	private IRecommendQuestionTypeService recommendQuestionTypeServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RecommendQuestionTypeSearch search){
		if (search == null) {
			search = new RecommendQuestionTypeSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", recommendQuestionTypeServiceImpl.page(RecommendQuestionType.class, search));
		return "recommendQuestionType/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "recommendQuestionType/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "recommendQuestionType/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "recommendQuestionType/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "recommendQuestionType/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RecommendQuestionType recommendQuestionType) {
		recommendQuestionTypeServiceImpl.save(recommendQuestionType);
		return "redirect:/recommendQuestionType";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RecommendQuestionType recommendQuestionType) {
		recommendQuestionTypeServiceImpl.update(recommendQuestionType);
		return "redirect:/recommendQuestionType";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		recommendQuestionTypeServiceImpl.delete(RecommendQuestionType.class, id);
		return "redirect:/recommendQuestionType";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RecommendQuestionType getJson(Model model, @PathVariable Integer id){
		return recommendQuestionTypeServiceImpl.find(RecommendQuestionType.class, id);
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
