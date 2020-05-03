package io.console;

import io.bootstrap.Game;
import io.bootstrap.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {
    //logger
    private static final Logger logger= LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //fields
    @Autowired
    private Game game;
    @Autowired
    private MessageGenerator mg;


    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("start()-->container ready for use");

        Scanner scn=new Scanner(System.in);

        while(true){
            System.out.println(mg.getMainMessage());
            System.out.println(mg.getResultMessage());

            int guess=scn.nextInt();
            scn.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(mg.getResultMessage());
                System.out.println("play again y/n ?");

                String playAgainString=scn.nextLine().trim();
                if(playAgainString.equalsIgnoreCase("n")){
                    break;
                }
                game.reset();
            }
        }
    }

}
