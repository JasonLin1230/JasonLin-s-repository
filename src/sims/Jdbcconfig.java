package sims;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;  
//import java.sql.Statement;  
import java.sql.PreparedStatement;
public class Jdbcconfig
{
//连接MySQL
	public Connection getconnection() {
		String DRIVER="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/dbstu?characterEncoding=utf8&useSSL=false";
		String username = "root";
		String password = "971230";
		Connection conn = null;
		// 加载驱动程序以连接数据库
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(url,username, password );
			System.out.println("======>数据库连接成功");
			return conn;
		}
	//捕获加载驱动程序异常
		catch ( ClassNotFoundException cnfex ) {
			System.err.println("装载 JDBC/ODBC 驱动程序失败。" );
			cnfex.printStackTrace();
			return null;
		}
	//捕获连接数据库异常
		catch ( SQLException sqlex ) {
			System.err.println( "无法连接数据库" );
			sqlex.printStackTrace();
			return null;
		}
	}
	//释放MySQL连接
	public void deconnSQL(Connection conn) {
		try {
			if (conn != null)
			conn.close();
			System.out.println("======>数据库断开成功");
		} catch (Exception e) {
			System.out.println("关闭数据库问题 ：");
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