package com.testpro.rulePermission.controller;

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

import com.testpro.rulePermission.bean.RulePermission;
import com.testpro.rulePermission.bean.RulePermissionSearch;
import com.testpro.rulePermission.service.spi.IRulePermissionService;

/**
 * Controller of RulePermission
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/rulePermission")
public class RulePermissionController {

	private Logger logger = Logger.getLogger(RulePermissionController.class);
	
	@Autowired
	private IRulePermissionService rulePermissionServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RulePermissionSearch search){
		if (search == null) {
			search = new RulePermissionSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", rulePermissionServiceImpl.page(RulePermission.class, search));
		return "rulePermission/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "rulePermission/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "rulePermission/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "rulePermission/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "rulePermission/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RulePermission rulePermission) {
		rulePermissionServiceImpl.save(rulePermission);
		return "redirect:/rulePermission";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RulePermission rulePermission) {
		rulePermissionServiceImpl.update(rulePermission);
		return "redirect:/rulePermission";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		rulePermissionServiceImpl.delete(RulePermission.class, id);
		return "redirect:/rulePermission";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RulePermission getJson(Model model, @PathVariable Integer id){
		return rulePermissionServiceImpl.find(RulePermission.class, id);
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
