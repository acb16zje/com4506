import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CockpitContextTest {

    @Test
    public void flareOnTheRunway(){
        CockpitContext cockpit = new CockpitContext();
        cockpit.f();
        //No flare!
    }

    @Test
    public void takeOffAndLand(){
        CockpitContext cockpit = new CockpitContext();
        cockpit.to();
        cockpit.rlg();
        cockpit.llg();
        cockpit.la();
    }

    @Test
    public void takeOffAndLandWithoutLoweringLandingGear(){
        CockpitContext cockpit = new CockpitContext();
        cockpit.to();
        cockpit.rlg();
        cockpit.la();
    }

    @Test
    public void flares(){
        CockpitContext cockpit = new CockpitContext();
        cockpit.to();
        cockpit.rlg();
        cockpit.f();
        cockpit.is();
        cockpit.f();
        cockpit.ds();
        cockpit.f();
        cockpit.llg();
        cockpit.f();
        cockpit.la();
    }

}