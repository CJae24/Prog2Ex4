package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.List;

public class UnsortedState implements SortState {

    @Override
    public List<Movie> sort(List<Movie> movies) {
        return movies;
    }

}
