package sims;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  
//import java.sql.Statement;  
import java.sql.PreparedStatement;
public class Jdbcconfig
{
//����MySQL
	public Connection getconnection() {
		String DRIVER="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dbstu?characterEncoding=utf8&useSSL=false";
		String username = "root";
		String password = "971230";
		Connection conn = null;
		// ���������������������ݿ�
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(url,username, password );
			System.out.println("======>���ݿ����ӳɹ�");
			return conn;
		}
	//����������������쳣
		catch ( ClassNotFoundException cnfex ) {
			System.err.println("װ�� JDBC/ODBC ��������ʧ�ܡ�" );
			cnfex.printStackTrace();
			return null;
		}
	//�����������ݿ��쳣
		catch ( SQLException sqlex ) {
			System.err.println( "�޷��������ݿ�" );
			sqlex.printStackTrace();
			return null;
		}
	}
	//�ͷ�MySQL����
	public void deconnSQL(Connection conn) {
		try {
			if (conn != null)
			conn.close();
			System.out.println("======>���ݿ�Ͽ��ɹ�");
		} catch (Exception e) {
			System.out.println("�ر����ݿ����� ��");
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Jdbcconfig config=new Jdbcconfig();
		config.getconnection();
	}
	public PreparedStatement prepareStatement(String sql) {
		return null;
	}
}