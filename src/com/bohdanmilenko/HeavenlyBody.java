package com.bohdanmilenko;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public enum BodyType{
        PLANET,
        MOON,
        ASTEROID
    }


    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }
    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if ( obj instanceof  HeavenlyBody){
            HeavenlyBody theObj = (HeavenlyBody) obj;
            return this.key.equals(theObj.getKey());
        }
        return  false;
    }

    @Override
    public int hashCode() {

        return  this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.orbitalPeriod + ", " + this.key.getBodyType();
    }

    public static class Key{
        private String name;
        private BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        public static Key makeKey(String name, BodyType bodyType){
            return new Key(name,bodyType);
        }
        @Override
        public int hashCode() {
            return this.name.hashCode()+57+this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return this.bodyType== key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}

//this.name.hashCode() +


        /*
        Modify the previous HeavenlyBody example so that the HeavenlyBody
        class also has a "bodyType" field. This field will store the
        type of HeavenlyBody (such as STAR, PLANET, MOON, etc).

        You can include as many types as you want, but must support at
        least PLANET and MOON.

        For each of the types that you support, subclass the HeavenlyBody class
        so that your program can create objects of the appropriate type.

        Although astronomers may shudder at this, our solar systems will
        allow two bodies to have the same name as long as they are not the
        same type of body: so you could have a star called "BetaMinor" and
        an asteroid also called "BetaMinor", for example.

        Hint: This is much easier to implement for the Set than it is for the Map,
        because the Map will need a key that uses both fields.

        There is a restriction that the only satellites that planets can have must
        be moons. Even if you don't implement a STAR type, though, your program
        should not prevent one being added in the future (and a STAR's satellites
        can be almost every kind of HeavenlyBody).

        Test cases:
        1. The planets and moons that we added in the previous video should appear in
        the solarSystem collection and in the sets of moons for the appropriate planets.

        2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

        3. Attempting to add a duplicate to a Set must result in no change to the set (so
        the original value is not replaced by the new one).

        4. Attempting to add a duplicate to a Map results in the original being replaced
        by the new object.

        5. Two bodies with the same name but different designations can be added to the same set.

        6. Two bodies with the same name but different designations can be added to the same map,
        and can be retrieved from the map.
*/
