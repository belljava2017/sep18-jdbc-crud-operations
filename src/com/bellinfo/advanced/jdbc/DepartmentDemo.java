package com.bellinfo.advanced.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class DepartmentDemo {

    enum OPERATIONS{ INSERT, UPDATE};

    public static void main(String[] args) throws SQLException {

        DepartmentRepository dr = new DepartmentRepository();
        dr.createDepartment();
        Scanner scan = new Scanner(System.in);

        System.out.println("Hey what do you want do");
        String oper= scan.next();
        if(oper.equalsIgnoreCase(OPERATIONS.INSERT.name())){
            System.out.println("How many records");
            int count = scan.nextInt();
            Department d =null;
            for(int i=0;i<count;i++){
                d = new Department();
                System.out.println("id");
                d.setId(scan.nextInt());
                System.out.println("name");
                d.setName(scan.next());
                System.out.println("location");
                d.setLoc(scan.next());
                dr.insertDepartmentRecord(d);
            }

        }else if(oper.equalsIgnoreCase(OPERATIONS.UPDATE.name())){
            System.out.println("which deptarment you want to update");
            String dept = scan.next();
            System.out.println("what is the new location");
            String loc = scan.next();
            dr.updateDeparmentRecord(loc,dept);

        }
        System.out.println("After requested operation, records in DB");
        dr.fetchRecords();



    }
}
