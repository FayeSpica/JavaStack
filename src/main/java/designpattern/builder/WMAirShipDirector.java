package designpattern.builder;

public class WMAirShipDirector implements AirShipDirector{

    private AirShipBuilder builder;

    public WMAirShipDirector(AirShipBuilder builder) {
        this.builder=builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.buildEngine();
        EscapeTower et = builder.buildEscapeTower();
        OrbitalModule om = builder.buildOrbitalModule();

        AirShip airShip = new AirShip();
        airShip.setEngine(e);
        airShip.setEscapeTower(et);
        airShip.setOrbitalModule(om);

        return airShip;
    }
}
