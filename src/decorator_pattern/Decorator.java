package decorator_pattern;

public class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecoratorA extends Decorator{
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    public void operation() {
        super.operation();
        System.out.println("some operation");
    }
}


interface Component{
    public void operation();
}

class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("具体构件");
    }
}