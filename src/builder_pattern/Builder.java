package builder_pattern;

import java.util.ArrayList;

public class Builder {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        director.construct(concreteBuilder);
        concreteBuilder.getResult().show();
    }
}

class Director{
    public void construct(AbstractBuilder builder){
        builder.buildPartA();
        builder.buildPartB();
    }
}

class Product{
    ArrayList<String> parts = new ArrayList<>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        for(String part : parts){
            System.out.println(part);
        }
    }
}

abstract class AbstractBuilder{
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product getResult();
}

class ConcreteBuilder extends  AbstractBuilder{
    Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("A");
    }

    @Override
    public void buildPartB() {
        product.add("B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
