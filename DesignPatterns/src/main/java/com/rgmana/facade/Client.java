package com.rgmana.facade;

public class Client {

    public static void main(String[] args) {
        HomeTheateFacade homeTheateFacade = new HomeTheateFacade();

        homeTheateFacade.ready();
        homeTheateFacade.play();
        homeTheateFacade.pause();
        homeTheateFacade.end();
    }
}
