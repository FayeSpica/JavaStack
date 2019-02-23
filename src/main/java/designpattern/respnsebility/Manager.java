package designpattern.respnsebility;

/**
 * 经理
 * */
public class Manager extends Leader{
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeavelRequest request) {
        if(request.getLeaveDays()<10){
            //小于10天假，经理可以处理
            System.out.println("员工："+request.getEmpName()+" 请假天数："+request.getLeaveDays()+"，理由："+request.getReason());
            System.out.println("经理："+this.name+"审批通过");
        }else {
            if(this.nextLeader!=null){
                this.nextLeader.handlerRequest(request);
            }
        }

    }
}
