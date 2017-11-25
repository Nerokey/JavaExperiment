package com.lsl.exam;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 选择题小程序
 * 定义一个问题的父类，分别定义单选题类和多选题类继承这个基类
 * @author Nerokey
 *
 */
public class Test {

	//判断单选题s的答案是否正确
	public static boolean checkSingle(SingleChoice s, String answer){
		if(Character.toUpperCase(answer.charAt(0))==s.getAnswer()){
			System.out.println("答对了！");
			return true;
		}
		else{
			System.out.println("错了！");
			return false;
		}
	}
	
	//判断多选题m的答案是否正确
	public static boolean checkMulti(MultiChoice m, String answer){
		
		String answ= answer.toUpperCase();
		char[] ans = answ.toCharArray();
		Arrays.sort(ans);
		Arrays.sort(m.getAnswer());
		if(Arrays.equals(ans, m.getAnswer())){
			System.out.println("恭喜，答对了！");
			return true;
		}
		else{
			System.out.println("答错了呀！");
			return false;
		}
	}
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String chiose;   //用户选择的答案
	
		SingleChoice s1 = new SingleChoice("最早向刘备推荐诸葛亮的是谁？", "A.徐庶\tB.司马徽\tC.鲁肃\tD.关羽", 'A');
		MultiChoice m1 = new MultiChoice("桃园结义是哪些人？", "A.刘备\tB.曹操\tC.关羽\tD.张飞","ACD".toCharArray());
		
		System.out.println(s1.toString());   //打印问题和选项
		System.out.print("请选择你的答案：");
		chiose= in.next();
		checkSingle(s1,chiose);
		
		System.out.println(m1.toString());   //打印问题和选项
		System.out.print("请选择你的答案：");
		chiose= in.next();
		checkMulti(m1,chiose);
	}

}
