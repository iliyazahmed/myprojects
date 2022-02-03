package com.te.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te.dto.UserDetails;

@Controller  
@RequestMapping("/spring")
public class FirstController {
	
	//@RequestMapping(path="/index",method=RequestMethod.GET)
	@GetMapping("/index")
	 public ModelAndView getHomePage() {
	    ModelAndView modelAndView = new ModelAndView();
  	    modelAndView.addObject("index");
		 return modelAndView;
		 
	 }
	//@RequestMapping(path = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String getMyHomePage(ModelMap map) {
		return "hello";
	}

	//@RequestMapping(path = "/search", method = RequestMethod.GET)
	@GetMapping("/search")
	public String getUserId(ModelMap map, HttpServletRequest request) {
		String userId = request.getParameter("id");
//		modelAndView.addObject("myuserId", userId);
//		modelAndView.setViewName("/WEB-INF/views/searchResult.jsp");
		map.addAttribute("myuserId", userId);
		return "searchResult";
	}
	@GetMapping("/loginpage")
	public String getForm(ModelMap map) {
		return "loginform";
	}
	//First way to return the data from view
	@PostMapping("/login")
	public String processData(ModelMap map,HttpServletRequest request) {
		String userId = request.getParameter("empId");
		String user = request.getParameter("userName");
		String password = request.getParameter("passkey");

		map.addAttribute("userId", userId);
		map.addAttribute("name", user);
		map.addAttribute("secretKey", password);
		return "searchResult";
	}
	@PostMapping("/login2")
	public String processTwoDat(@RequestParam String empId,@RequestParam String empName,@RequestParam String passKey,ModelMap map) {
		map.addAttribute("userId", Integer.parseInt(empId));
		map.addAttribute("name", empName);
		map.addAttribute("secretKey", passKey);
		return "searchResult";
	}
	@PostMapping("/login3")
	public String processData3(int empId, String empName, String passKey, ModelMap map) {
		map.addAttribute("userId", empId);
		map.addAttribute("name", empName);
		map.addAttribute("secretKey", passKey);
		return "searchResult";
	}
	@PostMapping("/login4")
	public String processData4(ModelMap map, UserDetails userDetails) {
		map.addAttribute("userId", userDetails.getEmpId());
		map.addAttribute("name", userDetails.getEmpName());
		map.addAttribute("secretKey", userDetails.getPassKey());

		map.addAttribute("userData", userDetails);
		return "searchResult";
	
	}
}
