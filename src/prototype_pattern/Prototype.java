package prototype_pattern;

public class Prototype {
}

//原型类
abstract class Proto_ implements Cloneable{
    private String id;

    public Proto_(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    protected Object clone(){
        Object object = null;
        try {
            object = super.clone();
        }catch (CloneNotSupportedException exception){
            System.err.println("Clone异常");
        }
        return object;
    }
}

//具体原型类
class ConcretePrototype extends  Proto_{
    public ConcretePrototype(String id) {
        super(id);
    }
}