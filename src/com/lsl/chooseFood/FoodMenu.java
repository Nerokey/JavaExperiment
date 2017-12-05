package com.lsl.chooseFood;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单类
 * 使用ArrayList存放
 * @author Nerokey
 *
 */
public class FoodMenu {

	//菜单
	ArrayList<String> list = new ArrayList<String>();
	
	FoodMenu(){
		
	}
	public void addFood(String fname){
		list.add(fname);
	}
	public String getFoodByNo(int no){
		return list.get(no);
	}

	public void showMenu(){
		Iterator iter = list.iterator();
		int i=1;
		System.out.println("*****菜单*****");
		while(iter.hasNext()){
			System.out.println(i+". "+iter.next());
			i++;
		}
	}
}
