package com.testpro.ruleUserRole.controller;

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

import com.testpro.ruleUserRole.bean.RuleUserRole;
import com.testpro.ruleUserRole.bean.RuleUserRoleSearch;
import com.testpro.ruleUserRole.service.spi.IRuleUserRoleService;

/**
 * Controller of RuleUserRole
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/ruleUserRole")
public class RuleUserRoleController {

	private Logger logger = Logger.getLogger(RuleUserRoleController.class);
	
	@Autowired
	private IRuleUserRoleService ruleUserRoleServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RuleUserRoleSearch search){
		if (search == null) {
			search = new RuleUserRoleSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", ruleUserRoleServiceImpl.page(RuleUserRole.class, search));
		return "ruleUserRole/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "ruleUserRole/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "ruleUserRole/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "ruleUserRole/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "ruleUserRole/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RuleUserRole ruleUserRole) {
		ruleUserRoleServiceImpl.save(ruleUserRole);
		return "redirect:/ruleUserRole";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RuleUserRole ruleUserRole) {
		ruleUserRoleServiceImpl.update(ruleUserRole);
		return "redirect:/ruleUserRole";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		ruleUserRoleServiceImpl.delete(RuleUserRole.class, id);
		return "redirect:/ruleUserRole";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RuleUserRole getJson(Model model, @PathVariable Integer id){
		return ruleUserRoleServiceImpl.find(RuleUserRole.class, id);
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
