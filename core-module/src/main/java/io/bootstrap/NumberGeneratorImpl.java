package io.bootstrap;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

    //fields
    private final Random random=new Random();
    private int maxNumber=100;

    //implemented methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
