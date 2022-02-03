package com.te.controllerlayer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.dtolayer.EmployeeDetails;
import com.te.servicelayer.EmployeeDetailsService;

@Controller
public class ControllerClass {
     
	@Autowired
	private EmployeeDetailsService employeeDetailsService;
	
	@GetMapping("/signup")
	public String getSignUp(ModelMap map,HttpServletRequest request) {
		// Reading cookies (Servlet ways of reading cookie)
		Cookie[] myCookie = request.getCookies();
		for(Cookie tempCookie : myCookie) {
			if(tempCookie.getName().equals("empUserName")) {
				map.addAttribute("empUserName", tempCookie.getValue());
			}
		}
		return "signupform";
	}
	
	@PostMapping("/signupresponse")
	public String processSignUpData(ModelMap map,EmployeeDetails details,HttpServletResponse response) {
		// creating cookie
		Cookie cookie = new Cookie("empUserName",details.getEmpName());
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		
		if(employeeDetailsService.addEmployee(details)) {
			map.addAttribute("msg", "Your Information was added succesfully");
			map.addAttribute("savedEmpDetails", details);
		}
		else {
			map.addAttribute("msg", "Unable to add EmployeeDetails ,Please try again !!!");
		}
		return "signupresult";
	}
	
	@GetMapping("/getempform")
	public String fetchEmpForm(ModelMap map ,@SessionAttribute(name="loggedIn",required=false) EmployeeDetails details) {
		if(details !=null) {
			return "getEmpForm";
		}
		else {
		return "login";
		}
	}
	
	@PostMapping("/getEmp")
	public String getEmpForm(ModelMap map,@RequestParam("userid") String eId) {
		EmployeeDetails details = employeeDetailsService.getEmployeeDetails(Integer.parseInt(eId));
		map.addAttribute("empFromDb", details);
		return "getEmpDetails";
	}
	
	
	@GetMapping("/login")
	public String loginForm(ModelMap map) {
		
		return "login";
	}
	
	@PostMapping("/loginresult")
	public String loginEmployee(int userId,String password,ModelMap map,HttpServletRequest request){
		HttpSession  session = request.getSession();
		EmployeeDetails details = employeeDetailsService.serviceAuthentication(userId, password);
		if(details!=null) {
			session.setAttribute("loggedIn", details);
			map.addAttribute("msg", "Login Sucessfull");
		}
		else {
			map.addAttribute("msg", "Login Unsuccessfull.. Invalid Credintials......!!!!!");
		}
		
		return "loginconfirmation";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
