package jre.io;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpServer {
    public static void main(String[] args) throws Exception{
        System.out.println("server");

        DatagramSocket server = new DatagramSocket(10000);

        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);

        while (true){
            server.receive(packet);
            byte[] datas = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(datas,0,len));
        }
    }
}
