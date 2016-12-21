package se.carl.registry;



import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class AutoSave implements Runnable{
    private Registry regToSave;
    private Timer timer = new Timer();
    private RegistryPersister registryPersister = new RegistryPersister();
    private Object lock;

    public AutoSave(Registry registry, Object lock){
        regToSave = registry;
        this.lock = lock;
    }

    private void save(){
        registryPersister.save(regToSave);
    }

    @Override
    public synchronized void run() {
        timer.schedule(new TimerTask() {

            public void run() {
                try {
                    save();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 5 * 1000, 5 * 1000);
    }
}