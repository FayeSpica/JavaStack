package jre.servlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Http Server
 * */
public class Server {
    private ServerSocket serverSocket;
    public static void main(String[] args){
        Server server = new Server();
        server.start();
        while (true){
            server.receive();
        }
    }

    public void start(){
        try {
            serverSocket = new ServerSocket(18888);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }

    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println(client.getPort()+"已连接");

            Request request = new Request(client);

            //System.out.println(requestInfo);

            Response response = new Response(client);

            //返回
            Servlet loginServlet = new LoginServlet();
            loginServlet.service(request,response);

            response.send(200);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接错误");
        }
    }

    public void stop(){

    }
}
