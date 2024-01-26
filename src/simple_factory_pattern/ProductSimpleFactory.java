package simple_factory_pattern;

enum ProductType{
    A,B;
}

/*
简单工厂模式（抽象工厂模式）
 */
public class ProductSimpleFactory {
    public static Product get(ProductType type){
        switch (type){
            case A:
                return new ProductA();
            case B:
                return new ProductB();
            default:
                return null;
        }
    }
}
