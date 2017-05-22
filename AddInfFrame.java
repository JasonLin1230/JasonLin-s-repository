package sims;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import sims.CloseWindowListener;

public class AddInfFrame extends MainFrame{
	private static final long serialVersionUID = 1L;
	JLabel stuName=new JLabel("������");
	public JTextField na=new JTextField(18);
	JLabel stuClass=new JLabel("�༶��");
	public JTextField cla=new JTextField(18);
	JLabel stuSex=new JLabel("�Ա�");
	public JRadioButton s1=new JRadioButton("��",false);
	public JRadioButton s2=new JRadioButton("Ů",false);
	ButtonGroup buttonGroup=new ButtonGroup();
	JLabel stuNum=new JLabel("ѧ�ţ�");
	public JTextField num=new JTextField(18);
	JLabel stuPhone=new JLabel("�ֻ���");
	public JTextField pho=new JTextField(18);
	JLabel stuDor=new JLabel("���᣺");
	public JTextField dor=new JTextField(18);
	JLabel stuBirth=new JLabel("���գ�");
	public JTextField bir=new JTextField(18);
	JLabel stuHome=new JLabel("ԭ����");
	public JTextField hom=new JTextField(18);
	public JButton savebtn=new JButton("ȷ��");
	public JButton clearbtn=new JButton("���");
	public JButton returnbtn=new JButton("����");
	public JLabel photoLabel=new JLabel();
	JLabel stuNote=new JLabel("��ע");
	static JTextArea note=new JTextArea();
	public void Center(){
		JPanel center=new JPanel();
		JPanel infPanel=new JPanel();
		JPanel photoPanel=new JPanel();
		contentPane.add(center);
		center.setLayout(null);
		center.setBounds(25, 95, 750, 390);
		center.setBackground(new Color(171,196,252));
		center.setBorder(BorderFactory.createLineBorder(Color.black));
		//center.setBackground(Color.BLACK);
		center.add(infPanel);//�����Ϣ��д����
		infPanel.setLayout(null);
		infPanel.setBounds(5, 5, 590, 200);
		infPanel.setBackground(new Color(171,196,252));
		//infPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//ͼƬ�����ʵ��
		center.add(photoPanel);//�����Ƭ����
		photoPanel.setBounds(600, 5, 140, 200);
		photoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//photoPanel.setBackground(new Color(192,255,247));
		photoPanel.add(photoLabel);
		photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoLabel.setPreferredSize(new Dimension(150,200));
		/*if(UPDATE_RECORD==null||UPDATE_RECORD.getPhoto()==null){
			photoLabel.setText("˫�������Ƭ");
		}else{
			URL url=this.getClass().getResource("/personal_photo/");
			String photo =url.toString().substring(5)+UPDATE_RECORD.getPhoto();
			photoLabel.setIcon(new ImageIcon(photo));
		}*/
		
		center.add(stuNote);
		stuNote.setBounds(320, 210, 75, 40);
		stuNote.setFont(new java.awt.Font("΢���ź�", Font.PLAIN, 20));
		center.add(note);
		note.setBounds(10, 250, 730, 100);
		note.setText("");
		note.setBorder(BorderFactory.createLineBorder(Color.black));
		center.add(savebtn);
		savebtn.setFont(new Font("΢���ź�",Font.PLAIN,14));
		savebtn.setBounds(150, 355, 80, 30);
		center.add(clearbtn);
		clearbtn.setFont(new Font("΢���ź�",Font.PLAIN,14));
		clearbtn.setBounds(300, 355, 80, 30);
		center.add(returnbtn);
		returnbtn.setFont(new Font("΢���ź�",Font.PLAIN,14));
		returnbtn.setBounds(450, 355, 80, 30);
		
		infPanel.add(stuName);
		stuName.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuName.setBounds(25,10,70,45);
		infPanel.add(na);
		na.setBounds(80,10,190,35);
		infPanel.add(stuSex);
		stuSex.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuSex.setBounds(320,10,70,45);
		buttonGroup.add(s1);
		buttonGroup.add(s2);
		infPanel.add(s1);
		infPanel.add(s2);
		s1.setFont(new Font("΢���ź�",Font.PLAIN,14));
		s1.setBounds(410, 15, 60, 35);
		s2.setFont(new Font("΢���ź�",Font.PLAIN,14));
		s2.setBounds(470, 15, 60, 35);
		
		infPanel.add(stuClass);
		stuClass.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuClass.setBounds(25,60,70,45);
		infPanel.add(cla);
		cla.setBounds(80,60,190,35);
		infPanel.add(stuNum);
		stuNum.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuNum.setBounds(320,60,70,45);
		infPanel.add(num);
		num.setBounds(380,60,190,35);
		
		infPanel.add(stuDor);
		stuDor.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuDor.setBounds(25,110,70,45);
		infPanel.add(dor);
		dor.setBounds(80,110,190,35);
		infPanel.add(stuPhone);
		stuPhone.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuPhone.setBounds(320,110,70,45);
		infPanel.add(pho);
		pho.setBounds(380,110,190,35);
		
		infPanel.add(stuBirth);
		stuBirth.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuBirth.setBounds(25,160,70,45);
		infPanel.add(bir);
		bir.setBounds(80,160,190,35);
		infPanel.add(stuHome);
		stuHome.setFont(new Font("΢���ź�",Font.PLAIN,14));
		stuHome.setBounds(320,160,70,45);
		infPanel.add(hom);
		hom.setBounds(380,160,190,35);
		
		this.setVisible(true);
		this.setBounds(0,0,800, 540);
		this.setLocation(getLocation());//�ô��������ʾ
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	public void Top(){
		contentPane.setLayout(null);
		JPanel top=new JPanel();				
		contentPane.add(top);   //�ϲ������
		top.setBounds(25, 25, 750, 70);
		top.add(title);
		title.setFont(new java.awt.Font("������", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		top.setBorder(BorderFactory.createLineBorder(Color.black));//�������߿���ɫ
	}
	
	public void addpho(){
		//ͼƬ����¼�
		photoLabel.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(e.getClickCount()==2){
					JFileChooser fileChooser=new JFileChooser();
					fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
						public String getDescription(){
							return "ͼ���ļ�(.jpg)";
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
	
	public AddInfFrame(){
		//JOptionPane.showMessageDialog(null, "������Ϣʱ��ѧ��¼��󲻵ø��ģ�������ȷ�Ϻ����룡","��ܰ��ʾ��",JOptionPane.WARNING_MESSAGE);
		this.addWindowListener(new CloseWindowListener());
		//addWindowListener(new OpenWindowListener());
		//this.addWindowListener(new OpenWindowListener());
	}
	public void save_Btn(){
		
		//���水ť�¼�
		savebtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				do_saveBtn_actionPerformed(e);
			}
			protected void do_saveBtn_actionPerformed(ActionEvent e) {
				String stuName=na.getText().trim();
				if(stuName.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ����������Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuSex="";
				if(s1.isSelected()){
					stuSex="��";
				}else if(s2.isSelected()){
					stuSex="Ů";
				}else{
					JOptionPane.showMessageDialog(null, "ѧ���Ա���Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuClass=cla.getText().trim();
				if(stuClass.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ���༶����Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuNum=num.getText().trim();
				if(stuNum.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ��ѧ�Ų���Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuDor=dor.getText().trim();
				if(stuDor.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ�����᲻��Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuPho=pho.getText().trim();
				if(stuPho.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ���ֻ�����Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuBirth=bir.getText().trim();
				if(stuBirth.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ�����ղ���Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
					return;
				}
				String stuHome=hom.getText().trim();
				if(stuHome.isEmpty()){
					JOptionPane.showMessageDialog(null, "ѧ��ԭ������Ϊ�գ�","���棡",JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "��Ϣ���ӳɹ���");
					return;
				}else{
					JOptionPane.showMessageDialog(null, "��Ϣ����ʧ�ܣ�");
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
				s1.setSelected(false);
				s2.setSelected(false);
			}
		});
	}
	public void return_Btn(){
		returnbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_returnBtn_actionPerformed(e);
			}
			private void do_returnBtn_actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int n=JOptionPane.showConfirmDialog(null, "ȷ�Ϸ��أ�", "����",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				switch(n){
				case -1:
				case 2:
					return;
				case 0:
					dispose();
					MainFrame m=new MainFrame();
					m.FrameMain();
					//System.exit(0);
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		AddInfFrame ail=new AddInfFrame();
		ail.Top();
		ail.Center();
		ail.addpho();
		ail.save_Btn();
		ail.clear_Btn();
		ail.return_Btn();
	}
}

