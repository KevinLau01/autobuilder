package com.testpro.data.stuDaily.controller;

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

import com.testpro.data.stuDaily.bean.StuDaily;
import com.testpro.data.stuDaily.bean.StuDailySearch;
import com.testpro.data.stuDaily.service.spi.IStuDailyService;

/**
 * Controller of StuDaily
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuDaily")
public class StuDailyController {

	private Logger logger = Logger.getLogger(StuDailyController.class);
	
	@Autowired
	private IStuDailyService stuDailyServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuDailySearch search){
		if (search == null) {
			search = new StuDailySearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuDailyServiceImpl.page(StuDaily.class, search));
		return "data/stuDaily/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/stuDaily/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/stuDaily/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/stuDaily/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/stuDaily/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuDaily stuDaily) {
		stuDailyServiceImpl.save(stuDaily);
		return "redirect:/stuDaily";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuDaily stuDaily) {
		stuDailyServiceImpl.update(stuDaily);
		return "redirect:/stuDaily";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuDailyServiceImpl.delete(StuDaily.class, id);
		return "redirect:/stuDaily";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuDaily getJson(Model model, @PathVariable Integer id){
		return stuDailyServiceImpl.find(StuDaily.class, id);
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
