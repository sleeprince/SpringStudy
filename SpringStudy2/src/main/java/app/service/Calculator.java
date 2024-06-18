package app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.dao.HomeDao;
import app.dto.ParamDTO;

@Service
public class Calculator {
	
	public static void print(List<?> list) {
		System.out.print("[");
		for(Object obj : list) {
			System.out.print(obj.toString() + ", ");
		}
		System.out.println("]");
	}
	
	@Autowired
	private HomeDao homeDao;
	
	public void multiplyIt(Model model, ParamDTO dto) {
		List<HashMap> list = null;
		if(dto.isState()) {
			
			String str = dto.getMap().get("dan").toString();
			
			if("A".equals(str))
				list = homeDao.getTable();
			else
				list = homeDao.getTable(Integer.parseInt(str));
			
			print(list);
			
		}else {
			list = homeDao.getTable();
			print(list);
		}
		model.addAttribute("list", list);
	}
	
	public void doIt(Model model, ParamDTO dto) {		
				
		if(dto.isState()) {
			
			String mark = dto.getMap().get("mark").toString();
			String nums = dto.getMap().get("nums").toString();
			
			System.out.println(mark);
			System.out.println(nums);
			
			String[] marks = mark.split(",");
			String[] str_num = nums.split(",");
			
			List<String> operator = new ArrayList<>();
			for(String str : marks)
				operator.add(str);
			
			List<Double> numbers = new ArrayList<>();
			for(String str : str_num)
				numbers.add(Double.parseDouble(str));
			
			print(numbers);
			
			for(int i = 0; i < operator.size();) {
				if("*".equals(operator.get(i))) {
					double tmp = numbers.get(i) * numbers.get(i+1);
					numbers.set(i, tmp);
					numbers.remove(i+1);
					operator.remove(i);
					print(operator);
					print(numbers);
				}else if("/".equals(operator.get(i))) {
					double tmp = numbers.get(i) / numbers.get(i+1);
					numbers.set(i, tmp);
					numbers.remove(i+1);
					operator.remove(i);
					print(operator);
					print(numbers);
				}else i++;
			}
			
			for(int i = 0; i < operator.size();) {
				if("+".equals(operator.get(i))) {
					double tmp = numbers.get(i) + numbers.get(i+1);
					numbers.set(i, tmp);
					numbers.remove(i+1);
					operator.remove(i);
					print(operator);
					print(numbers);
				}else if("-".equals(operator.get(i))) {
					double tmp = numbers.get(i) - numbers.get(i+1);
					numbers.set(i, tmp);
					numbers.remove(i+1);
					operator.remove(i);
					print(operator);
					print(numbers);
				}else i++;
			}
			print(operator);
			print(numbers);
			model.addAttribute("result", numbers.get(0));
		}
	}
	
	
}
