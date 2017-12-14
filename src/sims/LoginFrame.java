package sims;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//public class LoginFrame extends MainFrame implements ActionListener{
public class LoginFrame extends JFrame{
	JLabel title=new JLabel("学生信息管理系统");
	JLabel userName=new JLabel("用户名：");
	JLabel passWord=new JLabel("密  码：");
	JButton login=new JButton("登录");
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
		//content.setLocation(getLocation());//让窗体居中显示
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		title.setBounds(30, 20, 745, 70);
		content.add(title);
		title.setFont(new java.awt.Font("新宋体", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		//top.setBorder(BorderFactory.createTitledBorder("分组框")); //设置面板边框，实现分组框的效果，此句代码为关键代码
		//top.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
		
		bg0.setIcon(bg);
		bg0.setBounds(0, 0, 800, 510);
		content.add(bg0);

		content.getLayeredPane().add(center, new Integer(Integer.MAX_VALUE));
		center.setLayout(null);
		center.setVisible(true);
		center.setBounds(200, 150, 400, 250);
		center.setBackground(new Color(0,0,0,90));	
		
		userName.setBounds(40, 40, 105, 30);
		userName.setFont(new java.awt.Font("宋体", Font.PLAIN, 25));
		nameText.setBounds(160,35, 180, 28);
		center.add(userName);
		center.add(nameText);
		
		passWord.setBounds(40, 105, 105, 30);
		passWord.setFont(new java.awt.Font("宋体", Font.PLAIN, 25));
		passText.setBounds(160,105, 180, 28);
		center.add(passWord);
		center.add(passText);
		
		center.add(login);
		login.setBounds(0, 205, 400, 45);
		login.setFont(new java.awt.Font("新宋体", Font.PLAIN, 20));
		//login.addActionListener(this);
		login.addActionListener(new LoginActionListener());
	}
	private class LoginActionListener implements ActionListener{
  		public void actionPerformed(ActionEvent e){
  			if(nameText.getText().equals("JasonLin")&& String.valueOf(passText.getPassword()).equals("971230")){
  				JOptionPane.showMessageDialog(null, "登录成功，欢迎到来！"); 
  				MainFrame m=new MainFrame();
  				m.FrameMain();
  				dispose();
  			}
  			else{
  				JOptionPane.showMessageDialog(null, "用户或密码错误！请重新登录！");  
                  nameText.setText("");   
                  passText.setText(""); 
  			}
  				
  		}
	}
	public static void main(String[] args) {
		new LoginFrame();
	}
}
