package com.lsl.chooseFood;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 点菜系统
 * 程序主类
 * 需求：显示菜单，并按数字点菜，如果点到有人不喜欢的菜则抛出异常
 * @author Nerokey
 *
 */
public class Run {

	public static void main(String[] args) throws BadFoodException {		
		Scanner sc = new Scanner(System.in);
		//用户选择的菜list
		ArrayList<String> list = new ArrayList<String>();

		//创建菜单并添加菜
		FoodMenu fm = new FoodMenu();
		fm.addFood("麻辣香锅");
		fm.addFood("排骨炖豆角");
		fm.addFood("葱爆羊肉");
		fm.addFood("酸辣土豆丝");
		fm.addFood("清炒菜花");
		fm.addFood("清炒芥蓝");
		fm.showMenu();
		
		//创建dislikeMenu
		DislikeMenu dis = new DislikeMenu();
		dis.addDislike("葱爆羊肉");
		dis.addDislike("清炒菜花");
		
		while(true){
			try{
				System.out.print("请点菜，输入编号即可(0表示点菜结束):");
				int chiose = sc.nextInt();
				if(chiose==0){
					break;
				}
				if(dis.isExist(fm.getFoodByNo(chiose-1))){
					throw new BadFoodException("有人不喜欢该菜品...");
				}
				else{
					list.add(fm.getFoodByNo(chiose-1));		
				}
			} catch(BadFoodException e){
				System.out.println(e.getMessage());
			}
			finally{
				System.out.println("您已点菜品如下：");
				for(int i=0;i<list.size();i++){
					System.out.println((i+1)+". "+list.get(i));
				}				
			}
		}
		System.out.println("点菜结束，感谢使用！");
	}
}
