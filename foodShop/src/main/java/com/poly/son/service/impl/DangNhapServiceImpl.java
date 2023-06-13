package com.poly.son.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.son.entity.Account;
import com.poly.son.repository.AccountRepository;
import com.poly.son.service.DangNhapService;

@Service
public class DangNhapServiceImpl implements DangNhapService {
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account getByUserName(String username) {
		return accountRepository.getByUsername(username);
	}

}
