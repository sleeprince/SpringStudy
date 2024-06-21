package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.dao.ContentDao;
import app.dto.ParamDTO;

@Service
public class ContentService {
	
	public static void print(List<?> list) {
		System.out.print("[");
		for(Object obj : list) {
			System.out.print(obj.toString() + ", ");
		}
		System.out.println("]");
	}
	
	@Autowired
	private ContentDao contentDao;
	
	public void sendData(Model model, ParamDTO dto){
		List<HashMap> list = null;
		if(dto.isState()) {
			list = contentDao.getDataApproval(Integer.parseInt(dto.getMap().get("app").toString()));
		}else {
			list = contentDao.getData();	
		}
		print(list);
		model.addAttribute("list", list);
	}
	
	public int insertData(Model model, ParamDTO dto) {
		
		if(dto.isState()) {
			Map<String, Object> map = new HashMap<>();
			map.put("title", dto.getMap().get("title"));
			map.put("content", dto.getMap().get("content"));
			map.put("approval", 0);
			contentDao.insertOne(map);
		}
		
		return contentDao.getLastest();
	}
	
	public int updateData(Model model, ParamDTO dto) {
		
		if(dto.isState()) {
			Map<String, Object> map = new HashMap<>();
			map.put("number", Integer.parseInt(dto.getMap().get("number").toString()));
			map.put("title", dto.getMap().get("title"));
			map.put("content", dto.getMap().get("content"));
			contentDao.updateOne(map);
		}
		
		return Integer.parseInt(dto.getMap().get("number").toString());
	}
	
	public int updateApproval(Model model, ParamDTO dto) {

		if(dto.isState()) {
			Map<String, Object> map = new HashMap<>();
			map.put("number", Integer.parseInt(dto.getMap().get("number").toString()));
			map.put("approval", Integer.parseInt(dto.getMap().get("app").toString()));
			contentDao.updateApp(map);
		}
		
		return Integer.parseInt(dto.getMap().get("number").toString());
	}
	
	public void getByNumber(Model model, ParamDTO dto) {
		List<HashMap> list = null;
		if(dto.isState()) {
			list = contentDao.getDataHana(Integer.parseInt(dto.getMap().get("number").toString()));
		}
		print(list);
		model.addAttribute("list", list);
	}
}
