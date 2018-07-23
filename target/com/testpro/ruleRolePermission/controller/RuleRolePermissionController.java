package com.testpro.ruleRolePermission.controller;

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

import com.testpro.ruleRolePermission.bean.RuleRolePermission;
import com.testpro.ruleRolePermission.bean.RuleRolePermissionSearch;
import com.testpro.ruleRolePermission.service.spi.IRuleRolePermissionService;

/**
 * Controller of RuleRolePermission
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/ruleRolePermission")
public class RuleRolePermissionController {

	private Logger logger = Logger.getLogger(RuleRolePermissionController.class);
	
	@Autowired
	private IRuleRolePermissionService ruleRolePermissionServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RuleRolePermissionSearch search){
		if (search == null) {
			search = new RuleRolePermissionSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", ruleRolePermissionServiceImpl.page(RuleRolePermission.class, search));
		return "ruleRolePermission/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "ruleRolePermission/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "ruleRolePermission/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "ruleRolePermission/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "ruleRolePermission/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RuleRolePermission ruleRolePermission) {
		ruleRolePermissionServiceImpl.save(ruleRolePermission);
		return "redirect:/ruleRolePermission";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RuleRolePermission ruleRolePermission) {
		ruleRolePermissionServiceImpl.update(ruleRolePermission);
		return "redirect:/ruleRolePermission";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		ruleRolePermissionServiceImpl.delete(RuleRolePermission.class, id);
		return "redirect:/ruleRolePermission";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RuleRolePermission getJson(Model model, @PathVariable Integer id){
		return ruleRolePermissionServiceImpl.find(RuleRolePermission.class, id);
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
