package apps.popularmoviesapp.models;

import java.util.ArrayList;

public class TrailerResponse {
    private long id;

    private ArrayList<Trailer> results = new ArrayList<Trailer>();

    public ArrayList<Trailer> getResults() {
        return results;
    }

    public long getId() {
        return id;
    }

}
