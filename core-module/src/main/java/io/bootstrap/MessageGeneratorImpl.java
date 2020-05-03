package io.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    //logger
    private static final Logger log= LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //field
    @Autowired
    private Game game;

    private int guessCount=10;

    //postconstruct
    @PostConstruct
    public void generateGame(){
        log.debug("generateGame() called!");
    }

    @Override
    public String getMainMessage() {
        return "getMainMessage() called!";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() called!";
    }
}
