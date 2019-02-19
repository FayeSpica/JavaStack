package jre.io;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",9999);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        while (true){
            String msg = scanner.next();
            dos.writeUTF(msg);
            dos.flush();
        }
        //dos.close();
    }
}
