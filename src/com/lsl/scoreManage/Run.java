package com.lsl.scoreManage;

/**
 * 写一个程序根据用户输入的指令得到结果输出
 * 指令有    avg:求某个同学或者课程的平均分，其参数可以为课程名或者学生姓名
 *       get:获取某个同学的某门课程的分数    例如:get Tom Java即为获取Tom同学的Java课程分数
 *       max:获得某门课程或者某个同学的最高分，并输出结果
 *       sort:对某门课程的分数进行排序，并使用列表输出
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class Run {
	static String[] students = { "Tom", "Lucy", "Nero", "Zhang", "Jane" }; // 学生数组
	static String[] courses = { "Java", "C++", "SQL", "Html", "Math", "English" }; // 课程数组

	// 学生成绩二维数组
	static int[][] grade = { { 76, 90, 66, 99, 20, 64 }, 
							 { 69, 88, 80, 91, 83, 66 }, 
							 { 8, 46, 77, 63, 57, 18 },
							 { 21, 94, 83, 52, 47, 84 }, 
							 { 37, 60, 72, 53, 88, 93 } 
						   };
	// 格式化小数，小数点后保留2位
	static DecimalFormat df = new DecimalFormat("#.00");

	// 打印开头学生成绩的表格
	public static void printInfo() {
		for (int i = 0; i < courses.length; i++) { // 打印第一行
			System.out.print("\t" + courses[i]);
		}
		System.out.println();
		// 打印后面几行
		for (int i = 0; i < grade.length; i++) {
			System.out.print(students[i] + "\t");
			for (int j = 0; j < grade[i].length; j++) {
				System.out.print(grade[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// 获取某个字符串在数组中的索引值；不存在返回-1，存在则返回元素下标。
	public static int getIndex(String[] s, String str) {
		int index = -1;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equalsIgnoreCase(str)) {
				index = i;
			}
		}
		return index;
	}

	// avg命令，统计平均分方法
	public static boolean avg(String str) {
		// 如果参数为all的情况
		if (str.equalsIgnoreCase("all")) {
			for (int i = 0; i < courses.length; i++) {
				System.out.print("\t" + courses[i]);
			}
			System.out.print("\t平均分\n");

			// 打印表格内容
			for (int i = 0; i < grade.length; i++) {
				System.out.print(students[i] + "\t");
				double sum = 0;
				for (int j = 0; j < grade[i].length; j++) {
					System.out.print(grade[i][j] + "\t");
					sum += grade[i][j];
				}
				// 显示某个同学的平均分
				System.out.println(df.format(sum / courses.length));
			}
			System.out.print("平均分\t");
			// 显示某门课程平均分
			for (int i = 0; i < courses.length; i++) {
				double total = 0;
				for (int j = 0; j < students.length; j++) {
					total += grade[j][i];
				}
				System.out.print(df.format(total / students.length) + "\t");
			}
			System.out.println();
			return true;
		}
		// 如果参数非all。
		int index1 = getIndex(courses, str);
		int index2 = getIndex(students, str);
		if (index1 == -1 && index2 == -1) {
			System.out.println("没有这个同学或者这门课程！");
			return false;
		}
		// 以课程为单位计算平均分
		if (index1 != -1) {
			double s1 = 0;
			for (int i = 0; i < students.length; i++) {
				s1 += grade[i][index1];
			}
			System.out.println(courses[index1] + "的平均分为：" + df.format(s1 / students.length));
		}
		// 以同学为单位计算平均分
		if (index2 != -1) {
			double s2 = 0;
			for (int i = 0; i < courses.length; i++) {
				s2 += grade[index2][i];
			}
			System.out.println(students[index2] + "同学的平均分为：" + df.format(s2 / courses.length));
		}
		return true;
	}

	// get命令，获取某个人的某门课的成绩
	public static boolean get(String name, String coursename) {
		int co_index = getIndex(courses, coursename); // 课程名索引
		int na_index = getIndex(students, name); // 姓名索引
		if (na_index == -1) {
			System.out.println("没有这个同学！");
			return false;
		} else if (co_index == -1) {
			System.out.println("没有这门课程！");
			return false;
		} else {
			System.out.println(students[na_index] + "同学的" + courses[co_index] + "分数为：" + grade[na_index][co_index]);
		}
		return true;
	}

	// max命令，获取某门课程或者学生的最高分
	public static boolean max(String str) {
		int index1 = getIndex(courses, str);
		int index2 = getIndex(students, str);
		// 如果课程名或者姓名不存在
		if (index1 == -1 && index2 == -1) {
			System.out.println("没有这个同学或者这门课程！");
			return false;
		}
		int max = 0;
		int k = -1;
		// 参数为课程名的情况
		if (index1 != -1) {
			for (int i = 0; i < students.length; i++) {
				if (grade[i][index1] > max) {
					max = grade[i][index1];
					k = i;
				}
			}
			System.out.println(courses[index1] + "课程的最高分是" + students[k] + ",分数为：" + grade[k][index1]);
			return true;
		}
		// 参数为同学名字的情况
		if (index2 != -1) {
			for (int i = 0; i < courses.length; i++) {
				if (grade[index2][i] > max) {
					max = grade[index2][i];
					k = i;
				}
			}
			System.out.println(students[index2] + "同学的最高分是" + courses[k] + "，分数为：" + grade[index2][k]);
			return true;
		}
		return false;
	}

	// sort命令，对某门课程进行排序按列表输出
	public static boolean sort(String str) {
		// 获取课程所在索引
		int index = getIndex(courses, str);
		if (index == -1) {
			System.out.println("没有这门课程！");
			return false;
		}
		int temp[] = new int[students.length];
		// 将学生姓名和需要排序的成绩全部传进来
		for (int i = 0; i < students.length; i++) {
			temp[i] = grade[i][index];
		}
		System.out.println("名次\t姓名\t" + courses[index]); // 打印表头
		int k = -1;
		for (int i = 0; i < students.length; i++) {
			int max = -1;
			for (int j = 0; j < students.length; j++) {
				if (temp[j] > max) {
					k = j;
					max = temp[k];
				}
			}
			temp[k] = -1;
			System.out.println((i + 1) + "\t" + students[k] + "\t" + max);
		}
		return false;
	}

	// 控制输入命令方法
	public static void commandInput() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("请输入命令：");
			String command = in.next();

			if (command.equalsIgnoreCase("avg")) {
				// 统计 课程(+课程名)、学生(+学生姓名)、所有(+all:包括课程和学生)的平均分
				String parameter = in.next();
				avg(parameter);
			}
			if (command.equalsIgnoreCase("get")) {
				// 获取某个学生的某门课成绩
				String parter1 = in.next(); // 参数1:+学生姓名
				String parter2 = in.next(); // 参数2:+课程名
				get(parter1, parter2);
			}
			if (command.equalsIgnoreCase("sort")) {
				// 列出某门课程的排序结果
				String parter = in.next(); // 参数：+课程名
				sort(parter);
			}
			if (command.equalsIgnoreCase("max")) {
				// 获取某门课或者某个学生的最大值
				String parter = in.next(); // 参数：+学生姓名或者课程名
				max(parter);
			}
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("系统退出！感谢使用！！");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Run.printInfo();
		commandInput();
	}
}
