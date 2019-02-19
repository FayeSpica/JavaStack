package jre.io;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);

        Socket client = serverSocket.accept();

        DataInputStream dis = new DataInputStream(client.getInputStream());
        while (true){
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}
