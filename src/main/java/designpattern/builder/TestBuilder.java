package designpattern.builder;

public class TestBuilder {
    public static void main(String[] args){
        AirShipDirector director = new WMAirShipDirector(new WMAirShipBuilder());

        AirShip airShip = director.directAirShip();

        System.out.println(airShip);
    }
}
