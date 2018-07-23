package com.testpro.base.city.controller;

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

import com.testpro.base.city.bean.City;
import com.testpro.base.city.bean.CitySearch;
import com.testpro.base.city.service.spi.ICityService;

/**
 * Controller of City
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/city")
public class CityController {

	private Logger logger = Logger.getLogger(CityController.class);
	
	@Autowired
	private ICityService cityServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, CitySearch search){
		if (search == null) {
			search = new CitySearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", cityServiceImpl.page(City.class, search));
		return "base/city/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/city/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/city/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/city/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/city/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(City city) {
		cityServiceImpl.save(city);
		return "redirect:/city";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(City city) {
		cityServiceImpl.update(city);
		return "redirect:/city";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		cityServiceImpl.delete(City.class, id);
		return "redirect:/city";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public City getJson(Model model, @PathVariable Integer id){
		return cityServiceImpl.find(City.class, id);
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
