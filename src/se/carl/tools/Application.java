package se.carl.tools;

import se.carl.registry.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Application {
    private static final Logger log = Logger.getLogger(Application.class.getName());

    private final static Object lock = new Object();
    private final Registry registry;
    private final RemoteRegistry remoteRegistry;
    private CommandLineInterface commandLineInterface;
    private RegistryPersister registryPersister;
    private AutoSave autoSave;


    public Application() {
        log.info("Background's activity:");
        registry = new Registry();
        remoteRegistry = new RemoteRegistry();
        registryPersister = new RegistryPersister();
        commandLineInterface = new CommandLineInterface(registry, remoteRegistry, this);
        registry.load(registryPersister.load());
        autoSave = new AutoSave(registry, lock);
    }

    public void start() {
        log.info("Starting program...");
        Thread thread = new Thread(autoSave);
        thread.start();
        commandLineInterface.start();
    }

    public void quit() {
        log.info("Finishing program...");
        synchronized (lock) {
            System.exit(0);
        }
    }

    public Registry getRegistry() {
        log.info("Starting the Registry.");
        return registry;
    }

    public RegistryPersister getRegistryPersister() {
        log.info("Starting the Registry Persister.");
        return registryPersister;
    }

    public static void setupLogging() {
        String loggingFilePath = "logging.properties";
        try (FileInputStream fileInputStream = new FileInputStream(loggingFilePath)) { //A2
            LogManager.getLogManager().readConfiguration(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load log properties.", e);
        }
    }
}
