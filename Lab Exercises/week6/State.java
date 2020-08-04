public abstract class State {

    public abstract void la(CockpitContext context);

    public abstract void to(CockpitContext context);

    public abstract void ds(CockpitContext context);

    public abstract void is(CockpitContext context);

    public abstract void llg(CockpitContext context);

    public abstract void rlg(CockpitContext context);

    public abstract void f(CockpitContext context);
}
