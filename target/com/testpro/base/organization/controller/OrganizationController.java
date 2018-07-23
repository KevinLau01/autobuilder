package com.testpro.base.organization.controller;

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

import com.testpro.base.organization.bean.Organization;
import com.testpro.base.organization.bean.OrganizationSearch;
import com.testpro.base.organization.service.spi.IOrganizationService;

/**
 * Controller of Organization
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {

	private Logger logger = Logger.getLogger(OrganizationController.class);
	
	@Autowired
	private IOrganizationService organizationServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, OrganizationSearch search){
		if (search == null) {
			search = new OrganizationSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", organizationServiceImpl.page(Organization.class, search));
		return "base/organization/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/organization/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/organization/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/organization/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/organization/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Organization organization) {
		organizationServiceImpl.save(organization);
		return "redirect:/organization";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Organization organization) {
		organizationServiceImpl.update(organization);
		return "redirect:/organization";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		organizationServiceImpl.delete(Organization.class, id);
		return "redirect:/organization";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Organization getJson(Model model, @PathVariable Integer id){
		return organizationServiceImpl.find(Organization.class, id);
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
