package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;

public class ControllerFactory implements Callback<Class<?>, Object> {

    private static MainController mainController;
    private static MovieListController movieListController;
    private static WatchlistController watchlistController;

    @Override
    public Object call(Class<?> aClass) {
        //System.out.println("Ich werde aufgerufen mit: " + aClass.getSimpleName());
        try {
            if (aClass == MainController.class) {
                if (mainController == null) {
                    mainController = new MainController();
                }
                return mainController;
            } else if (aClass == MovieListController.class) {
                if (movieListController == null) {
                    movieListController = new MovieListController();
                }
                return movieListController;
            } else if (aClass == WatchlistController.class) {
                if (watchlistController == null) {
                    watchlistController = new WatchlistController();
                }
                return watchlistController;
            } else {
                return aClass.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
