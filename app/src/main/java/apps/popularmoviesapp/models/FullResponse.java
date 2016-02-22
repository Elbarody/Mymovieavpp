package apps.popularmoviesapp.models;

import java.util.ArrayList;

public class FullResponse {
    private Long page;
    private ArrayList<Movie> results = new ArrayList<Movie>();
    private long total_results;
    private long total_pages;

    public Long getPage() {
        return page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public long getTotal_results() {
        return total_results;
    }

    public long getTotal_pages() {
        return total_pages;
    }
}
