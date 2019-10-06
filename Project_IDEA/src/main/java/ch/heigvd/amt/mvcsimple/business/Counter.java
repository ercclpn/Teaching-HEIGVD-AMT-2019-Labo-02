package ch.heigvd.amt.mvcsimple.business;

import ch.heigvd.amt.mvcsimple.business.local.CounterLocal;

import javax.ejb.Stateless;

@Stateless
public class Counter implements CounterLocal {
    private int counter = 0;

    public void resetCounter(){
        this.counter = 0;
    }

    public void incrementCounter(){
        this.counter += 1;
    }

    public int getCounterValue(){
        return this.counter;
    }
}
