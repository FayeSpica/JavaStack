package designpattern.flyweight;

public class TestFlyWeight {
    public static void main(String[] args){
        ChessFlyWeight chessFlyWeight0 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chessFlyWeight1 = ChessFlyWeightFactory.getChess("黑色");

        System.out.println(chessFlyWeight0);
        System.out.println(chessFlyWeight1);

        System.out.println("增加外部状态的处理=====-----=====");
        chessFlyWeight0.display(new Coordinate(10,10));
        chessFlyWeight1.display(new Coordinate(20,20));

    }
}
