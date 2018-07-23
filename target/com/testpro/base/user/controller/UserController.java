package com.testpro.base.user.controller;

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

import com.testpro.base.user.bean.User;
import com.testpro.base.user.bean.UserSearch;
import com.testpro.base.user.service.spi.IUserService;

/**
 * Controller of User
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, UserSearch search){
		if (search == null) {
			search = new UserSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", userServiceImpl.page(User.class, search));
		return "base/user/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/user/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/user/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/user/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/user/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(User user) {
		userServiceImpl.save(user);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(User user) {
		userServiceImpl.update(user);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		userServiceImpl.delete(User.class, id);
		return "redirect:/user";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public User getJson(Model model, @PathVariable Integer id){
		return userServiceImpl.find(User.class, id);
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
