package ru.brushtab;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {


        try (ServerSocket s = new ServerSocket(8002))
        {
            // wait for client connection
            try (Socket incoming = s.accept())
            {
                System.out.println(MessageFormat.format("Connected! IP: {0}, Port: {1}",
                        incoming.getInetAddress().toString(),
                        incoming.getPort()));


                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                byte[] inputBuffer = new byte[1000];

                while(inputBuffer[0] != 'B' && inputBuffer[0] != 'Y' && inputBuffer[0] != 'E')
                {
                    int bytesReaded = inStream.read(inputBuffer);
                    System.out.println("Bytes received: " + bytesReaded);
                    for (int i = 0; i < bytesReaded; i++)
                    {
                        if (inputBuffer[i] > 96)
                        {
                            outStream.write(inputBuffer[i] + ('A' - 'a'));
                        }
                        else
                        {
                            outStream.write(inputBuffer[i]);
                        }

                    }
                }
                byte[] bye = {'b', 'y', 'e', '-', 'b', 'y', 'e'};
                outStream.write(bye);
                incoming.close();
                System.out.println("Closed!");
            }
        }
    }




}
