package com.lsl.chooseFood;
import java.util.ArrayList;

/**
 * 有人不喜欢的菜
 * @author Nerokey
 *
 */
public class DislikeMenu {

	ArrayList<String> dislike = new ArrayList<String>();
	
	DislikeMenu(){
		
	}
	public void addDislike(String fname){
		dislike.add(fname);
	}
	//判断该菜名是否存在不喜欢列表里
	public boolean isExist(String s){
		int result = dislike.indexOf(s);
		if(result != -1){
			return true;
		}
		return false;
	}
}
