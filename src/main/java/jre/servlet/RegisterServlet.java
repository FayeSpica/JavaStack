package jre.servlet;

public class RegisterServlet implements Servlet{
    @Override
    public void init() {

    }

    @Override
    public void service(Request request,Response response) {
        System.out.println(this.getClass().getName());
    }

    @Override
    public void destory() {

    }

    @Override
    public void doGet(Request request, Response response) {

    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
