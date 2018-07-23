package com.testpro.data.userDimension.controller;

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

import com.testpro.data.userDimension.bean.UserDimension;
import com.testpro.data.userDimension.bean.UserDimensionSearch;
import com.testpro.data.userDimension.service.spi.IUserDimensionService;

/**
 * Controller of UserDimension
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/userDimension")
public class UserDimensionController {

	private Logger logger = Logger.getLogger(UserDimensionController.class);
	
	@Autowired
	private IUserDimensionService userDimensionServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, UserDimensionSearch search){
		if (search == null) {
			search = new UserDimensionSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", userDimensionServiceImpl.page(UserDimension.class, search));
		return "data/userDimension/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/userDimension/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/userDimension/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/userDimension/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/userDimension/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(UserDimension userDimension) {
		userDimensionServiceImpl.save(userDimension);
		return "redirect:/userDimension";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(UserDimension userDimension) {
		userDimensionServiceImpl.update(userDimension);
		return "redirect:/userDimension";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		userDimensionServiceImpl.delete(UserDimension.class, id);
		return "redirect:/userDimension";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public UserDimension getJson(Model model, @PathVariable Integer id){
		return userDimensionServiceImpl.find(UserDimension.class, id);
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
