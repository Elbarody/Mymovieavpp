package apps.popularmoviesapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import java.util.ArrayList;
import apps.popularmoviesapp.BuildConfig;
import apps.popularmoviesapp.models.Movie;

/**
 * Created by Kareem on 20/12/2016.
 */
public class FavoriteMoviesProvider {

    private ArrayList<Movie> result;

    public FavoriteMoviesProvider() {
    }

    public ArrayList<Movie> loadFavorites(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String favoritesString = sharedPreferences.getString(BuildConfig.FAVORITES_PREFERENCE_KEY, null);

        if (favoritesString == null)
            return null;


        result = new ArrayList<Movie>();

        String[] splitter = favoritesString.split("\\|");

        for (String element : splitter) {
            if (!element.equals("")) {
                try {
                    Gson gson = new Gson();
                    Movie movie = gson.fromJson(element, Movie.class);
                    result.add(movie);
                } catch (Exception ex) {
                }
            }
        }
        return result;
    }

    public void addToFavorite(Context context, Movie movie) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String favoritesString = sharedPreferences.getString(BuildConfig.FAVORITES_PREFERENCE_KEY, null);

        Gson gson = new Gson();
        String gsonStr = gson.toJson(movie);

        if (favoritesString == null) {
            favoritesString = gsonStr + "|";
        } else {
            favoritesString += gsonStr + "|";
        }

        saveSharedPreferences(context, favoritesString);
    }

    public void removeFromFavorite(Context context, Movie movie) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String favoritesString = sharedPreferences.getString(BuildConfig.FAVORITES_PREFERENCE_KEY, null);

        Gson gson = new Gson();
        String gsonStr = gson.toJson(movie);

        if (favoritesString == null) {
            return;
        } else {
            favoritesString = favoritesString.replace(gsonStr, "");
        }
        saveSharedPreferences(context, favoritesString);
    }

    public boolean isFavorite(Context context, Movie movie) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String favoritesString = sharedPreferences.getString(BuildConfig.FAVORITES_PREFERENCE_KEY, null);

        Gson gson = new Gson();
        String gsonStr = gson.toJson(movie);

        if (favoritesString == null) return false;
        return (favoritesString.indexOf(gsonStr) != -1) ? true : false;
    }

    private void saveSharedPreferences(Context context, String favorites) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(BuildConfig.FAVORITES_PREFERENCE_KEY, favorites);
        editor.commit();
    }
}
