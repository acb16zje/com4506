public class SubsonicState extends State {
    @Override
    public void la(CockpitContext context) {

        if(!context.isLandinGearRaised()){
            System.out.println("Landing - BRACE YOURSLEVES");
            context.setState(new TaxiiingState());
        }

    }

    @Override
    public void to(CockpitContext context) {

    }

    @Override
    public void ds(CockpitContext context) {

    }

    @Override
    public void is(CockpitContext context) {
        System.out.println("Sonic boom - gone supersonic.");
        context.setState(new SupersonicState());

    }

    @Override
    public void llg(CockpitContext context) {

        if(context.isLandinGearRaised()){
            System.out.println("Lowering landing gear.");
            context.setLandingGearRaised(false);
        }

    }

    @Override
    public void rlg(CockpitContext context) {

        if(!context.isLandinGearRaised()){
            System.out.println("Raising landing gear.");
            context.setLandingGearRaised(true);
        }

    }

    @Override
    public void f(CockpitContext context) {

        System.out.println("WHOOSH. Flare deployed.");

    }
}
