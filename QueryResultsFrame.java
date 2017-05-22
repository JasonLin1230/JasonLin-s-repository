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

	//	public JButton updatebtn=new JButton("详情/修改");
//	public JButton deletebtn=new JButton("删除");
	public QueryResultsFrame(List<InfBean> results){
		contentPane.setLayout(null);
		JPanel top=new JPanel();				
		contentPane.add(top);   //上部的组件
		top.setBounds(25, 25, 750, 70);
		top.add(title);
		title.setFont(new java.awt.Font("新宋体", Font.PLAIN, 45));
		title.setHorizontalAlignment(SwingConstants.CENTER); 
		top.setBorder(BorderFactory.createTitledBorder("分组框")); //设置面板边框，实现分组框的效果，此句代码为关键代码
		top.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
		table(results);
		
		upd_Btn();
		delete_Btn();
		return_Btn();	
	}
}
