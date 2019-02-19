package jre.servlet;

public interface Servlet {
    void init();
    void service(Request request,Response response);
    void destory();

    void doGet(Request request,Response response);
    void doPost(Request request,Response response);
}
