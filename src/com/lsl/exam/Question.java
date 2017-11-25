package com.lsl.exam;

/**
 * 选择题的基类
 * 包括问题字段和选项字段
 * @author Nerokey
 *
 */
public class Question {

	private String text;   //问题
	private String option;  //选择
	
	Question(String text,String option){
		this.text = text;
		this.option = option;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
}
