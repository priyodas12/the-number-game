package io.bootstrap;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    //fields
    private final Random random=new Random();
    private int maxNumber=100;

    //implemented methods
    @Override
    public int next() {
        return 0;
    }

    @Override
    public int getMaxNumber() {
        return 0;
    }
}
