package com.example.demo.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: lixq
 * date: 2019/2/20
 * 描述:
 */
public class TextRead {
    private static Pattern p = Pattern.compile("a(.*?)b");
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile() {


        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        String pathname = "D:/input.txt";
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        try (FileReader reader = new FileReader(pathname);
             // 建立一个对象，它把文件内容转成计算机能读懂的语言
             BufferedReader br = new BufferedReader(reader)
        ) {
            String line;
            //网友推荐更加简洁的写法
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);
                if(m.find()){
                    lineNum++;
                    System.out.println(lineNum + "," + (line.indexOf("a")+1) + "," + (line.indexOf("b")+1));
                }
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
