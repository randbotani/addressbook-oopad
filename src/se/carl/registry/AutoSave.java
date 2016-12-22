package se.carl.registry;



import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;


public class AutoSave implements Runnable{
    private static final Logger log = Logger.getLogger(AutoSave.class.getName());


    private Registry saveContacts;
    private Timer timer = new Timer();
    private RegistryPersister registryPersister = new RegistryPersister();
    private Object lock;

    public AutoSave(Registry registry, Object lock){
        log.info("Setting Auto Save...");
        saveContacts = registry;
        this.lock = lock;
    }

    private void save(){
        log.info("Saving contacts...");
        registryPersister.save(saveContacts);
    }

    @Override
    public synchronized void run() {
        log.info("Timer Schedule is running...");

        timer.schedule(new TimerTask() {

            public void run() {
                try {
                    save();
                } catch (Exception e) {
                    log.severe("Error: " + e);
                    e.printStackTrace();
                }
            }
        }, 5 * 1000, 5 * 1000);
    }
}