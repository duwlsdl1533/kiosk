package Kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import Kiosk.mainkiosk;

public class Side extends JPanel{
	static int total=0;
	int count = 0;
	String show = "";
	Font f_1=new Font(Font.SANS_SERIF,Font.PLAIN,15); //폰트 설정
	Font f_2=new Font(Font.MONOSPACED,Font.BOLD,15);  //폰트 설정
		
	String menu[] = {"치킨가라아게미니덮밥","명란미니덮밥","가쓰오 튀김주먹밥","불만두","새우튀김","야채튀김","튀김어묵"}; //메뉴 배열설정
	int price[] = { 3000,2000,1500,3500,1500,1500,1500}; //가격 배열 설정
		
	JButton bt[]=new JButton[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	ImageIcon icon[] = new ImageIcon[menu.length];  //길이가 메뉴갯수인 아이콘배열설정
	Label L1[] = new Label[menu.length]; //길이가 메뉴갯수인 label배열설정
	Label L2[] = new Label[menu.length]; //길이가 메뉴갯수인 label배열설정
	Button minus[] = new Button[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	Button plus[] = new Button[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	JButton ok[] = new JButton[menu.length]; //길이가 메뉴갯수인 버튼배열설정
	TextField suja[] = new TextField[menu.length]; //길이가 메뉴갯수인 textfield배열설정
	public Side(){
		this.setLayout(null);
		this.setBackground(Color.WHITE); //panel 배경 색깔을 하얀색으로 한다.
		
		for(int i=0; i<menu.length; i++) { //메뉴갯수만큼 for문 돌린다.
			bt[i]=new JButton(menu[i]);
			if(i<4) {
				bt[i].setBounds(20*(i+1)+i*150,20,150,150); //인덱스 3까지는 첫줄에 놓게한다.
				
			}
			else {
				bt[i].setBounds(20*(i-3)+(i-4)*150,260, 150, 150); //그 외 나머지는 두번째줄에 놓게한다.
			}
			
			icon[i]=new ImageIcon("사이드/Side"+i+".PNG"); //아이콘에 이미지를 넣는다.
			bt[i].setIcon(icon[i]); //이미지를 넣은 아이콘을 버튼에 넣는다. 
			
			L1[i]=new Label(menu[i]); //메뉴label 배열생성
			L2[i]=new Label(price[i]+"원"); //가격label 배열 생성
			
			if((i==0)||(i==2)) { //인덱스 0과 2의 메뉴와 가격의 위치와 글자길이 설정
				L1[i].setBounds(bt[i].getX(), bt[i].getY()+150, 170, 20);
				L2[i].setBounds(bt[i].getX()+20, bt[i].getY()+170, 100, 20);
			}
			else { //그외 나머지 메뉴와 가격의 위치와 글자길이설정
				L1[i].setBounds(bt[i].getX()+20, bt[i].getY()+150, 100, 20);
				L2[i].setBounds(bt[i].getX()+20, bt[i].getY()+170, 100, 20);
			}
			//숫자 txt버튼
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(L2[i].getX()+20, L2[i].getY()+20, 40, 20);
	            
			 // - 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(suja[i].getX()-20, suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);
			 
			 // + 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(suja[i].getX()+40, suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);
	 
			 // 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(minus[i].getX(), suja[i].getY() + 20, 100, 20);
			ok[i].setEnabled(false);
			L1[i].setFont(f_2); //메뉴폰트설정
			L2[i].setFont(f_1); //가격폰트설정
			
			//Side에 버튼추가
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
			  
			 // - 버튼 이벤트
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
			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override 
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			
					DefaultTableModel m = (DefaultTableModel)Kiosk.mainkiosk.table.getModel();
					m.insertRow(0, new Object[] {menu[j],price[j],count,price[j]*count}); //m에 메뉴 가격 개수 합계 넣기
					Kiosk.mainkiosk.table.updateUI();
					
					ok[j].setEnabled(false);
					Kiosk.mainkiosk.total  = Kiosk.mainkiosk.total  + price[j]*count; // 총합계에 더해주기	
					suja[j].setText("0");
				}
				
			});
			
		}
	}

}

