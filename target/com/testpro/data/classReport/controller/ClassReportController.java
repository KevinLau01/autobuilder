package com.testpro.data.classReport.controller;

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

import com.testpro.data.classReport.bean.ClassReport;
import com.testpro.data.classReport.bean.ClassReportSearch;
import com.testpro.data.classReport.service.spi.IClassReportService;

/**
 * Controller of ClassReport
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/classReport")
public class ClassReportController {

	private Logger logger = Logger.getLogger(ClassReportController.class);
	
	@Autowired
	private IClassReportService classReportServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ClassReportSearch search){
		if (search == null) {
			search = new ClassReportSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", classReportServiceImpl.page(ClassReport.class, search));
		return "data/classReport/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/classReport/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/classReport/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/classReport/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/classReport/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(ClassReport classReport) {
		classReportServiceImpl.save(classReport);
		return "redirect:/classReport";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(ClassReport classReport) {
		classReportServiceImpl.update(classReport);
		return "redirect:/classReport";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		classReportServiceImpl.delete(ClassReport.class, id);
		return "redirect:/classReport";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ClassReport getJson(Model model, @PathVariable Integer id){
		return classReportServiceImpl.find(ClassReport.class, id);
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
