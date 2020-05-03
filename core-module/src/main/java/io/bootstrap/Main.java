package io.bootstrap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    //logging
    private static final Logger log= LoggerFactory.getLogger(Main.class);

    //configuration
    private static final String CONFIG_LOCATION="bean.xml";

    public static void main(String[] args) {
        log.info("debug from Main");

        //create context first
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //get NumberGenerator object from spring
        NumberGenerator ng=context.getBean("numberGenerator",NumberGenerator.class);

        //call method to get a random number
        int number=ng.next();

        //log the number
        log.info("number={}",number);

        //get the game bean from context
        Game game=context.getBean(GameImpl.class);

        //reset the game
        game.reset();

        //close context
        context.close();
    }
}
