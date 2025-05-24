package at.ac.fhcampuswien.fhmdb.sorting;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Comparator;
import java.util.List;

public class AscendingState implements SortState {

    @Override
    public List<Movie> sort(List<Movie> movies) {
        movies.sort(Comparator.comparing(Movie::getTitle));
        return movies;
    }

}
