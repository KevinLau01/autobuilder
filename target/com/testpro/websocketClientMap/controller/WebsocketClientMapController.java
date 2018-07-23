package com.testpro.websocketClientMap.controller;

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

import com.testpro.websocketClientMap.bean.WebsocketClientMap;
import com.testpro.websocketClientMap.bean.WebsocketClientMapSearch;
import com.testpro.websocketClientMap.service.spi.IWebsocketClientMapService;

/**
 * Controller of WebsocketClientMap
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/websocketClientMap")
public class WebsocketClientMapController {

	private Logger logger = Logger.getLogger(WebsocketClientMapController.class);
	
	@Autowired
	private IWebsocketClientMapService websocketClientMapServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, WebsocketClientMapSearch search){
		if (search == null) {
			search = new WebsocketClientMapSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", websocketClientMapServiceImpl.page(WebsocketClientMap.class, search));
		return "websocketClientMap/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "websocketClientMap/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "websocketClientMap/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "websocketClientMap/details";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "websocketClientMap/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(WebsocketClientMap websocketClientMap) {
		websocketClientMapServiceImpl.save(websocketClientMap);
		return "redirect:/websocketClientMap";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(WebsocketClientMap websocketClientMap) {
		websocketClientMapServiceImpl.update(websocketClientMap);
		return "redirect:/websocketClientMap";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		websocketClientMapServiceImpl.delete(WebsocketClientMap.class, id);
		return "redirect:/websocketClientMap";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public WebsocketClientMap getJson(Model model, @PathVariable Integer id){
		return websocketClientMapServiceImpl.find(WebsocketClientMap.class, id);
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
