package com.bellinfo.advanced.jdbc;

import java.sql.*;
import java.util.Properties;

public class DepartmentRepository {

    private static final String CREATE_SQL = "CREATE TABLE Department ( deptid int, depname varchar, location varchar)";
    private static final String INSERT_SQL = "INSERT INTO Department VALUES(?,?,?)";
    private static final String SELECT_SQL = "select * from Department";
    private static final String UPDATE_SQL = "Update Department set location=? where depname=?";
    private static final String VALIDATE_SQL= "select exists (select 1 from pg_tables where schemaname='public' and tablename='department')";

    private static final String URL = "jdbc:postgresql://bellsolutions.chrjby1kewcd.us-east-1.rds.amazonaws.com:5432/belljavasep";
    Connection con = null;

    void getConnection(){

        try {
            Class.forName("org.postgresql.Driver");
            Properties prop = new Properties();
            prop.setProperty("user","postgres");
            prop.setProperty("password","abcd12345");
            con = DriverManager.getConnection(URL,prop);
           // return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    void createDepartment() throws SQLException {
        getConnection();
        PreparedStatement psValidate = con.prepareStatement(VALIDATE_SQL);
        ResultSet rs = psValidate.executeQuery();
        boolean isTableExsist = false;
        while(rs.next()){
            isTableExsist = rs.getBoolean(1);
        }
        if(isTableExsist){
            System.out.println("Hey ..Table already created in your schema, so...skiping it");
        }else{
            PreparedStatement ps = con.prepareStatement(CREATE_SQL);
            boolean isCreated = ps.execute();
            System.out.println("Hey Table has been created");
        }
    }

    void insertDepartmentRecord(Department d){
        getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(INSERT_SQL);
            ps.setInt(1,d.getId());
            ps.setString(2,d.getName());
            ps.setString(3,d.getLoc());

            ps.executeUpdate();
            System.out.println("Record created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void updateDeparmentRecord(String loc, String name){
        getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
            ps.setString(1,loc);
            ps.setString(2,name);
            int count = ps.executeUpdate();
            System.out.println("Records Updated count "+count);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void fetchRecords() throws SQLException {
        getConnection();
        PreparedStatement ps = con.prepareStatement(SELECT_SQL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("deptid") + "  "+rs.getString("depname") + "    "+rs.getString("location") );
        }
    }

}
