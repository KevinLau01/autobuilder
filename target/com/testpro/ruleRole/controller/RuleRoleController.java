package com.testpro.ruleRole.controller;

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

import com.testpro.ruleRole.bean.RuleRole;
import com.testpro.ruleRole.bean.RuleRoleSearch;
import com.testpro.ruleRole.service.spi.IRuleRoleService;

/**
 * Controller of RuleRole
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/ruleRole")
public class RuleRoleController {

	private Logger logger = Logger.getLogger(RuleRoleController.class);
	
	@Autowired
	private IRuleRoleService ruleRoleServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, RuleRoleSearch search){
		if (search == null) {
			search = new RuleRoleSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", ruleRoleServiceImpl.page(RuleRole.class, search));
		return "ruleRole/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "ruleRole/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "ruleRole/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "ruleRole/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "ruleRole/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(RuleRole ruleRole) {
		ruleRoleServiceImpl.save(ruleRole);
		return "redirect:/ruleRole";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(RuleRole ruleRole) {
		ruleRoleServiceImpl.update(ruleRole);
		return "redirect:/ruleRole";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		ruleRoleServiceImpl.delete(RuleRole.class, id);
		return "redirect:/ruleRole";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public RuleRole getJson(Model model, @PathVariable Integer id){
		return ruleRoleServiceImpl.find(RuleRole.class, id);
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
