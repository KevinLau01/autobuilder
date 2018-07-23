package com.testpro.base.stuClassMapping.controller;

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

import com.testpro.base.stuClassMapping.bean.StuClassMapping;
import com.testpro.base.stuClassMapping.bean.StuClassMappingSearch;
import com.testpro.base.stuClassMapping.service.spi.IStuClassMappingService;

/**
 * Controller of StuClassMapping
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuClassMapping")
public class StuClassMappingController {

	private Logger logger = Logger.getLogger(StuClassMappingController.class);
	
	@Autowired
	private IStuClassMappingService stuClassMappingServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuClassMappingSearch search){
		if (search == null) {
			search = new StuClassMappingSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuClassMappingServiceImpl.page(StuClassMapping.class, search));
		return "base/stuClassMapping/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/stuClassMapping/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/stuClassMapping/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/stuClassMapping/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/stuClassMapping/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuClassMapping stuClassMapping) {
		stuClassMappingServiceImpl.save(stuClassMapping);
		return "redirect:/stuClassMapping";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuClassMapping stuClassMapping) {
		stuClassMappingServiceImpl.update(stuClassMapping);
		return "redirect:/stuClassMapping";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuClassMappingServiceImpl.delete(StuClassMapping.class, id);
		return "redirect:/stuClassMapping";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuClassMapping getJson(Model model, @PathVariable Integer id){
		return stuClassMappingServiceImpl.find(StuClassMapping.class, id);
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
