package sims;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class SavedInfFrame extends MainFrame{
	private static final long serialVersionUID = 1L;
	JTable infoTable=new JTable();
	JPanel center=new JPanel();
	JScrollPane scrollPane=new JScrollPane(infoTable);
	public JButton updatebtn=new JButton("修改");
	public JButton deletebtn=new JButton("删除");
	public JButton returnbtn=new JButton("返回");
	
	void table(){
		content.add(center); 
		center.setLayout(null);//中间的组件
		center.setBounds(25, 95, 750, 400);
		center.setBackground(new Color(197,242,253));
		center.setBorder(BorderFactory.createLineBorder(Color.black)); 
		center.add(scrollPane);
		center.add(updatebtn);
		center.add(deletebtn);
		center.add(returnbtn);
		
		updatebtn.setBounds(150, 360, 80, 30);
		deletebtn.setBounds(300, 360, 80, 30);
		returnbtn.setBounds(450, 360, 80, 30);
		scrollPane.setBounds(0, 0, 750, 355);
		
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.black)); 
		scrollPane.add(infoTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		infoTable.setBounds(1, 0, 732, 10000);
		infoTable.setBackground(new Color(197,242,253));
		infoTable.setFont(new Font("微软雅黑",Font.PLAIN,14));
		infoTable.setRowHeight(30);
		infoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader header =infoTable.getTableHeader();
		header.setFont(new Font("微软雅黑",Font.PLAIN,15));
		header.setPreferredSize(new Dimension(header.getWidth(),40));
		
		DefaultTableCellRenderer renderer=(DefaultTableCellRenderer)header.getDefaultRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableModel model=(DefaultTableModel) infoTable.getModel();
		model.setRowCount(0);
		model.setColumnIdentifiers(new Object[] {"姓名","班级","性别","学号","手机"});
		List<InfBean> results=JdbcHelper.queryAll();
		for(InfBean info:results){
			model.addRow(new Object[]{
					info.getStuName(),info.getStuClass(),info.getStuSex(),info.getStuNum(),info.getStuPhone()
			});
		}
		infoTable.setModel(model);
		scrollPane.setViewportView(infoTable);

		content.setVisible(true);
		content.setBounds(0,0,800, 540);
		content.setLocation(getLocation());//让窗体居中显示
		content.setResizable(false);
		content.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void upd_Btn(){
		updatebtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_update_actionPerformed(e);
			}

			private void do_update_actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int selectRow=infoTable.getSelectedRow();
				if(selectRow<0){
					JOptionPane.showMessageDialog(null, "请选择要修改的行！",",",JOptionPane.WARNING_MESSAGE);
					return;
				}else{
					final InfBean info=new InfBean();
					info.setStuName((String) infoTable.getValueAt(selectRow,0));;
					info.setStuClass((String) infoTable.getValueAt(selectRow, 1));
					info.setStuSex((String) infoTable.getValueAt(selectRow, 2));
					info.setStuNum((String) infoTable.getValueAt(selectRow, 3));
					info.setStuPhone((String) infoTable.getValueAt(selectRow, 4));
					//String modifyStuNum=(String) infoTable.getValueAt(selectRow, 3);
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							try{
								ModifyFrame frame=new ModifyFrame(info);
								dispose();
								frame.Top();
								frame.Center();
								frame.addpho();
								frame.upd_Btn();
								frame.clear_Btn();
								frame.return_Btn();
								frame.setVisible(true);
								dispose();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
				}
			};
		});
	}
	void delete_Btn(){
		deletebtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selectRow=infoTable.getSelectedRow();
				if(selectRow<0){
					JOptionPane.showMessageDialog(null, "请选择要删除的行！",",",JOptionPane.WARNING_MESSAGE);
					return;
				}else{
					int n=JOptionPane.showConfirmDialog(null, "确认删除？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					switch(n){
					case -1:
					case 2:
						return;
					case 0:
						final InfBean info=new InfBean();
						info.setStuNum((String) infoTable.getValueAt(selectRow, 3));
						JdbcHelper.delete(info);
						DefaultTableModel model=(DefaultTableModel) infoTable.getModel();
						model.setRowCount(0);
						model.setColumnIdentifiers(new Object[] {"姓名","班级","性别","学号","手机"});
						List<InfBean> results=JdbcHelper.queryAll();
						for(InfBean tempInfo:results){
							model.addRow(new Object[]{
									tempInfo.getStuName(),tempInfo.getStuClass(),tempInfo.getStuSex(),tempInfo.getStuNum(),tempInfo.getStuPhone()
							});
						}
						infoTable.setModel(model);
					}
				}
			}
		});
		
	}
	void return_Btn(JFrame j){
		returnbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n=JOptionPane.showConfirmDialog(null, "确认返回？", "警告",JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				switch(n){
					case -1:
					case 2:
						return;
					case 0:
						dispose();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		SavedInfFrame sa=new SavedInfFrame();
		sa.Top();
		sa.table();
		sa.upd_Btn();
		sa.delete_Btn();
		sa.return_Btn(sa);
	}

}