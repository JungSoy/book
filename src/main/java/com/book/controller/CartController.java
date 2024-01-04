package com.book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.model.CartVO;
import com.book.model.UserVO;
import com.book.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart/cartadd")
	@ResponseBody
	public String addCartPOST(CartVO cart, HttpServletRequest request) {

		// 로그인 체크
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("user");
		if(uvo == null) {
			
			return "5";
		}
		
		// 카트 등록
		int result = cartService.addCart(cart);
		
		return result + "";
	}
}
