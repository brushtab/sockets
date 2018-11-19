package ru.brushtab;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        try (ServerSocket s = new ServerSocket(8001))
        {
            // wait for client connection
            try (Socket incoming = s.accept())
            {
                System.out.println("Connected!");
                System.out.println(incoming.isConnected());
                incoming.setSoLinger(true, 0);
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                boolean hasData = true;
                while (hasData) {

                    int c = inStream.read();
                    if (c == -1)
                    {
                        hasData = false;
                    }
                    System.out.print((char)c);
                }

            }
        }
    }
}
