package io.console;


import io.bootstrap.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    //logging
    private static final Logger log= LoggerFactory.getLogger(Main.class);

    //configuration
    //private static final String CONFIG_LOCATION="bean.xml";

    public static void main(String[] args) {
        log.info("debug from Main");

        //create context first
        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        //get NumberGenerator object from spring
        NumberGenerator ng=context.getBean(NumberGenerator.class);

        //call method to get a random number
        int number=ng.next();

        //log the number
        log.info("number={}",number);

        //get the game bean from context
        Game game=context.getBean(GameImpl.class);

        //reset the game
        game.reset();

        //get the MessageGenerator Bean
        MessageGeneratorImpl mg=context.getBean(MessageGeneratorImpl.class);

        //call both method
        log.info("getMainMessage {}",mg.getMainMessage());
        log.info("getResultMessage {}",mg.getResultMessage());
        //close context
        context.close();
    }
}
