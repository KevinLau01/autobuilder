package com.testpro.stuFaceMapping.controller;

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

import com.testpro.stuFaceMapping.bean.StuFaceMapping;
import com.testpro.stuFaceMapping.bean.StuFaceMappingSearch;
import com.testpro.stuFaceMapping.service.spi.IStuFaceMappingService;

/**
 * Controller of StuFaceMapping
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuFaceMapping")
public class StuFaceMappingController {

	private Logger logger = Logger.getLogger(StuFaceMappingController.class);
	
	@Autowired
	private IStuFaceMappingService stuFaceMappingServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuFaceMappingSearch search){
		if (search == null) {
			search = new StuFaceMappingSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuFaceMappingServiceImpl.page(StuFaceMapping.class, search));
		return "stuFaceMapping/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "stuFaceMapping/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "stuFaceMapping/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "stuFaceMapping/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "stuFaceMapping/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuFaceMapping stuFaceMapping) {
		stuFaceMappingServiceImpl.save(stuFaceMapping);
		return "redirect:/stuFaceMapping";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuFaceMapping stuFaceMapping) {
		stuFaceMappingServiceImpl.update(stuFaceMapping);
		return "redirect:/stuFaceMapping";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuFaceMappingServiceImpl.delete(StuFaceMapping.class, id);
		return "redirect:/stuFaceMapping";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuFaceMapping getJson(Model model, @PathVariable Integer id){
		return stuFaceMappingServiceImpl.find(StuFaceMapping.class, id);
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
