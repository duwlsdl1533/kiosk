package Kiosk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import Kiosk.Udong;
import Kiosk.Side;
import Kiosk.Rice;
import Kiosk.Drink;


public class mainkiosk extends JFrame{
	
	//���̺� ����
	static String []a = {"�޴��̸�","����","����","�հ�"};
	static String [][]b;
	static DefaultTableModel model = new DefaultTableModel(b,a);
	static JTable table = new JTable(model);
	static DefaultTableModel m = (DefaultTableModel)table.getModel();
	static int total; //���ձݾ�
	public mainkiosk() {
		
		setTitle("Ű����ũ"); //������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â������ ����
		Container c = getContentPane();
		JTabbedPane p = createTabbedPane(); //���� p��ü ����
		p.setSize(0,0);
		Panel panel = new Panel();
	    panel.setBackground(Color.cyan);
	    
	    //��ư����
	    Button bt1 = new Button("�ֹ�");
	    Button bt2 = new Button("�ʱ�ȭ");
	    Button bt3 = new Button("�ݱ�");
	    Button del = new Button("����");
	    
	    // ��ư ����Ҽ��ֵ���
	    bt1.setEnabled(true);
	    bt2.setEnabled(true);
	    bt3.setEnabled(true);
	    del.setEnabled(true);
	    
	    //panel�� ��ư�߰�
	    panel.add(bt1);
	    panel.add(bt2);
	    panel.add(bt3);
	    panel.add(del);
	    
	    
	   
	    //�ֹ� ��ư�̺�Ʈ
	    bt1.addActionListener(new ActionListener() {
	    	 
            @Override
            public void actionPerformed(ActionEvent e) {
            
                JOptionPane.showMessageDialog(null,total+"\n"+" �ֹ��Ǿ����ϴ�.");
               
                
            }
        });
	    // �ʱ�ȭ ��ư�̺�Ʈ
	    bt2.addActionListener(new ActionListener() {
	    	 
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); //��� �׸�����
                total=0; // ���ձݾ��� 0����
                
            }
        });


	    // ���� ��ư�̺�Ʈ
	    bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	    
	    // ���� ��ư�̺�Ʈ
	    del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = table.getSelectedRow(); //������ row�޾ƿ���
				int g = (int)model.getValueAt(n, 3); // �ش�Ǵ� rowd�� �ݾ׹޾ƿ���
				total = total-g; // ���ձݾ׿��� row�� �ݾ� ����
				if(n<0)
					return ;
				else {
					model.removeRow(n); //�ش�Ǵ� row����
					
				}
				
				
				
			}
			
		});
	    
	    
	    JScrollPane sc = new JScrollPane(table); //table�� scrollpane
	   
	    Font font = new Font(Font.MONOSPACED,Font.BOLD,15);
		table.setFont(font);
		
	    c.add(sc, BorderLayout.EAST); //�����쿡 sc�߰�
	
	    
        c.setBackground(Color.CYAN); //������ â�� ���� ���ϱ�
		c.add(p,BorderLayout.CENTER);//�����쿡 ���� p�ֱ�
		c.add(panel, BorderLayout.SOUTH); // �����쿡 panel�ֱ�
		
		
		
		setSize(1200,900); //������ ũ�⼳��
		setVisible(true); //���డ���ϰ��ϱ�
		
		
		
		
		
	}
	

	
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP); //���� pane��ü ����
		pane.addTab("�쵿&���", new Udong()); //�쵿&��� Tab pane�� �ֱ�
		pane.addTab("����", new Rice()); //���� Tab pane�� �ֱ�
		pane.addTab("���̵�", new Side()); //���̵� Tab pane�� �ֱ�
		pane.addTab("����", new Drink()); //���� Tab pane�� �ֱ�
		
		return pane;	
	
	}
	
	public static void main(String[] args) {
		new mainkiosk();
	}

	

}