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
	Font f_1=new Font(Font.SANS_SERIF,Font.PLAIN,15); //��Ʈ ����
	Font f_2=new Font(Font.MONOSPACED,Font.BOLD,15);  //��Ʈ ����
		
	String menu[] = {"ġŲ����ưԹ̴ϵ���","����̴ϵ���","������ Ƣ���ָԹ�","�Ҹ���","����Ƣ��","��äƢ��","Ƣ��"}; //�޴� �迭����
	int price[] = { 3000,2000,1500,3500,1500,1500,1500}; //���� �迭 ����
		
	JButton bt[]=new JButton[menu.length]; //���̰� �޴������� ��ư�迭����
	ImageIcon icon[] = new ImageIcon[menu.length];  //���̰� �޴������� �����ܹ迭����
	Label L1[] = new Label[menu.length]; //���̰� �޴������� label�迭����
	Label L2[] = new Label[menu.length]; //���̰� �޴������� label�迭����
	Button minus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	Button plus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	JButton ok[] = new JButton[menu.length]; //���̰� �޴������� ��ư�迭����
	TextField suja[] = new TextField[menu.length]; //���̰� �޴������� textfield�迭����
	public Side(){
		this.setLayout(null);
		this.setBackground(Color.WHITE); //panel ��� ������ �Ͼ������ �Ѵ�.
		
		for(int i=0; i<menu.length; i++) { //�޴�������ŭ for�� ������.
			bt[i]=new JButton(menu[i]);
			if(i<4) {
				bt[i].setBounds(20*(i+1)+i*150,20,150,150); //�ε��� 3������ ù�ٿ� �����Ѵ�.
				
			}
			else {
				bt[i].setBounds(20*(i-3)+(i-4)*150,260, 150, 150); //�� �� �������� �ι�°�ٿ� �����Ѵ�.
			}
			
			icon[i]=new ImageIcon("���̵�/Side"+i+".PNG"); //�����ܿ� �̹����� �ִ´�.
			bt[i].setIcon(icon[i]); //�̹����� ���� �������� ��ư�� �ִ´�. 
			
			L1[i]=new Label(menu[i]); //�޴�label �迭����
			L2[i]=new Label(price[i]+"��"); //����label �迭 ����
			
			if((i==0)||(i==2)) { //�ε��� 0�� 2�� �޴��� ������ ��ġ�� ���ڱ��� ����
				L1[i].setBounds(bt[i].getX(), bt[i].getY()+150, 170, 20);
				L2[i].setBounds(bt[i].getX()+20, bt[i].getY()+170, 100, 20);
			}
			else { //�׿� ������ �޴��� ������ ��ġ�� ���ڱ��̼���
				L1[i].setBounds(bt[i].getX()+20, bt[i].getY()+150, 100, 20);
				L2[i].setBounds(bt[i].getX()+20, bt[i].getY()+170, 100, 20);
			}
			//���� txt��ư
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(L2[i].getX()+20, L2[i].getY()+20, 40, 20);
	            
			 // - ��ư
			minus[i] = new Button("-");
			minus[i].setBounds(suja[i].getX()-20, suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);
			 
			 // + ��ư
			plus[i] = new Button("+");
			plus[i].setBounds(suja[i].getX()+40, suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);
	 
			 // Ȯ�� ��ư
			ok[i] = new JButton("Ȯ��");
			ok[i].setBounds(minus[i].getX(), suja[i].getY() + 20, 100, 20);
			ok[i].setEnabled(false);
			L1[i].setFont(f_2); //�޴���Ʈ����
			L2[i].setFont(f_1); //������Ʈ����
			
			//Side�� ��ư�߰�
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
			 // ��ư �̺�Ʈ
			 bt[i].addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 minus[j].setEnabled(true);
					 plus[j].setEnabled(true);
					 bt[j].setEnabled(true);
					 ok[j].setEnabled(true);
					 
					 count = 0;
				 }
			 });
			  
			 // - ��ư �̺�Ʈ
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
		        
		            
			 // + ��ư �̺�Ʈ
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
			// Ȯ�� ��ư �̺�Ʈ
			ok[i].addActionListener(new ActionListener() {

				@Override 
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			
					DefaultTableModel m = (DefaultTableModel)Kiosk.mainkiosk.table.getModel();
					m.insertRow(0, new Object[] {menu[j],price[j],count,price[j]*count}); //m�� �޴� ���� ���� �հ� �ֱ�
					Kiosk.mainkiosk.table.updateUI();
					
					ok[j].setEnabled(false);
					Kiosk.mainkiosk.total  = Kiosk.mainkiosk.total  + price[j]*count; // ���հ迡 �����ֱ�	
					suja[j].setText("0");
				}
				
			});
			
		}
	}

}

