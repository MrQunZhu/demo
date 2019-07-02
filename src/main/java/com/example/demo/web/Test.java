package com.example.demo.web;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * author: lixq
 * date: 2018/11/20
 * 描述:
 */
public class Test {

    public static List<Student> add(){
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setAge(15);
        student.setName("张三");
        list.add(student);
        Student student2 = new Student();
        student2.setAge(15);
        student2.setName("李四");
        list.add(student2);
        Student student3 = new Student();
        student3.setAge(15);
        student3.setName("王五");
        list.add(student3);
        Student student4 = new Student();
        student4.setAge(16);
        student4.setName("三丰");
        list.add(student4);
        return list;
    }

    public static void test(){
        List<Student> list = add();
        //System.out.println(list.stream().collect(Collectors.groupingBy(Student::getAge)));
        //list.stream().flatMap(student -> student.getAge().stream()).collect(Collectors.toSet());
        System.out.println();
    }

    public static void main(String[] args) {
       /* //ftp服务器地址
        String ftpHost = "118.26.3.98";
        //用户名
        String ftpUserName = "ThinkPad";
        //密码
        String ftpPassword = "ftp123456";
        //端口
        int ftpPort = 21;
        //源文件根路径
        String ftpPath = "xmls/";
        //目标文件跟路径
        String localPath = "F:\\";
        //目标文件名称
        String fileName = "18104-701352.xml";

        //下载一个文件
        FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);*/

       List<String> list = new ArrayList<>();
       List<String> list2 = new LinkedList<>();
       int num = 10000000;
        for (int i = 0; i < num; i++) {
            list.add("赵"+i);
            list2.add("赵"+i);
        }
        Long startTime = System.currentTimeMillis();
        System.out.println(LocalDateTime.now());
        list2.remove(10000);
        Long endTime = System.currentTimeMillis();
        System.out.println(LocalDateTime.now());
        System.out.println(endTime-startTime);

    }
}
