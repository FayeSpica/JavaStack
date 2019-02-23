package designpattern.respnsebility;

/**
 * 主任
 * */
public class Director extends Leader{
    public Director(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeavelRequest request) {
        if(request.getLeaveDays()<3){
            //小于三天假，主任可以处理
            System.out.println("员工："+request.getEmpName()+" 请假天数："+request.getLeaveDays()+"，理由："+request.getReason());
            System.out.println("主任："+this.name+"审批通过");
        }else {
            if(this.nextLeader!=null){
                this.nextLeader.handlerRequest(request);
            }
        }

    }
}
