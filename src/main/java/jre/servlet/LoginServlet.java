package jre.servlet;

public class LoginServlet implements Servlet{
    @Override
    public void init() {

    }

    @Override
    public void service(Request request,Response response) {
        System.out.println(this.getClass().getName());
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("第一个Servlet");
        response.print("</title>");
        response.print("<body>");
        response.print("msg="+request.getParameterValue("uname"));
        response.print("</body>");
        response.print("</head>");
        response.print("</html>");
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
