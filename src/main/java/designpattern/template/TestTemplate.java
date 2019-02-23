package designpattern.template;

public class TestTemplate {
    public static void main(String[] args){
        BankTemplateMethod bankTemplateMethod = new DrawMoneyService();
        bankTemplateMethod.process();

        //采用匿名内部类

        BankTemplateMethod bankTemplateMethod1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱!");
            }
        };

        bankTemplateMethod1.process();


    }
}



class DrawMoneyService extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要取款！！！");
    }

}
