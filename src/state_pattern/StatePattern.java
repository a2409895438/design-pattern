package state_pattern;

public class StatePattern {
    public static void main(String[] args) {
        Context c = new Context(new ConcreteStateA());
        c.request();
        c.request();
        c.request();
    }
}

abstract class State {
    public abstract void handle(Context context);
}

class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}

class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + this.state.getClass().getName());
    }

    public Context(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle(this);
    }
}