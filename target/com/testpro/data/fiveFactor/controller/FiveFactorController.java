package com.testpro.data.fiveFactor.controller;

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

import com.testpro.data.fiveFactor.bean.FiveFactor;
import com.testpro.data.fiveFactor.bean.FiveFactorSearch;
import com.testpro.data.fiveFactor.service.spi.IFiveFactorService;

/**
 * Controller of FiveFactor
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/fiveFactor")
public class FiveFactorController {

	private Logger logger = Logger.getLogger(FiveFactorController.class);
	
	@Autowired
	private IFiveFactorService fiveFactorServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, FiveFactorSearch search){
		if (search == null) {
			search = new FiveFactorSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", fiveFactorServiceImpl.page(FiveFactor.class, search));
		return "data/fiveFactor/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/fiveFactor/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/fiveFactor/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/fiveFactor/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/fiveFactor/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FiveFactor fiveFactor) {
		fiveFactorServiceImpl.save(fiveFactor);
		return "redirect:/fiveFactor";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(FiveFactor fiveFactor) {
		fiveFactorServiceImpl.update(fiveFactor);
		return "redirect:/fiveFactor";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		fiveFactorServiceImpl.delete(FiveFactor.class, id);
		return "redirect:/fiveFactor";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public FiveFactor getJson(Model model, @PathVariable Integer id){
		return fiveFactorServiceImpl.find(FiveFactor.class, id);
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
