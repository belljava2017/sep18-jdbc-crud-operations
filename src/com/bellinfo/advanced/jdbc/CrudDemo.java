package com.bellinfo.advanced.jdbc;

import java.sql.*;
import java.util.Properties;

public class CrudDemo {

    public static void main(String[] args) {

        String url ="jdbc:postgresql://bellsolutions.chrjby1kewcd.us-east-1.rds.amazonaws.com:5432/belljavasep";
        Properties prop = new Properties();
        prop.setProperty("user","postgres");
        prop.setProperty("password","abcd12345");
        try {

            Connection con = DriverManager.getConnection(url,prop);
            Class.forName("org.postgresql.Driver");
            Statement stmt = con.createStatement();
            String query = "select * from Deptartment";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs1 =ps.executeQuery();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
