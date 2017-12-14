package sims;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//public class LoginFrame extends MainFrame implements ActionListener{
public class LoginFrame extends JFrame{
	JLabel title=new JLabel("ѧ����Ϣ����ϵͳ");
	JLabel userName=new JLabel("�û�����");
	JLabel passWord=new JLabel("��  �룺");
	JButton login=new JButton("��¼");
	ImageIcon bg=new ImageIcon("pics/bg0.jpg");
	JLabel bg0=new JLabel();
	JFrame content=new JFrame();
	JPanel center=new JPanel();
	JTextField nameText=new JTextField();
	JPasswordField passText=new JPasswordField();
	public LoginFrame(){
		content.setVisible(true);
		content.setLayout(null);
		content.setBounds(283,114,800, 540);
		//content.setLocation(getLocation());//�ô��������ʾ
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		title.setBounds(30, 20, 745, 70);
		content.add(title);
		title.setFont(new java.awt.Font("������", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		//top.setBorder(BorderFactory.createTitledBorder("�����")); //�������߿�ʵ�ַ�����Ч�����˾����Ϊ�ؼ�����
		//top.setBorder(BorderFactory.createLineBorder(Color.black));//�������߿���ɫ
		
		bg0.setIcon(bg);
		bg0.setBounds(0, 0, 800, 510);
		content.add(bg0);

		content.getLayeredPane().add(center, new Integer(Integer.MAX_VALUE));
		center.setLayout(null);
		center.setVisible(true);
		center.setBounds(200, 150, 400, 250);
		center.setBackground(new Color(0,0,0,90));	
		
		userName.setBounds(40, 40, 105, 30);
		userName.setFont(new java.awt.Font("����", Font.PLAIN, 25));
		nameText.setBounds(160,35, 180, 28);
		center.add(userName);
		center.add(nameText);
		
		passWord.setBounds(40, 105, 105, 30);
		passWord.setFont(new java.awt.Font("����", Font.PLAIN, 25));
		passText.setBounds(160,105, 180, 28);
		center.add(passWord);
		center.add(passText);
		
		center.add(login);
		login.setBounds(0, 205, 400, 45);
		login.setFont(new java.awt.Font("������", Font.PLAIN, 20));
		//login.addActionListener(this);
		login.addActionListener(new LoginActionListener());
	}
	private class LoginActionListener implements ActionListener{
  		public void actionPerformed(ActionEvent e){
  			if(nameText.getText().equals("JasonLin")&& String.valueOf(passText.getPassword()).equals("971230")){
  				JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ������"); 
  				MainFrame m=new MainFrame();
  				m.FrameMain();
  				dispose();
  			}
  			else{
  				JOptionPane.showMessageDialog(null, "�û���������������µ�¼��");  
                  nameText.setText("");   
                  passText.setText(""); 
  			}
  				
  		}
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}
