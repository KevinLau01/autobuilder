package com.testpro.data.faceImage.controller;

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

import com.testpro.data.faceImage.bean.FaceImage;
import com.testpro.data.faceImage.bean.FaceImageSearch;
import com.testpro.data.faceImage.service.spi.IFaceImageService;

/**
 * Controller of FaceImage
 * @author lubo
 * @date 2018-7-23
 */
@Controller
@RequestMapping("/faceImage")
public class FaceImageController {

	private Logger logger = Logger.getLogger(FaceImageController.class);
	
	@Autowired
	private IFaceImageService faceImageServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, FaceImageSearch search){
		if (search == null) {
			search = new FaceImageSearch();
			// search.setPageSize(20);
		}
		model.addAttribute("list", faceImageServiceImpl.page(FaceImage.class, search));
		return "data/faceImage/list";
	}
	
	@RequestMapping(value="/goAdd", method = RequestMethod.GET)
	public String goAdd(Model model) {
		
		return "data/faceImage/add";
		
	}
	
	@RequestMapping(value="/goUpdate/{id}", method = RequestMethod.GET)
	public String goUpdate(Model model, @PathVariable Integer id) {
		
		return "data/faceImage/update";
	}
	
	@RequestMapping(value="/goDetails/{id}", method = RequestMethod.GET)
	public String goDetails(Model model, @PathVariable Integer id) {
		
		return "data/faceImage/goDetails";
	}
	
	
	@RequestMapping(value="/goDel/{id}", method = RequestMethod.GET)
	public String goDel(Model model, @PathVariable Integer id) {
		
		return "data/faceImage/del";
	}
	
	
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String add(FaceImage faceImage) {
		faceImageServiceImpl.save(faceImage);
		return "redirect:/faceImage";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String update(FaceImage faceImage) {
		faceImageServiceImpl.update(faceImage);
		return "redirect:/faceImage";
	}
	
	@RequestMapping(value="/del/{id}", method = RequestMethod.GET)
	public String del(Model model, @PathVariable Integer id) {
		faceImageServiceImpl.delete(FaceImage.class, id);
		return "redirect:/faceImage";
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public FaceImage getJson(Model model, @PathVariable Integer id){
		return faceImageServiceImpl.find(FaceImage.class, id);
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
