package com.testpro.base.client.controller;

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

import com.testpro.base.client.bean.Client;
import com.testpro.base.client.bean.ClientSearch;
import com.testpro.base.client.service.spi.IClientService;

/**
 * Controller of Client
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/client")
public class ClientController {

	private Logger logger = Logger.getLogger(ClientController.class);
	
	@Autowired
	private IClientService clientServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, ClientSearch search){
		if (search == null) {
			search = new ClientSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", clientServiceImpl.page(Client.class, search));
		return "base/client/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "base/client/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "base/client/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "base/client/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "base/client/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(Client client) {
		clientServiceImpl.save(client);
		return "redirect:/client";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(Client client) {
		clientServiceImpl.update(client);
		return "redirect:/client";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		clientServiceImpl.delete(Client.class, id);
		return "redirect:/client";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Client getJson(Model model, @PathVariable Integer id){
		return clientServiceImpl.find(Client.class, id);
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
