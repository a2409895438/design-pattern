package singleton_pattern;

public class Singleton {
}

class Singleton1{
    private static Singleton1 instance;
    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if(instance == null){
            synchronized (Singleton1.class){
                if(instance == null){
                    instance = new Singleton1();
                }
            }
        }

        return instance;
    }
}
