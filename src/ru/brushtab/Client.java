package ru.brushtab;

import java.io.IOException;
import java.net.*;


public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("0.0.0.0", 8002);
        System.out.println("Probably connected!");
        System.out.println(socket.isConnected());

        socket.getOutputStream().write(70);
    }
}
