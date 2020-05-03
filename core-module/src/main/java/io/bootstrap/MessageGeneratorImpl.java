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
    public void init(){
        log.debug("bean initialised {}",game);
    }

    @Override
    public String getMainMessage() {
        return "Number is in between "+game.getSmallest()
                +" and "+game.getBiggest()+" Can u Guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "you guessed it and number is "+game.getNumber();
        }
        else if(game.isGameLost()){
            return "you lost the game and the number is "+game.getNumber();
        }
        else if(!game.isValidNumberRange()){
            return "Not in valid number range!";
        }
        else if(game.getRemainingGuesses()==guessCount){
            return "waht is your first guess";
        }
        else{
            String direction="LOWER";

            if(game.getGuess()<game.getNumber()){
                direction="HIGHER";
            }
            return direction+" ! you have "+game.getRemainingGuesses()+" guess left!";
        }
    }
}
