package com.testpro.base.sku.controller;

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

import com.testpro.base.sku.bean.Sku;
import com.testpro.base.sku.bean.SkuSearch;
import com.testpro.base.sku.service.spi.ISkuService;

/**
 * Controller of Sku
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/sku")
public class SkuController {

	private Logger logger = Logger.getLogger(SkuController.class);
	
	@Autowired
	private ISkuService skuServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, SkuSearch search){
		if (search == null) {
			search = new SkuSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", skuServiceImpl.page(Sku.class, search));
		return "base/sku/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/sku/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/sku/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/sku/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/sku/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Sku sku) {
		skuServiceImpl.save(sku);
		return "redirect:/sku";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Sku sku) {
		skuServiceImpl.update(sku);
		return "redirect:/sku";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		skuServiceImpl.delete(Sku.class, id);
		return "redirect:/sku";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Sku getJson(Model model, @PathVariable Integer id){
		return skuServiceImpl.find(Sku.class, id);
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
