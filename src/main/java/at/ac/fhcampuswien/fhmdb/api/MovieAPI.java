package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import okhttp3.*;
import com.google.gson.Gson;

import java.util.*;

public class MovieAPI {
    private static final String URL = "https://prog2.fh-campuswien.ac.at/movies"; // https if certificates work
    private static final OkHttpClient client = new OkHttpClient();

    public static List<Movie> getMovies(MovieAPIBuilder builder) throws MovieApiException {
        String url = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "http.agent")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            Gson gson = new Gson();
            Movie[] movies = gson.fromJson(responseBody, Movie[].class);

            return Arrays.asList(movies);
        } catch (Exception e) {
            throw new MovieApiException(e.getMessage());
        }
    }


    public static class MovieAPIBuilder {
        private final String base;
        private String query;
        private Genre genre;
        private String releaseYear;
        private String ratingFrom;

        public MovieAPIBuilder() {
            this.base = URL;
        }

        public MovieAPIBuilder query(String query) {
            this.query = query;
            return this;
        }

        public MovieAPIBuilder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public MovieAPIBuilder releaseYear(String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public MovieAPIBuilder ratingFrom(String ratingFrom) {
            this.ratingFrom = ratingFrom;
            return this;
        }

        public String build() {
            StringBuilder url = new StringBuilder(this.base);
            List<String> params = new ArrayList<>();

            if (this.query != null && !this.query.isEmpty()) {
                params.add("query=" + this.query);
            }
            if (this.genre != null) {
                params.add("genre=" + this.genre);
            }
            if (this.releaseYear != null) {
                params.add("releaseYear=" + this.releaseYear);
            }
            if (this.ratingFrom != null) {
                params.add("ratingFrom=" + this.ratingFrom);
            }

            if (!params.isEmpty()) {
                url.append("?").append(String.join("&", params));
            }

            return url.toString();
        }

    }

}

