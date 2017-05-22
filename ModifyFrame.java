package sims;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class ModifyFrame extends AddInfFrame{
	private static final long serialVersionUID = 1L;
	public ModifyFrame(InfBean info2){
		//this.addWindowListener(new CloseWindowListener2());	
		final List<InfBean> results =JdbcHelper.queryOne(info2);
		for(InfBean info:results){
			na.setText(info.getStuName());
			num.setEditable(false);
			cla.setText(info.getStuClass());
			if(info.getStuSex()=="男"){
				s1.setSelected(true);
			}else{
				s2.setSelected(true);
			}
			dor.setText(info.getStuDor());
			pho.setText(info.getStuPhone());
			
			hom.setText(info.getStuHome());
			num.setText(info.getStuNum());
			bir.setText(info.getStuBirth());
			note.setText(info.getStuNote());
			
		}
		
	}
	public void upd_Btn(){
		
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
				int result=JdbcHelper.update(info);
				if(result>=0){
					JOptionPane.showMessageDialog(null, "成绩修改成功！");
					return;
				}else{
					JOptionPane.showMessageDialog(null, "成绩修改失败！");
					return;
				}
			}
		});
	}
	public static void main(String[] args) {
		ModifyFrame m=new ModifyFrame(new InfBean());
		m.Top();
		m.Center();
		m.addpho();
		m.upd_Btn();
		m.clear_Btn();
		m.return_Btn();
	}
}
