package designpattern.builder;

public class WMAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine buildEngine() {
        System.out.println("buildEngine");
        return new Engine("WM Engine");
    }

    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("buildOrbitalModule");
        return new OrbitalModule("WM Orbital");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("buildEscapeTower");
        return new EscapeTower("WM EscapeTower");
    }
}
