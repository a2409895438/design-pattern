package publish_subscribe_pattern;

import java.util.ArrayList;
import java.util.List;

public class PublishSubscribe {
}


//抽象目标
abstract class Subject
{
    protected List<Observer> observers=new ArrayList<Observer>();
    //增加观察者方法
    public void add(Observer observer)
    {
        observers.add(observer);
    }
    //删除观察者方法
    public void remove(Observer observer)
    {
        observers.remove(observer);
    }
    public abstract void notifyObserver(); //通知观察者方法
}
//具体目标
class ConcreteSubject extends Subject
{
    public void notifyObserver()
    {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for(Object obs:observers)
        {
            ((Observer)obs).response();
        }

    }
}
//抽象观察者
interface Observer
{
    void response(); //反应
}
//具体观察者1
class ConcreteObserver1 implements Observer
{
    public void response()
    {
        System.out.println("具体观察者1作出反应！");
    }
}
//具体观察者1
class ConcreteObserver2 implements Observer
{
    public void response()
    {
        System.out.println("具体观察者2作出反应！");
    }
}

abstract class Publish{
    protected List<Subscribe> subscribes;
    public void add(Subscribe subscribe){
        subscribes.add(subscribe);
    }
    public void remove(Subscribe subscribe){
        subscribes.remove(subscribe);
    }
    public abstract void notifySubscribes();
}

abstract class Subscribe{
    public abstract void response();
}
