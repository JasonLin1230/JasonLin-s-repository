package sims;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel title=new JLabel("学生信息管理系统");
	JLabel menu=new JLabel("系统菜单");
	protected JButton query=new JButton("查询信息");
	protected JButton add=new JButton("增加信息");
	protected JButton upd=new JButton("修改/删除");
	//protected JButton del=new JButton("删除信息");
	protected JButton exit=new JButton("退出程序"); 
	JFrame content=new JFrame();
	Container contentPane=this.getContentPane();
	ImageIcon bg=new ImageIcon("pics/bg01.jpg");
	JLabel bg0=new JLabel();
	
	public Point getLocation(){//让窗体居中显示的方法
		Toolkit toolKit=Toolkit.getDefaultToolkit();//获得ToolKit实例
		Dimension screenSize=toolKit.getScreenSize();//获得显示器大小
		int x=(screenSize.width-800)/2;
		int y=(screenSize.height-540)/2;
		return new Point(x,y);
	}
	public void FrameMain(){
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(0,0,800, 540);
		this.setLocation(getLocation());
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		title.setBounds(30, 20, 745, 70);
		contentPane.add(title);
		title.setFont(new java.awt.Font("新宋体", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		
		contentPane.add(query);
		query.setBounds(235, 230, 125, 55);
		query.setFont(new java.awt.Font("宋体", Font.PLAIN, 20));
		contentPane.add(add);
		add.setBounds(445, 230, 125, 55);
		add.setFont(new java.awt.Font("宋体", Font.PLAIN, 20));
		contentPane.add(upd);
		upd.setBounds(235, 330, 125, 55);
		upd.setFont(new java.awt.Font("宋体", Font.PLAIN, 20));
		contentPane.add(exit);
		exit.setBounds(445, 330, 125, 55);
		exit.setFont(new java.awt.Font("宋体", Font.PLAIN, 20));
		
		bg0.setIcon(bg);
		bg0.setBounds(0, 0, 800, 510);
		contentPane.add(bg0);
		//content.getLayeredPane().add(bg0, new Integer(Integer.MIN_VALUE));
	
		add.addActionListener(new AddActionListener());
		upd.addActionListener(new UpdActionListener());
		query.addActionListener(new QueryActionListener());
		exit.addActionListener(new ExitActionListener());

	}
	
	private class AddActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				// TODO 自动生成的方法存根
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
				// TODO 自动生成的方法存根
				try{
					SavedInfFrame s=new SavedInfFrame();
					dispose();
					s.Top();
					List<InfBean> results=JdbcHelper.queryAll();
					s.table(results);
					s.upd_Btn();
					s.delete_Btn();
					s.return_Btn();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
	}
	private class QueryActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				QueryFrame q=new QueryFrame();
				dispose();
				q.Top();
				q.Center();
				q.addpho();
				q.query_Btn();
				q.clear_Btn();
				q.return_Btn();
			}
	}
	private class ExitActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				int n;
				n=JOptionPane.showConfirmDialog(null, "是否确认退出程序？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				switch(n){
				case -1:
				case 2:
					return;
				case 0:
					System.exit(0);
				}
			}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MainFrame m=new MainFrame();
		m.FrameMain();
	}

}

