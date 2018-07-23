package com.testpro.data.stuImage.controller;

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

import com.testpro.data.stuImage.bean.StuImage;
import com.testpro.data.stuImage.bean.StuImageSearch;
import com.testpro.data.stuImage.service.spi.IStuImageService;

/**
 * Controller of StuImage
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/stuImage")
public class StuImageController {

	private Logger logger = Logger.getLogger(StuImageController.class);
	
	@Autowired
	private IStuImageService stuImageServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, StuImageSearch search){
		if (search == null) {
			search = new StuImageSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", stuImageServiceImpl.page(StuImage.class, search));
		return "data/stuImage/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/stuImage/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/stuImage/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/stuImage/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/stuImage/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(StuImage stuImage) {
		stuImageServiceImpl.save(stuImage);
		return "redirect:/stuImage";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(StuImage stuImage) {
		stuImageServiceImpl.update(stuImage);
		return "redirect:/stuImage";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		stuImageServiceImpl.delete(StuImage.class, id);
		return "redirect:/stuImage";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public StuImage getJson(Model model, @PathVariable Integer id){
		return stuImageServiceImpl.find(StuImage.class, id);
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
