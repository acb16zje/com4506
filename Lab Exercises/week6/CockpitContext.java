public class CockpitContext {

    protected State state;
    protected boolean landingGearRaised = false;


    // Constructor - set up initial state.

    public CockpitContext(){
        state = new TaxiiingState();
    }


    // Cockpit functions

    public void la(){
        state.la(this);
    }

    public void to(){
        state.to(this);
    }

    public void ds(){
        state.ds(this);
    }

    public void is(){
        state.is(this);
    }

    public void llg(){
        state.llg(this);
    }

    public void rlg(){
        state.rlg(this);
    }

    public void f(){
        state.f(this);
    }

    // Utility functions

    public void setLandingGearRaised(boolean raised){
        landingGearRaised = raised;
    }

    public boolean isLandinGearRaised(){
        return landingGearRaised;
    }

    public void setState(State s){
        state = s;
    }

}
