package Kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import Kiosk.mainkiosk;

public class Udong extends JPanel{
	static int total = 0;
	int count=0;
	String show="";
	Font f_1=new Font(Font.SANS_SERIF,Font.PLAIN,13); //��Ʈ����
	Font f_2=new Font(Font.MONOSPACED,Font.BOLD,13);  //��Ʈ����
	
	String menu[] = {"�����쵿","�ø��","��ġ�쵿","��äƢ��쵿","�����쵿","Ƣ���쵿","����Ƣ��쵿","ī���쵿","�ҺҰ��쵿","�ÿ쵿","��ū�쵿","������"}; //�޴��迭����
	int price[] = { 3500,5000,4000,5000,4500,5000,5000,5500,5500,5000,5000,5500}; //���ݹ迭����
	
	JButton bt[]=new JButton[menu.length]; //��ư�迭����
	ImageIcon icon[] = new ImageIcon[menu.length]; //�����ܹ迭����
	Label L1[] = new Label[menu.length]; //label�迭����
	Label L2[] = new Label[menu.length]; //label�迭����
	Button minus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	Button plus[] = new Button[menu.length]; //���̰� �޴������� ��ư�迭����
	JButton ok[] = new JButton[menu.length]; //���̰� �޴������� ��ư�迭����
	TextField suja[] = new TextField[menu.length]; //���̰� �޴������� textfield�迭����
	DefaultTableModel m = (DefaultTableModel)Kiosk.mainkiosk.table.getModel();
	
	public Udong() {
		this.setLayout(null);
		this.setBackground(Color.WHITE); //panel��� ������ �Ͼ������ �Ѵ�.
		
		for(int i=0; i<menu.length; i++) { //for���� �޴�������ŭ ������.  
			bt[i]=new JButton(menu[i]); //�޴��� ���� ��ư����.
			if(i<4) {
				bt[i].setBounds(20*(i+1)+i*150,20,150,150); //�ε���3������ ù�ٿ� �����Ѵ�.
			}
			else if(i<8){
				bt[i].setBounds(20*(i-3)+(i-4)*150,260, 150, 150); //�ε��� 7������ �ι�°�ٿ� �����Ѵ�.
			}
			else if(i<12) {
				bt[i].setBounds(20*(i-7)+(i-8)*150, 500, 150, 150); //�ε��� 11������ ����°�ٿ� �����Ѵ�.
			}
			icon[i]=new ImageIcon("�쵿/Udong"+i+".PNG"); //�����ܹ迭�� �̹����� �ִ´�.
			bt[i].setIcon(icon[i]); //��ư�� �̹����� �߰��� �������� �ִ´�.
			
	
			L1[i]=new Label(menu[i]); //�޴� label����
			L2[i]=new Label(price[i]+"��"); //���� label����
			L1[i].setBounds(bt[i].getX()+20, bt[i].getY()+150, 100, 20); //�޴� ��ġ, ũ�� ����
			L2[i].setBounds(bt[i].getX()+20, bt[i].getY()+170, 100, 20); //���� ��ġ, ũ�� ����
			
			// ���� txt ��ư
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
            
     



			L1[i].setFont(f_2); //�޴� ��Ʈ�� �ִ´�.
			L2[i].setFont(f_1); //���� ��Ʈ�� �ִ´�.
			
			//Udong�� ��ư �߰�
			this.add(bt[i]);  
			this.add(L1[i]); 
			this.add(L2[i]); 
			this.add(suja[i]);
			this.add(minus[i]);
			this.add(plus[i]);
			this.add(ok[i]);
		}
		
		
		// TODO Auto-generated method stub
		for (int i = 0; i < menu.length; i++) {
			 int j = i;
			 // ��ư 
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
					m.insertRow(0, new Object[] {menu[j],price[j],count,price[j]*count}); //m�� �޴� ���� ���� �հ� �ֱ�
					Kiosk.mainkiosk.table.updateUI();
					
					ok[j].setEnabled(false);
					Kiosk.mainkiosk.total = Kiosk.mainkiosk.total + price[j]*count; // ���հ迡 �����ֱ�
					suja[j].setText("0");
					
				}
				
				
			});
			 
			 	
			 
		}	
		
		
		
	}
}
