package com.example.demo.test;

import java.io.IOException;
import java.sql.*;

/**
 * author: lixq
 * date: 2019/2/19
 * 描述: 重载 多态
 */
public class Parent {
    public void say(String data,int num){
        System.out.println("小明说：" + data + "," + num);
    }

    public void say(Double data){
        System.out.println("小明说：" + data);
    }

    protected void song(){
        System.out.println("唱歌");
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.81:3306/sky_land?useUnicode=false&characterEncoding=UTF-8","root","Clesun@2018");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EQUIPMENT");
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("MC"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
