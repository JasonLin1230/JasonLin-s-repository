package sims;
//import sims.QueryFrame;
//import sims.InfBean;
//import sims.JdbcHelper;
//import sims.SavedInfFrame;

import java.awt.*;

import javax.swing.*;
import java.util.List; 
import sims.SavedInfFrame;
public class QueryResultsFrame extends SavedInfFrame{
	private static final long serialVersionUID = 1L;

	//	public JButton updatebtn=new JButton("����/�޸�");
//	public JButton deletebtn=new JButton("ɾ��");
	public QueryResultsFrame(List<InfBean> results){
		contentPane.setLayout(null);
		JPanel top=new JPanel();				
		contentPane.add(top);   //�ϲ������
		top.setBounds(25, 25, 750, 70);
		top.add(title);
		title.setFont(new java.awt.Font("������", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		top.setBorder(BorderFactory.createTitledBorder("�����")); //�������߿�ʵ�ַ�����Ч�����˾����Ϊ�ؼ�����
		top.setBorder(BorderFactory.createLineBorder(Color.black));//�������߿���ɫ
		table(results);
		
		upd_Btn();
		delete_Btn();
		return_Btn();	
	}
}
