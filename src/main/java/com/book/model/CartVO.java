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
	
	@Setter(AccessLevel.NONE)
	private int salePrice, totalPrice;
	
	private double bookDiscount;
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.cartCount;
	}
	
	
	
}
