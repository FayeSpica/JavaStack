package designpattern.respnsebility;

public class TestResponse {
    public static void main(String[] args){
        Leader a = new Director("a");
        Leader b = new Manager("b");
        Leader c = new GenneralManager("c");

        // 组织责任链关系
        a.setNextLeader(b);
        b.setNextLeader(c);

        //开始请假
        LeavelRequest request = new LeavelRequest("Tom",10,"回英国老家探亲！");
        a.handlerRequest(request);
        request.setLeaveDays(1);
        a.handlerRequest(request);
    }
}
