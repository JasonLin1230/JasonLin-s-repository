package sims;
import sims.Jdbcconfig;
//import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;
//import java.sql.Types;
import java.util.ArrayList;
import java.util.List; 
//import java.awt.*;
public abstract class JdbcHelper extends InfBean implements PreparedStatement{
	//保存方法来保存学生信息
	public static int save(InfBean info){
		String sql="insert into InfBean(stuName,stuClass,stuSex,stuNum,stuPhone,stuDor,stuBirth,stuHome,stuNote)value(?,?,?,?,?,?,?,?,?);";
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		PreparedStatement ps=null;
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, info.getStuName());
			ps.setString(2, info.getStuClass());
			ps.setString(3, info.getStuSex());
			ps.setString(4, info.getStuNum());
			ps.setString(5, info.getStuPhone());
			ps.setString(6, info.getStuDor());
			ps.setString(7, info.getStuBirth());
			ps.setString(8, info.getStuHome());
			ps.setString(9, info.getStuNote());
			//ps.setString(9, info.getStuPhoto());
			return ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try{
					ps.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn!=null){
				config.deconnSQL(conn);
			}
		}
		return -1;
	}
	//修改成绩单
	public static int update(InfBean info){
		//String sql="update InfBean set stuName=?,stuClass=?,stuSex=?,stuNum=?,stuPhone=?,stuDor=?,stuBirth=?,stuHome=? where stuNum=?;";
		String sql="update InfBean set stuName=?,stuClass=?,stuSex=?,stuPhone=?,stuDor=?,stuBirth=?,stuHome=?,stuNote=? where stuNum=?;";
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		PreparedStatement ps=null;
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, info.getStuName());
			ps.setString(2, info.getStuClass());
			ps.setString(3, info.getStuSex());
			
			ps.setString(4, info.getStuPhone());
			ps.setString(5, info.getStuDor());
			ps.setString(6, info.getStuBirth());
			ps.setString(7, info.getStuHome());
			ps.setString(8, info.getStuNote());
			ps.setString(9, info.getStuNum());
			//ps.setString(9, info.getStuPhoto());
			//ps.setInt(10,info.getId());
			return ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try{
					ps.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn!=null){
				config.deconnSQL(conn);
			}
		}
		return -1;
	}
	//保存表格中的全部数据
	public static List<InfBean> queryAll(){
		String sql="select * from InfBean;";
		List<InfBean> results=new ArrayList<InfBean>();
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		Statement stat=null;
		ResultSet re=null;
		try{
			stat=conn.createStatement();
			re=stat.executeQuery(sql);
			while(re.next()){
				InfBean info=new InfBean();
				//info.setId(re.getInt("id"));
				info.setStuName(re.getString("stuName"));
				info.setStuClass(re.getString("stuClass"));
				info.setStuSex(re.getString("stuSex"));
				info.setStuNum(re.getString("stuNum"));
				info.setStuPhone(re.getString("stuPhone"));
				info.setStuDor(re.getString("stuDor"));
				info.setStuBirth(re.getString("stuBirth"));
				info.setStuHome(re.getString("stuHome"));
				info.setStuNote(re.getString("stuNote"));
				//info.setStuPhoto(re.getString("stuPhoto"));
				results.add(info);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(re!=null){
				try{
					re.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn!=null){
				config.deconnSQL(conn);
			}
		}
		return results;
	}
	//保存满足查询条件的全部数据
	public static List<InfBean> query(InfBean info){
		String stuName=info.getStuName();
		String stuClass=info.getStuClass();
		String stuSex=info.getStuSex();
		String stuNum=info.getStuNum();
		String stuPhone=info.getStuPhone();
		String stuDor=info.getStuDor();
		String stuBirth=info.getStuBirth();
		String stuHome=info.getStuHome();
		String stuNote=info.getStuNote();
		//String stuPhoto=info.getStuPhoto();
		StringBuilder sql=new StringBuilder("select *from InfBean where 1=1");
		if(!stuName.isEmpty()){
			sql.append(" and stuName like '%"+stuName+"%' ");
		}
		if(!stuClass.isEmpty()){
			sql.append(" and stuClass like '%"+stuClass+"%' ");
		}
		if(!stuSex.isEmpty()){
			sql.append(" and stuSex like '%"+stuSex+"%' ");
		}
		if(!stuNum.isEmpty()){
			sql.append(" and stuNum like '%"+stuNum+"%' ");
		}
		if(!stuPhone.isEmpty()){
			sql.append(" and stuPhone like '%"+stuPhone+"%' ");
		}
		if(!stuDor.isEmpty()){
			sql.append(" and stuDor like '%"+stuDor+"%' ");
		}
		if(!stuBirth.isEmpty()){
			sql.append(" and stuBirth like '%"+stuBirth+"%' ");
		}
		if(!stuHome.isEmpty()){
			sql.append(" and stuHome like '%"+stuHome+"%' ");
		}
		if(!stuNote.isEmpty()){
			sql.append(" and stuNote like '%"+stuNote+"%' ");
		}
//		if(!stuPhoto.isEmpty()){
//			sql.append(" and stuName like '%"+stuPhoto+"%' ");
//		}
		sql.append(";");
		List<InfBean> results=new ArrayList<InfBean>();
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		Statement stat =null;
		ResultSet re =null;
		try{
			stat=conn.createStatement();
			re=stat.executeQuery(sql.toString());
			while(re.next()){
				InfBean tempInfo=new InfBean();
				//tempInfo.setId(re.getInt("id"));
				tempInfo.setStuName(re.getString("stuName"));
				tempInfo.setStuClass(re.getString("stuClass"));
				tempInfo.setStuSex(re.getString("stuSex"));
				tempInfo.setStuNum(re.getString("stuNum"));
				tempInfo.setStuPhone(re.getString("stuPhone"));
				tempInfo.setStuDor(re.getString("stuDor"));
				tempInfo.setStuBirth(re.getString("stuBirth"));
				tempInfo.setStuHome(re.getString("stuHome"));
				tempInfo.setStuNote(re.getString("stuNote"));
				//tempInfo.setStuPhoto(re.getString("stuPhoto"));
				results.add(tempInfo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(re!=null){
				try{
					re.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(stat!=null){
				try{
					stat.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn!=null){
				config.deconnSQL(conn);
			}
		}
		return results;
	}
	public static boolean delete(InfBean info) {
		// TODO 自动生成的方法存根
		String stuNum=info.getStuNum();
		boolean flag=true;
		String strSql="delete from InfBean where stuNum=?";
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		PreparedStatement pr=null;
		try{
			pr=conn.prepareStatement(strSql);
			pr.setString(1, stuNum);
			pr.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pr!=null){
					pr.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return flag;
	}
	public static List<InfBean> queryOne(InfBean info){
		String Num=info.getStuNum();
		StringBuilder strSql=new StringBuilder("select *from InfBean where 1=1");
		if(!Num.isEmpty()){
			strSql.append(" and stuNum like '%"+Num+"%' ");
		}
		strSql.append(";");
		Jdbcconfig config=new Jdbcconfig();
		Connection conn=config.getconnection();
		Statement stat =null;
		ResultSet re =null;
		
		List<InfBean> results=new ArrayList<InfBean>();
		try{
			stat=conn.createStatement();
			re=stat.executeQuery(strSql.toString());
			while(re.next()){
				InfBean tempInfo=new InfBean();
				//tempInfo.setId(re.getInt("id"));
				tempInfo.setStuName(re.getString("stuName"));
				tempInfo.setStuClass(re.getString("stuClass"));
				tempInfo.setStuSex(re.getString("stuSex"));
				tempInfo.setStuNum(re.getString("stuNum"));
				tempInfo.setStuPhone(re.getString("stuPhone"));
				tempInfo.setStuDor(re.getString("stuDor"));
				tempInfo.setStuBirth(re.getString("stuBirth"));
				tempInfo.setStuHome(re.getString("stuHome"));
				tempInfo.setStuNote(re.getString("stuNote"));
				//tempInfo.setStuPhoto(re.getString("stuPhoto"));
				results.add(tempInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(re!=null){
					re.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		return results;
	}
}
