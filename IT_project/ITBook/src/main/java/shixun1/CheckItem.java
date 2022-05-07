package shixun1;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckItem {
	static boolean getItem(String a[],String b[],String table) {
		try {
			String url=null,user1=null,pasw1=null;
			java.sql.Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			url="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			user1="socktail";
			pasw1="Aa999999";
			con=DriverManager.getConnection(url,user1,pasw1);
			String queS="select * from "+table+" where "+a[0]+" =? ";
			for(int i=1;i<a.length;i++) {
				queS+=" and "+a[i]+" = ?";
			}
//			System.out.println(queS);
			PreparedStatement stmt = con.prepareStatement(queS);
			for(int i=0;i<b.length;i++) {
				stmt.setString(i+1, b[i]);
			}
			ResultSet res = stmt.executeQuery();
			int cnt=0;
			while(res.next()) {
				cnt+=1;
			}
//			System.out.println(cnt);
			con.close();
			stmt.close();
			return cnt>=1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	static void submitItem(String a[],String table) {
		try {
			String url=null,user1=null,pasw1=null;
			java.sql.Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			url="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			user1="socktail";
			pasw1="Aa999999";
			String queS="insert into "+table+" values ("+a[0];
			for(int i=1;i<a.length;i++) {
				queS+=" , "+a[i];
			}
			con=DriverManager.getConnection(url,user1,pasw1);
			queS+=")";
			PreparedStatement stmt=con.prepareStatement(queS);
			stmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	static void regisUser(String a,String b){
		String ques="insert into userinfo values(null,?,?)";
		try {
			String url=null,user1=null,pasw1=null;
			java.sql.Connection con=null;
			Class.forName("com.mysql.jdbc.Driver");
			url="jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
			user1="socktail";
			pasw1="Aa999999";
			con=DriverManager.getConnection(url,user1,pasw1);
			PreparedStatement stmt=con.prepareStatement(ques);
			stmt.setString(1, a);
			stmt.setString(2, b);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
