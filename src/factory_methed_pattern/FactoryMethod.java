package factory_methed_pattern;

public class FactoryMethod {
    public static void main(String[] args) {
        IFactory<IProduct> phoneFactory = new PhoneFactory();
        // 通过工厂穿件具体对象
        IProduct phoneProduct = phoneFactory.product();
        System.out.println(phoneProduct.getInformation());
    }
}


//抽象产品
interface IProduct {

    /**
     * 产品类型的公共方法
     * @return 返回产品信息
     */
    String getInformation();
}

// 具体产品
class PhoneProduct implements IProduct {
    @Override
    public String getInformation() {
        return "电视很NB，报纸很NB，杂志很NB，游戏机很NB，小说很NB，最终都被手机干掉了";
    }
}

// 抽象工厂
interface IFactory<T> {
    /**
     * 获取具体产品实例的方法
     * @return 返回创建的实例对象
     */
    T product();
}

//具体工厂
class PhoneFactory implements IFactory<IProduct> {
    @Override
    public PhoneProduct product() {
        // 工厂标准方法中，完成指定产品对象的构建
        return new PhoneProduct();
    }
}

