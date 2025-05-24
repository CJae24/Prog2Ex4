package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import java.util.List;

public class SortManager {
    private SortState currentState;

    public SortManager() {
        this.currentState = new UnsortedState();
    }

    public void setState(SortState state) {
        this.currentState = state;
    }

    public SortState getState() {
        return currentState;
    }

    public List<Movie> sort(List<Movie> movies) {
        return currentState.sort(movies);
    }
}
