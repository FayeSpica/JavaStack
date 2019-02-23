package designpattern.respnsebility;

/**
 * 总经理
 * */
public class GenneralManager extends Leader{
    public GenneralManager(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeavelRequest request) {
        if(request.getLeaveDays()<30){

            System.out.println("员工："+request.getEmpName()+" 请假天数："+request.getLeaveDays()+"，理由："+request.getReason());
            System.out.println("总经理："+this.name+"审批通过");
        }else {
            System.out.println("员工："+request.getEmpName()+"被开除");
        }

    }
}
