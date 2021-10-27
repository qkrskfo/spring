package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}	
	@RequestMapping("/model_model.do")
	public String model(Model model) {
		model.addAttribute("model", "모델데이타");
		/*
		 * request.setAttribute("model","모델데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	@RequestMapping("/model_map.do")
	public String map(Map map) {
		System.out.println("### map객체-->"+map);
		map.put("map", "맵데이타");
		/*
		 * request.setAttribute("map","맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap.do")
	public String modelmap(ModelMap modelMap) {
		modelMap.addAttribute("modelmap","모델맵데이타");
		/*
		 * request.setAttribute("modelmap","모델맵데이타");
		 */
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelandview.do")
	public ModelAndView modelandview() {
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("modelandview", "모델앤뷰데이타");
		/*
		 * request.setAttribute("modelandview","모델앤뷰데이타");
		 */
		modelAndView.setViewName("forward:/WEB-INF/views/spring_model.jsp");
		return modelAndView;
	}
	@RequestMapping("/model_all.do")
	public String model_all(HttpServletRequest req,Model model,Map map,ModelMap modelMap) {
		req.setAttribute("req", "리퀘스트데이타");
		model.addAttribute("model", "모델데이타");
		map.put("map", "맵데이타");
		modelMap.put("modelmap", "모델맵데이타");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	
}
















