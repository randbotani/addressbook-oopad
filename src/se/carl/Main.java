package se.carl;

import se.carl.tools.*;

class Main {

    public static void main(String[] args) {
        Application.setupLogging();
        System.out.println("Let it go!");
        Application application = new Application();
        application.start();

    }
}
