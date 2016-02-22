package apps.popularmoviesapp.network;

import apps.popularmoviesapp.BuildConfig;
import apps.popularmoviesapp.models.FullResponse;
import apps.popularmoviesapp.models.Movie;
import apps.popularmoviesapp.models.ReviewResponse;
import apps.popularmoviesapp.models.TrailerResponse;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


public interface Request {
    @GET("discover/movie?api_key=" + BuildConfig.API_KEY)
    public Call<FullResponse> getFullResponse(@Query("sort_by") String sort_by, @Query("page")long page);

    @GET("movie/{id}?api_key=" + BuildConfig.API_KEY)
    Call<Movie> getMovie(@Path("id") long id);

    @GET("movie/{id}/videos?api_key=" + BuildConfig.API_KEY)
    public Call<TrailerResponse> getTrailer(@Path("id") long id);

    @GET("movie/{id}/reviews?api_key=" + BuildConfig.API_KEY)
    public Call<ReviewResponse> getReview(@Path("id") long id);

}
