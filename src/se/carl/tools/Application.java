package se.carl.tools;

import se.carl.registry.*;


public class Application {

    private final static Object lock = new Object();
    private final Registry registry;
    private final RemoteRegistry remoteRegistry;
    private CommandLineInterface commandLineInterface;
    private RegistryPersister registryPersister;
    private AutoSave autoSave;


    public Application() {
        registry = new Registry();
        remoteRegistry = new RemoteRegistry();
        registryPersister = new RegistryPersister();
        commandLineInterface = new CommandLineInterface(registry, remoteRegistry, this);
        registry.load(registryPersister.load());
        autoSave = new AutoSave(registry, lock);
    }

    public void start() {
        Thread thread = new Thread(autoSave);
        thread.start();
        commandLineInterface.start();
    }

    public void quit() {
        synchronized (lock) {
            System.exit(0);
        }
    }

    public Registry getRegistry() {
        return registry;
    }

    public RegistryPersister getRegistryPersister() {
        return registryPersister;
    }
}
