package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.service.Calculator;
import app.util.ParamUtil;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
	@Autowired
	private Calculator clcl;
	
	@Autowired
	private ParamUtil paramUtil;
	
	@GetMapping("/calculator")
	public String calculator(Model model, HttpServletRequest req) {
		clcl.doIt(model, paramUtil.getParam(req));
		return "calculator";
	}
	
	@GetMapping("/timesTable")
	public String timesTable(Model model, HttpServletRequest req) {
		clcl.multiplyIt(model, paramUtil.getParam(req));	
		return "timesTable";
	}
	
	
	@Autowired
	private SqlSession session;
	
	@GetMapping("/test")
	public String test() {
		int no = session.selectOne("sql.test");
		System.out.println("no : " + no);
		return "";
	}
	
}
