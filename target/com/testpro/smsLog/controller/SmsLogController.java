package com.testpro.smsLog.controller;

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

import com.testpro.smsLog.bean.SmsLog;
import com.testpro.smsLog.bean.SmsLogSearch;
import com.testpro.smsLog.service.spi.ISmsLogService;

/**
 * Controller of SmsLog
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/smsLog")
public class SmsLogController {

	private Logger logger = Logger.getLogger(SmsLogController.class);
	
	@Autowired
	private ISmsLogService smsLogServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, SmsLogSearch search){
		if (search == null) {
			search = new SmsLogSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", smsLogServiceImpl.page(SmsLog.class, search));
		return "smsLog/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "smsLog/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "smsLog/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "smsLog/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "smsLog/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(SmsLog smsLog) {
		smsLogServiceImpl.save(smsLog);
		return "redirect:/smsLog";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(SmsLog smsLog) {
		smsLogServiceImpl.update(smsLog);
		return "redirect:/smsLog";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		smsLogServiceImpl.delete(SmsLog.class, id);
		return "redirect:/smsLog";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public SmsLog getJson(Model model, @PathVariable Integer id){
		return smsLogServiceImpl.find(SmsLog.class, id);
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
