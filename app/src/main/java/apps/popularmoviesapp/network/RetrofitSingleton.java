package apps.popularmoviesapp.network;


import apps.popularmoviesapp.BuildConfig;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RetrofitSingleton {
    private static Retrofit retrofit;
    private RetrofitSingleton(){}

    public static Retrofit newInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
