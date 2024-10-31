package com.app.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.RoleEntity;
import com.app.model.UserEntity;
import com.app.repository.RoleEntityRepository;
import com.app.repository.UserEntityRepository;

@Controller
public class UserController {

	@GetMapping("/users")
	public String users(Model model, 
			@RequestParam(name = "userNm", required = false, defaultValue = "") String userNm, 
			@PageableDefault(size = 3) Pageable pageable) {
		Page<UserEntity> users = uRepository.findByUserNmContainingOrderByUserIdDesc(userNm, pageable);
		int cnt = 5;
		int end = Math.min(users.getTotalPages(), users.getPageable().getPageNumber() + cnt);
		int start = Math.max(1, end - (cnt - 1));
		model.addAttribute("users", users);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "user";
	}
	
	@Autowired
	private UserEntityRepository uRepository;
	
	@Autowired
	private RoleEntityRepository rRepository;
	
	@GetMapping("/grant")
	public String grant() {
		// 사용자 정보 가져오기
		UserEntity user = uRepository.findById(3).orElseThrow();
		// 사용자가 가지고 있는 권한 목록 가져오기
		Set<RoleEntity> roles = user.getRoles();
		// 신규 권한 가져오기
		RoleEntity role = rRepository.findById(3).orElseThrow();
		// 사용자 권한 목록 추가
		roles.add(role);
		user.setRoles(roles);
		// 수정된 사용자 정보 적용하기
		uRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/revoke")
	public String revoke() {
		UserEntity user = uRepository.findById(1).orElseThrow();
		// 사용자가 가지고 있는 권한 목록 가져오기
		Set<RoleEntity> roles = user.getRoles();
		// 삭제 대상 권한 가져오기
		RoleEntity role = rRepository.findById(3).orElseThrow();
		// 사용자 권한 목록 삭제
		roles.remove(role);
		user.setRoles(roles);
		// 수정된 사용자 정보 적용하기
		uRepository.save(user);
		return "redirect:/users";
	}
	
	@ResponseBody
	@GetMapping("/detail")
	public UserEntity detail(@RequestParam(name="userId") int userId) {
		return uRepository.findById(userId).orElseThrow(); // 사용자 정보 + 권한까지 출력
	}
	
}
