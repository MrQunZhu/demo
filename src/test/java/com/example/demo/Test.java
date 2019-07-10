package com.example.demo;

import org.apache.ftpserver.DataConnectionConfigurationFactory;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lixq
 * @date: 2019-07-10
 * @描述:
 */
public class Test {

    public static void main(String[] args) throws FtpException {

        FtpServerFactory serverFactory = new FtpServerFactory();
       /* ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.setPort(3131);*/
        //设置被动模式数据上传的接口范围,云服务器需要开放对应区间的端口给客户端
       /* DataConnectionConfigurationFactory dataConnectionConfFactory = new DataConnectionConfigurationFactory();
        dataConnectionConfFactory.setPassivePorts("10000-10100");
        listenerFactory.setDataConnectionConfiguration(dataConnectionConfFactory.createDataConnectionConfiguration());
        Listener listener = listenerFactory.createListener();*/
        BaseUser user = new BaseUser();
        user.setName("test");
        user.setPassword("123456");
        user.setHomeDirectory("D:/java");

        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new WritePermission());
        user.setAuthorities(authorities);


        serverFactory.getUserManager().save(user);
        FtpServer server = serverFactory.createServer();
        server.start();
    }
}
