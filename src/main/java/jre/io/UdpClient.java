package jre.io;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) throws Exception{
        System.out.println("client");
        DatagramSocket client = new DatagramSocket(9999);

        Scanner scanner=new Scanner(System.in);

        while (true){
            String data = scanner.next();
            byte[] datas = data.getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",10000));

            client.send(datagramPacket);
        }
    }
}
