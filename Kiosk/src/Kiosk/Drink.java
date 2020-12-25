package Kiosk;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Drink extends JPanel{
	static int total = 0;
	int count = 0;
	String show = "";
	Font f_1=new Font(Font.SANS_SERIF,Font.PLAIN,15); //폰트설정
	Font f_2=new Font(Font.MONOSPACED,Font.BOLD,15);  //폰트설정

	String menu[] = {"콜라","사이다","스파클링사과","스파클링포도","트레비","밀키스","립톤"}; //메뉴배열설정
	int price[] = {2000,2000,2000,2000,2000,2000,2000}; //가격배열설정
	
	JButton bt[]=new JButton[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	ImageIcon icon[] = new ImageIcon[menu.length]; //길이가 메뉴갯수인 아이콘배열설정
	Label L1[] = new Label[menu.length]; //길이가 메뉴갯수인 label배열설정
	Label L2[] = new Label[menu.length]; //길이가 메뉴갯수인 label배열설정
	Button minus[] = new Button[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	Button plus[] = new Button[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	JButton ok[] = new JButton[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	TextField suja[] = new TextField[menu.length]; //길이가 메뉴갯수인 textfield배열설정
	
	public Drink() {
		this.setLayout(null);
		this.setBackground(Color.WHITE); //panel배경 색깔을 하얀색으로 한다.
		
		for(int i=0; i<menu.length; i++) {
			bt[i]=new JButton(menu[i]);
			if(i<4) {
				bt[i].setBounds(37*(i+1)+i*130,20,130,200); //인덱스 4까지는 첫줄에 놓게한다.
			}
			else if(i<8){
				bt[i].setBounds(37*(i-3)+(i-4)*130, 310, 130, 200); //나머지는 두번째줄에 놓게한다.
			}
			
			icon[i]=new ImageIcon("음료/Drink"+i+".PNG"); //아이콘에 이미지를 넣는다.
			bt[i].setIcon(icon[i]); //이미지를 넣은 아이콘을 버튼에 넣는다. 
			
			L1[i]=new Label(menu[i]); //메뉴label 배열생성
			L2[i]=new Label(price[i]+"원"); //가격label 배열생성
			L1[i].setBounds(bt[i].getX()+10, bt[i].getY()+200, 110, 20); //메뉴위치와 글자길이설정
			L1[i].setFont(f_2); //메뉴폰드설정
			L2[i].setBounds(bt[i].getX()+10, bt[i].getY()+220, 110, 20); //가격위치와 글자길이설정
			L2[i].setFont(f_1); //가격폰트설정
			
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(L2[i].getX()+20, L2[i].getY()+20, 40, 20);
	            
			 // "-" 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(suja[i].getX()-20, suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);
			 
			 // "+" 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(suja[i].getX()+40, suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);
	 
			 // 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(minus[i].getX(), suja[i].getY() + 20, 100, 20);
			ok[i].setEnabled(false);
			
			// Drink에 버튼추가
			this.add(bt[i]); 
			this.add(L1[i]);  
			this.add(L2[i]);  
			this.add(suja[i]);
			this.add(minus[i]);
			this.add(plus[i]);
			this.add(ok[i]);
		}
		
		for (int i = 0; i < menu.length; i++) {
			 int j = i;
			 // 버튼 이벤트
			 bt[i].addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 minus[j].setEnabled(true);
					 plus[j].setEnabled(true);
					 bt[j].setEnabled(true);
					 ok[j].setEnabled(true);
					 
					 count = 0;
				 }
			 });
			 
			 // - 버튼이벤트
			 minus[i].addActionListener(new ActionListener() {
				 
				 
				 public void actionPerformed(ActionEvent e) {
					 if (count > 0) {
						 count = count - 1;
						 suja[j].setText(count + "");
						 ok[j].setEnabled(true);
					 } else {
						 minus[j].setEnabled(false);
					 }
				 }
			 });    
			 // + 버튼 이벤트
			 plus[i].addActionListener(new ActionListener() {
		 
		     
				 public void actionPerformed(ActionEvent e) {
					 count = count + 1;
					 suja[j].setText(count + "");
					 ok[j].setEnabled(true);
					 if (count > 0) {
						 minus[j].setEnabled(true);
					 }
				 }
			 });
			
			 // 확인버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override 
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					DefaultTableModel m = (DefaultTableModel)Kiosk.mainkiosk.table.getModel();
					m.insertRow(0, new Object[] {menu[j],price[j],count,price[j]*count}); //m에 메뉴 가격 개수 합계 넣기
					Kiosk.mainkiosk.table.updateUI();
					
					ok[j].setEnabled(false);
					Kiosk.mainkiosk.total = Kiosk.mainkiosk.total  + price[j]*count;	// 총 합계에 더해주기
					suja[j].setText("0");
				}
				
			});
			
		}
	}

}