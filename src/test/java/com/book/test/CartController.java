package com.book.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.book.model.CartVO;
import com.book.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	//등록 테스트
		@Test
		public void addCartTest() {
			//given
				String userNo = "admin";
				int bookId = 22;
				int count = 5;
				
				CartVO cvo = new CartVO(); 
				cvo.setUserNo(userNo);
				cvo.setBookId(bookId);
				cvo.setCartCount(count);
			
			//when
				int result = cartService.addCart(cvo);
			
			//then
				System.out.println("** result : " + result);
			
			
		}
	
}
