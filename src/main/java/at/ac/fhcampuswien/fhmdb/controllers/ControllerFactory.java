package at.ac.fhcampuswien.fhmdb.controllers;

import javafx.util.Callback;

public class ControllerFactory implements Callback<Class<?>, Object> {

    private static MainController mainController;
    private static MovieListController movieListController;
    private static WatchlistController watchlistController;

    @Override
    public Object call(Class<?> aClass) {
        System.out.println(aClass.getSimpleName() + " called in ControllerFactory");
        try {
            if (aClass == MainController.class) {
                if (mainController == null) {
                    mainController = MainController.getInstance();
                }
                return mainController;
            } else if (aClass == MovieListController.class) {
                if (movieListController == null) {
                    movieListController = MovieListController.getInstance();
                }
                return movieListController;
            } else if (aClass == WatchlistController.class) {
                if (watchlistController == null) {
                    watchlistController = WatchlistController.getInstance();
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
