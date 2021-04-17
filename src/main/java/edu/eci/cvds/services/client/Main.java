package edu.eci.cvds.services.client;

import edu.eci.cvds.services.ServicesFactory;

public class Main {

    public static void main(String[] args) {
        System.out.print(ServicesFactory.getInstance().getServices());
    }
}
