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
	
	//테이블 생성
	static String []a = {"메뉴이름","가격","개수","합계"};
	static String [][]b;
	static DefaultTableModel model = new DefaultTableModel(b,a);
	static JTable table = new JTable(model);
	static DefaultTableModel m = (DefaultTableModel)table.getModel();
	static int total; //총합금액
	public mainkiosk() {
		
		setTitle("키오스크"); //제목설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫으면 종료
		Container c = getContentPane();
		JTabbedPane p = createTabbedPane(); //탭펜 p객체 생성
		p.setSize(0,0);
		Panel panel = new Panel();
	    panel.setBackground(Color.cyan);
	    
	    //버튼생성
	    Button bt1 = new Button("주문");
	    Button bt2 = new Button("초기화");
	    Button bt3 = new Button("닫기");
	    Button del = new Button("삭제");
	    
	    // 버튼 사용할수있도록
	    bt1.setEnabled(true);
	    bt2.setEnabled(true);
	    bt3.setEnabled(true);
	    del.setEnabled(true);
	    
	    //panel에 버튼추가
	    panel.add(bt1);
	    panel.add(bt2);
	    panel.add(bt3);
	    panel.add(del);
	    
	    
	   
	    //주문 버튼이벤트
	    bt1.addActionListener(new ActionListener() {
	    	 
            @Override
            public void actionPerformed(ActionEvent e) {
            
                JOptionPane.showMessageDialog(null,total+"\n"+" 주문되었습니다.");
               
                
            }
        });
	    // 초기화 버튼이벤트
	    bt2.addActionListener(new ActionListener() {
	    	 
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); //모든 항목사라짐
                total=0; // 총합금액은 0으로
                
            }
        });


	    // 종료 버튼이벤트
	    bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	    
	    // 삭제 버튼이벤트
	    del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = table.getSelectedRow(); //선택한 row받아오기
				int g = (int)model.getValueAt(n, 3); // 해당되는 rowd의 금액받아오기
				total = total-g; // 총합금액에서 row의 금액 빼기
				if(n<0)
					return ;
				else {
					model.removeRow(n); //해당되는 row삭제
					
				}
				
				
				
			}
			
		});
	    
	    
	    JScrollPane sc = new JScrollPane(table); //table에 scrollpane
	   
	    Font font = new Font(Font.MONOSPACED,Font.BOLD,15);
		table.setFont(font);
		
	    c.add(sc, BorderLayout.EAST); //윈도우에 sc추가
	
	    
        c.setBackground(Color.CYAN); //윈도우 창의 색깔 정하기
		c.add(p,BorderLayout.CENTER);//윈도우에 탭펜 p넣기
		c.add(panel, BorderLayout.SOUTH); // 윈도우에 panel넣기
		
		
		
		setSize(1200,900); //윈도우 크기설정
		setVisible(true); //실행가능하게하기
		
		
		
		
		
	}
	

	
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP); //탭펜 pane객체 설정
		pane.addTab("우동&모밀", new Udong()); //우동&모밀 Tab pane에 넣기
		pane.addTab("덮밥", new Rice()); //덮밥 Tab pane에 넣기
		pane.addTab("사이드", new Side()); //사이드 Tab pane에 넣기
		pane.addTab("음료", new Drink()); //음료 Tab pane에 넣기
		
		return pane;	
	
	}
	
	public static void main(String[] args) {
		new mainkiosk();
	}

	

}