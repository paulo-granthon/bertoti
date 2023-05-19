package tests.utils;

import pulgas.utils.RandGen;

public class MockRandGen extends RandGen {

    private boolean alwaysReturns;

    public MockRandGen (boolean alwaysReturns) {
        this.alwaysReturns = alwaysReturns;
    }

    @Override
    public boolean happens (int min, int max, int happensBellow) {
        return alwaysReturns;
    }

    @Override
    public int randInt (int min, int max) {
        lastInt = alwaysReturns ? max : min;
        return lastInt;
    }

    @Override
    public double randDouble (double min, double max) {
        lastDouble = alwaysReturns ? max : min;
        return lastDouble;
    }

}

