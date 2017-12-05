package com.lsl.chooseFood;

/**
 * 自定义异常
 * 不喜欢菜异常，如果点菜点到不喜欢的就会抛出该异常
 * @author Nerokey
 *
 */
public class BadFoodException extends Exception {

	public BadFoodException(){
		
	}
	
	public BadFoodException(String s){
		super(s);
	}
	
}
