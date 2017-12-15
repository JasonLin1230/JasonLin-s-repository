package sims;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class AddInfFrame extends MainFrame{
	private static final long serialVersionUID = 1L;
	JLabel stuName=new JLabel("姓名：");
	public JTextField na=new JTextField(18);
	JLabel stuClass=new JLabel("班级：");
	public JTextField cla=new JTextField(18);
	JLabel stuSex=new JLabel("性别：");
	public JRadioButton s1=new JRadioButton("男",true);
	public JRadioButton s2=new JRadioButton("女",false);
	ButtonGroup buttonGroup=new ButtonGroup();
	JLabel stuNum=new JLabel("学号：");
	public JTextField num=new JTextField(18);
	JLabel stuPhone=new JLabel("手机：");
	public JTextField pho=new JTextField(18);
	JLabel stuDor=new JLabel("宿舍：");
	public JTextField dor=new JTextField(18);
	JLabel stuBirth=new JLabel("生日：");
	public JTextField bir=new JTextField(18);
	JLabel stuHome=new JLabel("原籍：");
	public JTextField hom=new JTextField(18);
	public JButton savebtn=new JButton("确认");
	public JButton clearbtn=new JButton("清除");
	public JButton returnbtn=new JButton("返回");
	public JLabel photoLabel=new JLabel();
	JLabel stuNote=new JLabel("备注");
	static JTextArea note=new JTextArea();
	public void Center(){
		JPanel center=new JPanel();
		JPanel infPanel=new JPanel();
		JPanel photoPanel=new JPanel();
		content.add(center);
		center.setLayout(null);
		center.setBounds(25, 95, 750, 390);
		center.setBackground(new Color(171,196,252));
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		center.add(infPanel);//添加信息填写区域
		infPanel.setLayout(null);
		infPanel.setBounds(5, 5, 590, 200);
		infPanel.setBackground(new Color(171,196,252));
		//图片区域的实现
		center.add(photoPanel);//添加照片区域
		photoPanel.setBounds(600, 5, 140, 200);
		photoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		photoPanel.add(photoLabel);
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setPreferredSize(new Dimension(150,200));
		/*if(UPDATE_RECORD==null||UPDATE_RECORD.getPhoto()==null){
			photoLabel.setText("双击添加照片");
		}else{
			URL url=this.getClass().getResource("/personal_photo/");
			String photo =url.toString().substring(5)+UPDATE_RECORD.getPhoto();
			photoLabel.setIcon(new ImageIcon(photo));
		}*/
		
		center.add(stuNote);
		stuNote.setBounds(320, 210, 75, 40);
		stuNote.setFont(new java.awt.Font("微软雅黑", Font.PLAIN, 20));
		center.add(note);
		note.setBounds(10, 250, 730, 100);
		note.setBorder(BorderFactory.createLineBorder(Color.black));
		center.add(savebtn);
		savebtn.setBounds(150, 355, 80, 30);
		center.add(clearbtn);
		clearbtn.setBounds(300, 355, 80, 30);
		center.add(returnbtn);
		returnbtn.setBounds(450, 355, 80, 30);
		
		infPanel.add(stuName);
		stuName.setBounds(25,10,70,45);
		infPanel.add(na);
		na.setBounds(80,10,190,35);
		infPanel.add(stuSex);
		stuSex.setBounds(320,10,70,45);
		buttonGroup.add(s1);
		buttonGroup.add(s2);
		infPanel.add(s1);
		infPanel.add(s2);
		s1.setBounds(410, 15, 60, 35);
		s2.setBounds(470, 15, 60, 35);
		
		infPanel.add(stuClass);
		stuClass.setBounds(25,60,70,45);
		infPanel.add(cla);
		cla.setBounds(80,60,190,35);
		infPanel.add(stuNum);
		stuNum.setBounds(320,60,70,45);
		infPanel.add(num);
		num.setBounds(380,60,190,35);
		
		infPanel.add(stuDor);
		stuDor.setBounds(25,110,70,45);
		infPanel.add(dor);
		dor.setBounds(80,110,190,35);
		infPanel.add(stuPhone);
		stuPhone.setBounds(320,110,70,45);
		infPanel.add(pho);
		pho.setBounds(380,110,190,35);
		
		infPanel.add(stuBirth);
		stuBirth.setBounds(25,160,70,45);
		infPanel.add(bir);
		bir.setBounds(80,160,190,35);
		infPanel.add(stuHome);
		stuHome.setBounds(320,160,70,45);
		infPanel.add(hom);
		hom.setBounds(380,160,190,35);
		
		content.setVisible(true);
		content.setBounds(0,0,800, 540);
		content.setLocation(getLocation());//让窗体居中显示
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void addpho(){
		//图片添加事件
		photoLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					JFileChooser fileChooser=new JFileChooser();
					fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
						public String getDescription(){
							return "图像文件(.jpg)";
						}
						public boolean accept(File file){
							if(file.isDirectory())
								return true;
							String fileName=file.getName().toLowerCase();
							if(fileName.endsWith(".jpg"))
								return true;
							return false;
						}
					});
					int i=fileChooser.showOpenDialog(null);
					if(i==JFileChooser.APPROVE_OPTION){
						File file=fileChooser.getSelectedFile();
						if(file!=null){
							ImageIcon icon=new ImageIcon(file.getAbsolutePath());
							photoLabel.setText(null);
							photoLabel.setIcon(icon);
						}
					}
				}
			}
		});
	}
	
	// public AddInfFrame(){
	// 	this.addWindowListener(new MyWindowListener());
	// }
	// public class MyWindowListener implements WindowListener{
	// 	public void windowClosing(WindowEvent e){
	// 		int n;
	// 		n=JOptionPane.showConfirmDialog(null, "是否确认退出程序？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
	// 		switch(n){
	// 		case -1:
	// 		case 2:
	// 			return;
	// 		case 0:
	// 			System.exit(0);
	// 		}
	// 	}

	// 	@Override
	// 	public void windowOpened(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}

	// 	@Override
	// 	public void windowClosed(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}

	// 	@Override
	// 	public void windowIconified(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}

	// 	@Override
	// 	public void windowDeiconified(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}

	// 	@Override
	// 	public void windowActivated(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}

	// 	@Override
	// 	public void windowDeactivated(WindowEvent e) {
	// 		// TODO 自动生成的方法存根
			
	// 	}
	// }
	public void save_Btn(){
		
		//保存按钮事件
		savebtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				do_saveBtn_actionPerformed(e);
			}
			protected void do_saveBtn_actionPerformed(ActionEvent e) {
				String stuName=na.getText().trim();
				if(stuName.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生姓名不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuSex="";
				if(s1.isSelected()){
					stuSex="男";
				}else if(s2.isSelected()){
					stuSex="女";
				}
				String stuClass=cla.getText().trim();
				if(stuClass.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生班级不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuNum=num.getText().trim();
				if(stuNum.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生学号不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuDor=dor.getText().trim();
				if(stuDor.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生宿舍不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuPho=pho.getText().trim();
				if(stuPho.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生手机不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuBirth=bir.getText().trim();
				if(stuBirth.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生生日不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuHome=hom.getText().trim();
				if(stuHome.isEmpty()){
					JOptionPane.showMessageDialog(null, "学生原籍不能为空！","警告！",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				InfBean info=new InfBean();
				info.setStuName(stuName);
				info.setStuSex(stuSex);
				info.setStuClass(stuClass);
				info.setStuNum(stuNum);
				info.setStuPhone(stuPho);
				info.setStuDor(stuDor);
				info.setStuBirth(stuBirth);
				info.setStuHome(stuHome);
				int result=JdbcHelper.save(info);
				if(result>=0){
					JOptionPane.showMessageDialog(null, "成绩增加成功！");
					return;
				}else{
					JOptionPane.showMessageDialog(null, "成绩增加失败！");
					return;
				}
			}
		});
	}
	public void clear_Btn(){
		clearbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_clearBtn_actionPerformed(e);
			}
			private void do_clearBtn_actionPerformed(ActionEvent e) {
				na.setText("");
				cla.setText("");
				num.setText("");
				pho.setText("");
				dor.setText("");
				bir.setText("");
				hom.setText("");
				note.setText("");
				s1.setSelected(true);
			}
		});
	}
	public void return_Btn(){
		returnbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				// TODO 自动生成的方法存根
				int n=JOptionPane.showConfirmDialog(null, "确认返回？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				switch(n){
				case -1:
				case 2:
					return;
				case 0:
					dispose();
					//System.exit(0);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		AddInfFrame ail=new AddInfFrame();
		ail.Top();
		ail.Center();
		ail.addpho();
		ail.save_Btn();
		ail.clear_Btn();
		ail.return_Btn();
	}
}

