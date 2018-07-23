package com.testpro.websocketDataCommon.controller;

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

import com.testpro.websocketDataCommon.bean.WebsocketDataCommon;
import com.testpro.websocketDataCommon.bean.WebsocketDataCommonSearch;
import com.testpro.websocketDataCommon.service.spi.IWebsocketDataCommonService;

/**
 * Controller of WebsocketDataCommon
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/websocketDataCommon")
public class WebsocketDataCommonController {

	private Logger logger = Logger.getLogger(WebsocketDataCommonController.class);
	
	@Autowired
	private IWebsocketDataCommonService websocketDataCommonServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, WebsocketDataCommonSearch search){
		if (search == null) {
			search = new WebsocketDataCommonSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", websocketDataCommonServiceImpl.page(WebsocketDataCommon.class, search));
		return "websocketDataCommon/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "websocketDataCommon/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "websocketDataCommon/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "websocketDataCommon/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "websocketDataCommon/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(WebsocketDataCommon websocketDataCommon) {
		websocketDataCommonServiceImpl.save(websocketDataCommon);
		return "redirect:/websocketDataCommon";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(WebsocketDataCommon websocketDataCommon) {
		websocketDataCommonServiceImpl.update(websocketDataCommon);
		return "redirect:/websocketDataCommon";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		websocketDataCommonServiceImpl.delete(WebsocketDataCommon.class, id);
		return "redirect:/websocketDataCommon";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public WebsocketDataCommon getJson(Model model, @PathVariable Integer id){
		return websocketDataCommonServiceImpl.find(WebsocketDataCommon.class, id);
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
