package designpattern.flyweight;

public class ConcreteChess implements ChessFlyWeight{
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {

    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置：("+coordinate.getX()+","+coordinate.getY()+")");
    }
}
