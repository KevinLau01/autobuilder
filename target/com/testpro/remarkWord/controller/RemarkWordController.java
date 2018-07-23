package com.testpro.remarkWord.controller;

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

import com.testpro.remarkWord.bean.RemarkWord;
import com.testpro.remarkWord.bean.RemarkWordSearch;
import com.testpro.remarkWord.service.spi.IRemarkWordService;

/**
 * Controller of RemarkWord
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/remarkWord")
public class RemarkWordController {

	private Logger logger = Logger.getLogger(RemarkWordController.class);
	
	@Autowired
	private IRemarkWordService remarkWordServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RemarkWordSearch search){
		if (search == null) {
			search = new RemarkWordSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", remarkWordServiceImpl.page(RemarkWord.class, search));
		return "remarkWord/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "remarkWord/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "remarkWord/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "remarkWord/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "remarkWord/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RemarkWord remarkWord) {
		remarkWordServiceImpl.save(remarkWord);
		return "redirect:/remarkWord";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RemarkWord remarkWord) {
		remarkWordServiceImpl.update(remarkWord);
		return "redirect:/remarkWord";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		remarkWordServiceImpl.delete(RemarkWord.class, id);
		return "redirect:/remarkWord";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RemarkWord getJson(Model model, @PathVariable Integer id){
		return remarkWordServiceImpl.find(RemarkWord.class, id);
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
