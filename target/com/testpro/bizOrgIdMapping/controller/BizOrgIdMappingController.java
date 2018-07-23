package com.testpro.bizOrgIdMapping.controller;

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

import com.testpro.bizOrgIdMapping.bean.BizOrgIdMapping;
import com.testpro.bizOrgIdMapping.bean.BizOrgIdMappingSearch;
import com.testpro.bizOrgIdMapping.service.spi.IBizOrgIdMappingService;

/**
 * Controller of BizOrgIdMapping
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/bizOrgIdMapping")
public class BizOrgIdMappingController {

	private Logger logger = Logger.getLogger(BizOrgIdMappingController.class);
	
	@Autowired
	private IBizOrgIdMappingService bizOrgIdMappingServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, BizOrgIdMappingSearch search){
		if (search == null) {
			search = new BizOrgIdMappingSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", bizOrgIdMappingServiceImpl.page(BizOrgIdMapping.class, search));
		return "bizOrgIdMapping/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "bizOrgIdMapping/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "bizOrgIdMapping/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "bizOrgIdMapping/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "bizOrgIdMapping/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(BizOrgIdMapping bizOrgIdMapping) {
		bizOrgIdMappingServiceImpl.save(bizOrgIdMapping);
		return "redirect:/bizOrgIdMapping";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(BizOrgIdMapping bizOrgIdMapping) {
		bizOrgIdMappingServiceImpl.update(bizOrgIdMapping);
		return "redirect:/bizOrgIdMapping";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		bizOrgIdMappingServiceImpl.delete(BizOrgIdMapping.class, id);
		return "redirect:/bizOrgIdMapping";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public BizOrgIdMapping getJson(Model model, @PathVariable Integer id){
		return bizOrgIdMappingServiceImpl.find(BizOrgIdMapping.class, id);
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
