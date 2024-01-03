package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mapper.CartMapper;
import com.book.model.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int addCart(CartVO cart) {
		//0 : 등록 실패
		//1 : 등록 성공
		//2 : 등록된 데이터 존재
		//5 : 로그인 필요
		
		//장바구니 데이터 유무
		CartVO checkCart = cartMapper.checkCart(cart);
		
		if(checkCart != null) {
			return 2;
		}
		
		//장바구니 등록 & 에러 시 0반환
		try {
			return cartMapper.addCart(cart);
		} catch (Exception e) {
			return 0;
		}
		
		
	}

}
