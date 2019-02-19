package jre.servlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * http 响应封装
 * */
public class Response {
    BufferedWriter writer;

    StringBuilder content;

    StringBuilder headInfo;

    static final String BLANK = " ";
    static final String CRLF = "\r\n";

    private Response() {
        content = new StringBuilder();
        headInfo = new StringBuilder();
    }

    public Response(Socket client) {
        this();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public Response(OutputStream os) {
        this();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(os));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Response print(String info){
        content.append(info);
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        return this;
    }

    //构建头信息
    public void createHeadInfo(int status){
        headInfo=new StringBuilder();
        headInfo.append("HTTP/1.1").append(BLANK).append(status).append(BLANK);

        switch (status){
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 500:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }


        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("liaoweiming Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:").append("text/html").append(CRLF);

    }

    public void send(int status){
        if(null == headInfo){
            status=500;
        }
        createHeadInfo(status);
        StringBuilder res = new StringBuilder();
        System.out.println(headInfo);
        res.append(headInfo);
        res.append("Content-length:").append(content.toString().getBytes().length).append(CRLF);
        res.append(CRLF);
        res.append(content);
        try {
            writer.write(res.toString());
            System.out.println(res);
            writer.flush();
            content=new StringBuilder();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
