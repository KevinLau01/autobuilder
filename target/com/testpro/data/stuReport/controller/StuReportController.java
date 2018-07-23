package com.testpro.data.stuReport.controller;

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

import com.testpro.data.stuReport.bean.StuReport;
import com.testpro.data.stuReport.bean.StuReportSearch;
import com.testpro.data.stuReport.service.spi.IStuReportService;

/**
 * Controller of StuReport
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuReport")
public class StuReportController {

	private Logger logger = Logger.getLogger(StuReportController.class);
	
	@Autowired
	private IStuReportService stuReportServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuReportSearch search){
		if (search == null) {
			search = new StuReportSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuReportServiceImpl.page(StuReport.class, search));
		return "data/stuReport/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/stuReport/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/stuReport/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/stuReport/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/stuReport/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuReport stuReport) {
		stuReportServiceImpl.save(stuReport);
		return "redirect:/stuReport";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuReport stuReport) {
		stuReportServiceImpl.update(stuReport);
		return "redirect:/stuReport";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuReportServiceImpl.delete(StuReport.class, id);
		return "redirect:/stuReport";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuReport getJson(Model model, @PathVariable Integer id){
		return stuReportServiceImpl.find(StuReport.class, id);
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
