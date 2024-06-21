package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.service.ContentService;
import app.util.ParamUtil;


@Controller
public class ContentController {
	
	@Autowired
	private ContentService conService;
	
	@Autowired
	private ParamUtil paramUtil;
	
	@GetMapping("/list")
	public String printListPage(Model model, HttpServletRequest req) {
		conService.sendData(model, paramUtil.getParam(req));
		return "list";
	}
	
	@GetMapping("/redirectlist")
	public String rediectList(Model model, HttpServletRequest req) {
		conService.updateApproval(model, paramUtil.getParam(req));
		return "redirect:list";
	}
		
	@GetMapping("/new")
	public String printNewPage() {		
		return "new";
	}
	
	@GetMapping("/detail")
	public String printDetailPage(Model model, HttpServletRequest req) {
		conService.getByNumber(model, paramUtil.getParam(req));
		return "detail";
	}
	
	@GetMapping("/redirectfromnewtodetail")
	public String rediectFromNewToDetail(Model model, HttpServletRequest req) {
		int num = conService.insertData(model, paramUtil.getParam(req));
		return "redirect:/detail?number=" + num;
	}
	
	@GetMapping("/redirectfromdetailtodetail")
	public String rediectFromDetailToDetail(Model model, HttpServletRequest req) {
		int num = conService.updateData(model, paramUtil.getParam(req));
		return "redirect:/detail?number=" + num;
	}
	
}
