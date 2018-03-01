package sims;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.*;
public class MainFrame extends JFrame{
	JLabel title=new JLabel("ѧ����Ϣ����ϵͳ");
	JLabel menu=new JLabel("ϵͳ�˵�");
	protected JButton query=new JButton("��ѯ��Ϣ");
	protected JButton add=new JButton("������Ϣ");
	protected JButton upd=new JButton("�޸�/ɾ��");
	//protected JButton del=new JButton("ɾ����Ϣ");
	protected JButton exit=new JButton("�˳�����");
	JFrame content=new JFrame();
	
	ImageIcon bg=new ImageIcon("pics/bg01.jpg");
	JLabel bg0=new JLabel();
//	JPanel center=new JPanel();
	
	public Point getLocation(){//�ô��������ʾ�ķ���
		Toolkit toolKit=Toolkit.getDefaultToolkit();//���ToolKitʵ��
		Dimension screenSize=toolKit.getScreenSize();//�����ʾ����С
		int x=(screenSize.width-800)/2;
		int y=(screenSize.height-540)/2;
		return new Point(x,y);
	}
	public void Top(){
		content.setLayout(null);
		JPanel top=new JPanel();				
		content.add(top);   //�ϲ������
		top.setBounds(25, 25, 750, 70);
		top.add(title);
		title.setFont(new java.awt.Font("������", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		top.setBorder(BorderFactory.createTitledBorder("�����")); //�������߿�ʵ�ַ�����Ч�����˾����Ϊ�ؼ�����
		top.setBorder(BorderFactory.createLineBorder(Color.black));//�������߿���ɫ
	}
//	public void Left(){
//		JPanel left=new JPanel();
//		content.add(left);     //�󲿵����
//		left.setBounds(25, 85, 120, 400);
//		left.setLayout(null); 
//		left.add(menu);
//		left.add(query);
//		left.add(add);
//		left.add(upd);
//		//left.add(del);
//		left.add(exit);
//		menu.setFont(new java.awt.Font("������", Font.PLAIN, 20));
//		menu.setBounds(25, 30, 100, 30);
//		query.setBounds(20, 75, 90, 30);
//		add.setBounds(20, 120, 90, 30);
//		upd.setBounds(20, 165, 90, 30);
//		//del.setBounds(20, 210, 90, 30);
//		//exit.setBounds(20, 255, 90, 30);
//		exit.setBounds(20, 210, 90, 30);
//		left.setBorder(BorderFactory.createLineBorder(Color.black)); 
//	}
//	public void Center(){
//		JPanel center=new JPanel();
//		content.add(center);          //�м�����
//		center.setBounds(145, 85, 630, 400);
//		photo.setIcon(bg);
//		center.add(photo);
//		//photo.setBounds(0, 0, 620, 390);
//		center.setBorder(BorderFactory.createLineBorder(Color.black)); 
//		content.setVisible(true);
//		content.setBounds(0,0,800, 540);
//		content.setLocation(getLocation());//�ô��������ʾ
//		content.setResizable(false);
//		content.setBackground(new Color(192,255,247));
//		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	
	public void FrameMain(){
		content.setVisible(true);
		content.setLayout(null);
		content.setBounds(0,0,800, 540);
		content.setLocation(getLocation());
		//content.setLocation(getLocation());//�ô��������ʾ
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title.setBounds(30, 20, 745, 70);
		content.add(title);
		title.setFont(new java.awt.Font("������", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		//top.setBorder(BorderFactory.createTitledBorder("�����")); //�������߿�ʵ�ַ�����Ч�����˾����Ϊ�ؼ�����
		//top.setBorder(BorderFactory.createLineBorder(Color.black));//�������߿���ɫ
		content.add(query);
		query.setBounds(235, 230, 125, 55);
		query.setFont(new java.awt.Font("����", Font.PLAIN, 20));
		content.add(add);
		add.setBounds(445, 230, 125, 55);
		add.setFont(new java.awt.Font("����", Font.PLAIN, 20));
		content.add(upd);
		upd.setBounds(235, 330, 125, 55);
		upd.setFont(new java.awt.Font("����", Font.PLAIN, 20));
		content.add(exit);
		exit.setBounds(445, 330, 125, 55);
		exit.setFont(new java.awt.Font("����", Font.PLAIN, 20));
		
		bg0.setIcon(bg);
		bg0.setBounds(0, 0, 800, 510);
		content.add(bg0);
		//content.getLayeredPane().add(bg0, new Integer(Integer.MIN_VALUE));
	
		add.addActionListener(new AddActionListener());
		upd.addActionListener(new UpdActionListener());
		query.addActionListener(new QueryActionListener());
		exit.addActionListener(new ExitActionListener());

	}
	
	private class AddActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				// TODO �Զ����ɵķ������
				try{
					AddInfFrame a=new AddInfFrame();
					dispose();
					a.Top();
					a.Center();
					a.addpho();
					a.save_Btn();
					a.clear_Btn();
					a.return_Btn();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
	}
	private class UpdActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try{
					SavedInfFrame s=new SavedInfFrame();
					dispose();
					s.setAlwaysOnTop(true);
					s.Top();
					s.table();
					s.upd_Btn();
					s.delete_Btn();
					s.return_Btn(s);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
	}
	private class QueryActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				QueryFrame q=new QueryFrame();
				q.Top();
				q.Center();
				q.addpho();
				q.save_Btn();
				q.clear_Btn();
				q.return_Btn();
			}
	}
	private class ExitActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int n;
				n=JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ���˳�����", "����",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				switch(n){
				case -1:
				case 2:
					return;
				case 0:
					System.exit(0);
				}
			}
	}
//	public void mainFrame(){
//		MainFrame m=new MainFrame();
//		m.FrameMain();
//	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MainFrame m=new MainFrame();
		m.FrameMain();
//		m.Top();
//		m.Left();
//		m.Center();
//		m.addBtn();
//		m.updBtn();
//		m.queryBtn();
//		m.exitBtn();
	}

}

