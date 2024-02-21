package facade_pattern;

public class Facade {
    SubSystemA A;
    SubSystemA B;
    SubSystemA C;
    SubSystemA D;

    public Facade(SubSystemA a, SubSystemA b, SubSystemA c, SubSystemA d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public void methodA(){
        A.method();
        B.method();
    }
    public void methodB(){
        C.method();
        D.method();
    }
}

class SubSystemA{
    public void method(){

    }
}
class SubSystemB{
    public void method(){

    }
}

class SubSystemC{
    public void method(){

    }
}

class SubSystemD{
    public void method(){

    }
}

