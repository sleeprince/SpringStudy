package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.dao.ViewDao;
import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewServiceImp implements ViewService {

	private final ViewDao viewDao;
	
	public TempDTO test(TempDTO dto) {
		return viewDao.test(dto);
	}
	
}
