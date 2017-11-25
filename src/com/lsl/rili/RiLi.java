package com.lsl.rili;

/**
 * 万年历小程序
 * 按照yyyy-mm-dd输入打印该年该月的日历，并能区别显示输入的是几号
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RiLi {
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println("input a date(yyyy-mm-dd):");
		Scanner scan = new Scanner(System.in);
		String dateStr = scan.nextLine();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = df.parse(dateStr);
		Calendar cal = new GregorianCalendar();
		cal.setTime(d);
		int t = cal.get(Calendar.DAY_OF_MONTH); // 获取输入的这一天号数
		cal.set(Calendar.DATE, 1);
		int a = cal.get(Calendar.DAY_OF_WEEK); // 获取1号是星期几
		int max = cal.getActualMaximum(Calendar.DATE); // 获取每个月最大的天数
		// 打印每月前几天的空白
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for (int i = 1; i < a; i++) {
			System.out.print(" \t");
		}

		for (int i = 1; i <= max; i++) {
			if (i == t) {
				System.out.print("*");
			}
			System.out.print(i);
			System.out.print("\t");
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
				System.out.println();
			cal.add(Calendar.DATE, 1);
		}
	}
}
