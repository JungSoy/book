package com.book.model;

import lombok.Data;

@Data
public class CartVO {

	private int cartId, bookId, bookCount;
	private String userId;
	
	//book
	private String bookName;
	private int bookPrice, salePrice, totalPrice;
	private double bookDiscount;
	
	public void initSaleTotal() {
		this.salePrice = (int) (this.bookPrice * (1-this.bookDiscount));
		this.totalPrice = this.salePrice*this.bookCount;
	}
	
}
