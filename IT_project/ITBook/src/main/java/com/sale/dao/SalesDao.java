package com.sale.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import com.sale.domain.Sales;


public class SalesDao {
    /**
     * ��ѯָ���������ڵ����۶�
     * @return
     */
    public int findAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int totalCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
            String u = "socktail";
            String p = "Aa999999";
            conn = DriverManager.getConnection(url,u,p);
            String sql = "select SUM(prices) from order_table group by DATE_FORMAT(create_time,'%Y-%m-%d')  order by DATE_FORMAT(create_time,'%Y-%m-%d') desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                totalCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return totalCount;
    }
    /**
     * ��ѯָ����7������۶�
     * @return
     */
    public ArrayList<Sales> seven(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Sales> saleList =  new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
            String u = "socktail";
            String p = "Aa999999";
            conn = DriverManager.getConnection(url,u,p);
            StringBuffer sql = new StringBuffer("select SUM(price),time  "
                    + "from (SELECT order_id, DATE_FORMAT(create_time,'%Y-%m-%d') time, prices*numbers price "
                    + "FROM order_table ) AS X group by time order by time desc");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            int count = 0;
            while(rs.next()) {
                Sales sale = new Sales();
                sale.setIncome(rs.getInt("SUM(price)"));
                sale.setDate(rs.getString("time"));
                saleList.add(sale);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return saleList;
    }
    /**
     * ��ѯָ�����ڵ����۶�
     * @return
     */
    public ArrayList<Sales> findOne(String date){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Sales> sale = new ArrayList<Sales>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
            String u = "socktail";
            String p = "Aa999999";
            conn = DriverManager.getConnection(url,u,p);
            StringBuffer sql = new StringBuffer("select SUM(price), time from"
                    + " (SELECT order_id, DATE_FORMAT(create_time,'%Y-%m-%d') time, "
                    + "prices*numbers price FROM order_table ) AS X");
            if(date!=null &&! "".equals(date.trim())) {
                sql.append(" where time = ? group by time order by time desc");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, date);
            }
            else {
                sql.append( " group by time order by time desc ");
                pstmt = conn.prepareStatement(sql.toString());
            }
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Sales s = new Sales();
                s.setIncome(rs.getInt("SUM(price)"));
                s.setDate(rs.getString("time"));
                sale.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        return sale;
    }


    public ArrayList<Sales> findByPage(int startIndex,int pageSize){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Sales> saleList =  new ArrayList<Sales>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://rm-bp1865k015vpwlzyr7o.mysql.rds.aliyuncs.com:3306/shixun";
            String u = "socktail";
            String p = "Aa999999";
            conn = DriverManager.getConnection(url,u,p);
            String sql =  "select SUM(prices),DATE_FORMAT(create_time,'%Y-%m-%d') time "
                    + " from order_table group by DATE_FORMAT(create_time,'%Y-%m-%d') "
                    + " order by DATE_FORMAT(create_time,'%Y-%m-%d') desc"
                    + " limit ?,? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startIndex);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Sales sale = new Sales();
                sale.setIncome(rs.getInt("SUM(prices)"));
                sale.setDate(rs.getString("time"));
                saleList.add(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return saleList;
    }
}
