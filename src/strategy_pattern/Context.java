package strategy_pattern;

public class Context {
    Strategy strategy;
    public Context(Strategy s){
        strategy = s;
    }

    public void doStrategy(){
        strategy.algorithmInterface();
    }
}
