package com.poly.son.service;

import com.poly.son.entity.Account;

public interface DangNhapService {

	Account getByUserName(String username);
}
