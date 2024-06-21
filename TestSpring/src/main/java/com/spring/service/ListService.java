package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListService implements ViewService{@Override
	
	public TempDTO test(TempDTO dto) {
		return null;
	}

}
