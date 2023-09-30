package fr.paulem.things.item;

import fr.paulem.things.Things;

public class Initer {
    private static int registeredNumber = 0;

    public void init(){
        registeredNumber++;
        Things.LOGGER.info("Registered n" + registeredNumber);
    }
}
