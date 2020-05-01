package pc.example.news.service;

import java.util.ArrayList;

import pc.example.news.pojo.BaseObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<BaseObject> getData(@Query("country") String country ,
                            @Query("apiKey") String apiKey);
}
