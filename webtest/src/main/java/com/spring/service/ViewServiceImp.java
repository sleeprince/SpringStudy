package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.dao.ViewDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewServiceImp implements ViewService {

	private final ViewDao viewDao;
	
}
