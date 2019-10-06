package ch.heigvd.amt.mvcsimple.business.local;

public interface CounterLocal {
    void resetCounter();
    void incrementCounter();
    int getCounterValue();
}
