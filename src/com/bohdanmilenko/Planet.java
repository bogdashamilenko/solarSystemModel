package com.bohdanmilenko;



public class Planet extends HeavenlyBody{

    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addMoon(HeavenlyBody moon) {
        if(moon instanceof Moon) {
            return super.addMoon(moon);
        }
        return false;
    }

}
