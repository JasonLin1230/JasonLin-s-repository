package sims;
//import sims.QueryFrame;
//import sims.InfBean;
//import sims.JdbcHelper;
//import sims.SavedInfFrame;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.List; 
public class QueryResultsFrame extends QueryFrame{
	private static final long serialVersionUID = 1L;
	public QueryResultsFrame(List<InfBean> results){
		//JFrame content=new JFrame();
		JPanel contentPane=new JPanel();
		content.setBounds(0, 0, 800, 540);
		content.setVisible(true);
		contentPane.setVisible(true);
		content.setLocation(getLocation());
		contentPane.setLayout(new BorderLayout(0,0));
		content.add(contentPane);
		//setContentPane(contentPane);
		
		JScrollPane scrollPane =new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTable InfTable=new JTable();
		//InfTable.setVisible(false);
		scrollPane.add(InfTable);
		
		InfTable.setFont(new Font("微软雅黑",Font.PLAIN,14));
		InfTable.setRowHeight(25);
		JTableHeader header =InfTable.getTableHeader();
		header.setFont(new Font("微软雅黑",Font.PLAIN,15));
		header.setPreferredSize(new Dimension(header.getWidth(),35));
		
		DefaultTableCellRenderer renderer=(DefaultTableCellRenderer)header.getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableModel model=(DefaultTableModel)InfTable.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(new Object[]{
				"姓名","班级","性别","学号","手机"
		});
		for(InfBean info:results){
			model.addRow(new Object[]{
				info.getStuName(),info.getStuClass(),info.getStuSex(),info.getStuNum(),info.getStuPhone()
			});
		}
		
		InfTable.setModel(model);
		scrollPane.setViewportView(InfTable);
	}
}
