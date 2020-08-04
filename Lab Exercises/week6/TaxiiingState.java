public class TaxiiingState extends State {
    @Override
    public void la(CockpitContext context) {

    }

    @Override
    public void to(CockpitContext context) {

        System.out.println("Taking off!!!");
        context.setState(new SubsonicState());

    }

    @Override
    public void ds(CockpitContext context) {

    }

    @Override
    public void is(CockpitContext context) {

    }

    @Override
    public void llg(CockpitContext context) {

    }

    @Override
    public void rlg(CockpitContext context) {

    }

    @Override
    public void f(CockpitContext context) {

    }
}
