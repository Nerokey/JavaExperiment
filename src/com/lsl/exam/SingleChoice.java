package com.lsl.exam;

/**
 * 单选题类
 * 答案存在一个字符类型中
 * @author Nerokey
 *
 */
public class SingleChoice extends Question {

	private char rightAns;
	
	SingleChoice(String text, String option, char rightAns) {
		super(text, option);
		this.rightAns = rightAns;
	}

	public char getAnswer() {
		return rightAns;
	}

	public void setAnswer(char rightAns) {
		this.rightAns = rightAns;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(单选)"+this.getText()+"\n"+this.getOption();
	}
}
