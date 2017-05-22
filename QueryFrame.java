package sims;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class QueryFrame extends AddInfFrame{
	private static final long serialVersionUID = 1L;
	public QueryFrame(){
		//this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//AddInfFrame a=new AddInfFrame();
		//this.addWindowListener(new CloseWindowListener());
	}
	public void query_Btn(){
		savebtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				do_saveBtn_actionPerformed(e);
			}
			private void do_saveBtn_actionPerformed(ActionEvent e) {
				String stuName=na.getText().trim();
				String stuClass=cla.getText().trim();
				String stuNum=num.getText().trim();
				String stuDor=dor.getText().trim();
				String stuPhone=pho.getText().trim();
				String stuBirth=bir.getText().trim();
				String stuHome=hom.getText().trim();
				String stuNote=note.getText().trim();
				String stuSex="";
				if(s1.isSelected()==true){
					stuSex="男";
				}else if(s2.isSelected()==true){
					stuSex="女";
				}
				if(stuName.isEmpty() && stuClass.isEmpty() && stuSex.isEmpty() &&  stuNum.isEmpty() && stuDor.isEmpty() && stuBirth.isEmpty() && stuHome.isEmpty() && stuPhone.isEmpty() && stuNote.isEmpty()){
					JOptionPane.showMessageDialog(null, "查询条件不能为空","",JOptionPane.WARNING_MESSAGE);
					return;
				}
				InfBean info=new InfBean();
				info.setStuName(stuName);
				info.setStuClass(stuClass);
				info.setStuNum(stuNum);
				info.setStuPhone(stuPhone);
				info.setStuBirth(stuBirth);
				info.setStuDor(stuDor);
				info.setStuSex(stuSex);
				info.setStuHome(stuHome);
				info.setStuNote(stuNote);
				final List<InfBean> results =JdbcHelper.query(info);
				if(results.size()>0){
					EventQueue.invokeLater(new Runnable(){
						public void run(){
							try{
								QueryResultsFrame frame=new QueryResultsFrame(results);
								//frame.Top();
								dispose();
								frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
								frame.setVisible(true);
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					});
				}else{
					JOptionPane.showMessageDialog(null, "没有符合条件的信息！！","提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		QueryFrame q=new QueryFrame();
		q.Top();
		q.Center();
		q.addpho();
		q.query_Btn();
		q.clear_Btn();
		q.return_Btn();
	}

}
