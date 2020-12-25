package Kiosk;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Drink extends JPanel{
	static int total = 0;
	int count = 0;
	String show = "";
	Font f_1=new Font(Font.SANS_SERIF,Font.PLAIN,15); //��Ʈ����
	Font f_2=new Font(Font.MONOSPACED,Font.BOLD,15);  //��Ʈ����

	String menu[] = {"�ݶ�","���̴�","����Ŭ�����","����Ŭ������","Ʈ����","��Ű��","����"}; //�޴��迭����
	int price[] = {2000,2000,2000,2000,2000,2000,2000}; //���ݹ迭����
	
	JButton bt[]=new JButton[menu.length]; //���̰� �޴������� ��ư�迭����
	ImageIcon icon[] = new ImageIcon[menu.length]; //���̰� �޴������� �����ܹ迭����
	Label L1[] = new Label[menu.length]; //���̰� �޴������� label�迭����
	Label L2[] = new Label[menu.length]; //���̰� �޴������� label�迭����
	Button minus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	Button plus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	JButton ok[] = new JButton[menu.length]; //���̰� �޴������� ��ư�迭����
	TextField suja[] = new TextField[menu.length]; //���̰� �޴������� textfield�迭����
	
	public Drink() {
		this.setLayout(null);
		this.setBackground(Color.WHITE); //panel��� ������ �Ͼ������ �Ѵ�.
		
		for(int i=0; i<menu.length; i++) {
			bt[i]=new JButton(menu[i]);
			if(i<4) {
				bt[i].setBounds(37*(i+1)+i*130,20,130,200); //�ε��� 4������ ù�ٿ� �����Ѵ�.
			}
			else if(i<8){
				bt[i].setBounds(37*(i-3)+(i-4)*130, 310, 130, 200); //�������� �ι�°�ٿ� �����Ѵ�.
			}
			
			icon[i]=new ImageIcon("����/Drink"+i+".PNG"); //�����ܿ� �̹����� �ִ´�.
			bt[i].setIcon(icon[i]); //�̹����� ���� �������� ��ư�� �ִ´�. 
			
			L1[i]=new Label(menu[i]); //�޴�label �迭����
			L2[i]=new Label(price[i]+"��"); //����label �迭����
			L1[i].setBounds(bt[i].getX()+10, bt[i].getY()+200, 110, 20); //�޴���ġ�� ���ڱ��̼���
			L1[i].setFont(f_2); //�޴����弳��
			L2[i].setBounds(bt[i].getX()+10, bt[i].getY()+220, 110, 20); //������ġ�� ���ڱ��̼���
			L2[i].setFont(f_1); //������Ʈ����
			
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(L2[i].getX()+20, L2[i].getY()+20, 40, 20);
	            
			 // "-" ��ư
			minus[i] = new Button("-");
			minus[i].setBounds(suja[i].getX()-20, suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);
			 
			 // "+" ��ư
			plus[i] = new Button("+");
			plus[i].setBounds(suja[i].getX()+40, suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);
	 
			 // Ȯ�� ��ư
			ok[i] = new JButton("Ȯ��");
			ok[i].setBounds(minus[i].getX(), suja[i].getY() + 20, 100, 20);
			ok[i].setEnabled(false);
			
			// Drink�� ��ư�߰�
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
			 
			 // - ��ư�̺�Ʈ
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
			
			 // Ȯ�ι�ư �̺�Ʈ
			ok[i].addActionListener(new ActionListener() {

				@Override 
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					DefaultTableModel m = (DefaultTableModel)Kiosk.mainkiosk.table.getModel();
					m.insertRow(0, new Object[] {menu[j],price[j],count,price[j]*count}); //m�� �޴� ���� ���� �հ� �ֱ�
					Kiosk.mainkiosk.table.updateUI();
					
					ok[j].setEnabled(false);
					Kiosk.mainkiosk.total = Kiosk.mainkiosk.total  + price[j]*count;	// �� �հ迡 �����ֱ�
					suja[j].setText("0");
				}
				
			});
			
		}
	}

}