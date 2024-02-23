package bridge_pattern;

public class Bridge {
}

abstract class Implementor{
    public abstract void operation();
}

class ConcreteImplementorA extends Implementor{
    @Override
    public void operation() {
        System.out.println("method A");
    }
}

class ConcreteImplementorB extends Implementor{
    @Override
    public void operation() {
        System.out.println("method B");
    }
}

abstract class Abstraction{
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction{

    @Override
    public void operation() {
        System.out.println("....");
        implementor.operation();
    }
}
