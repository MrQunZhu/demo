package com.example.demo.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: lixq
 * date: 2018/11/19
 * 描述:
 */
public class SocketWeb implements Runnable {
    boolean started = false;
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            started = true;
            while (started) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress());
                System.out.println(socket.getPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
