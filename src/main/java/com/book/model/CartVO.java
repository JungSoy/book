package com.book.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class CartVO {

	private int cartId, bookId, cartCount;
	private String userNo;
	
	//book
	private String bookName;
	
	private int bookPrice;
	
	//추가
	@Setter(AccessLevel.NONE)
	private int salePrice, totalPrice;
	
	private int point, totalPoint;
	
	private double bookDiscount;
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.cartCount;
		this.point = (int)(Math.floor(this.salePrice*0.05));
		this.totalPoint =this.point * this.cartCount;
	}
	
	
	
}
