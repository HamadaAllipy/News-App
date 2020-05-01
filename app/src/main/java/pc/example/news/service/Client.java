package pc.example.news.service;

import java.util.ArrayList;

import pc.example.news.pojo.BaseObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {


    private ApiInterface apiInterface ;
    private static Client INSTANCE ;
    private final static String BASE_URL = "https://newsapi.org/v2/";
    private final static String API_KEYS = "5cbcb8ab538049e8bc9885d17ef32532";
    private final static String COUNTRY = "eg";

    public Client() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

    }

    public static Client getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new Client();
        }
        return INSTANCE;
    }

    public Call<BaseObject> getData(){
        return apiInterface.getData(COUNTRY , API_KEYS);
    }
}
