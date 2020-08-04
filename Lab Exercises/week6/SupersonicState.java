public class SupersonicState extends State {
    @Override
    public void la(CockpitContext context) {

    }

    @Override
    public void to(CockpitContext context) {

    }

    @Override
    public void ds(CockpitContext context) {
        System.out.println("Slowed down again.");
        context.setState(new SubsonicState());

    }

    @Override
    public void is(CockpitContext context) {

    }

    @Override
    public void llg(CockpitContext context) {

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
