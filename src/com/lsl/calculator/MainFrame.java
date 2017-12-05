package com.lsl.calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 计算器的主Frame界面
 * @author Nerokey
 *
 */
public class MainFrame extends JFrame implements ActionListener {

	private int width = 240;
	private int height = 280;
	
	private int x = (int) this.getToolkit().getScreenSize().getWidth();
	private int y = (int) this.getToolkit().getScreenSize().getHeight();
	
	private static String content="";
	private static JTextField text = new JTextField(20);
	private static final String[]  str = {"←","C","√","±","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	private static int[] key = {4,5,6,7,8,9,10,11,12,13,14,15,16,17,19}; //每个数字按键对应的btn的i值
	private static final String[] values = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","+"};  //数字按键btn对应的值
	private JButton[] btn  = new JButton[20];
	
	MainFrame(){
		
		this.setTitle("计算器");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocation(x/2-width/2, y/2-height/2);
		this.setResizable(false);
		
		JPanel pan = new JPanel();
		
		JPanel cont = new JPanel(new GridLayout(5, 4));
		for(int i=0;i<str.length;i++){
			btn[i] = new JButton(str[i]);
			btn[i].addActionListener(this);
			cont.add(btn[i]);
		}
		btn[0].addActionListener(new ActionListener() {
			//清楚键
			@Override
			public void actionPerformed(ActionEvent e) {
				if(content.length() != 0){
					content = (String) content.subSequence(0, content.length()-1);
				}
				text.setText(content);
			}
		});
		btn[1].addActionListener(new ActionListener() {
			//归0键
			@Override
			public void actionPerformed(ActionEvent e) {
				content = "";
				text.setText(content);
			}
		});
		
		btn[18].addActionListener(new ActionListener() {
			//等号
			@Override
			public void actionPerformed(ActionEvent e) {
				String reg = "[\\+\\-\\*/]";
				String[] num = content.split(reg);
				int result=0;
				if(num.length > 1){
					if(content.indexOf("+") != -1){
						for(int i=0;i<num.length;i++){
							result += Integer.valueOf(num[i]);
						}
					}
					
				}
				text.setText(result+"");
				content = "";			
			}
		});
		pan.add(text);
		this.add(pan,BorderLayout.NORTH);
		this.add(cont,BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//添加数字按键的事件监听器
		for(int i=0;i<key.length;i++){
			if(e.getSource().equals(btn[key[i]])){
				content += values[i];
				text.setText(content);
			}
		}	
	}
}
