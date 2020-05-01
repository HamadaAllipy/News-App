package pc.example.news.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import pc.example.news.pojo.Articles;
import pc.example.news.pojo.BaseObject;
import pc.example.news.service.Client;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelNews extends ViewModel {

     public MutableLiveData<ArrayList<Articles>> mutableLiveData = new MutableLiveData<>();

    public void getPost(){
        Call<BaseObject> call = Client.getINSTANCE().getData();
        call.enqueue(new Callback<BaseObject>() {
            @Override
            public void onResponse(Call<BaseObject> call, Response<BaseObject> response) {
             mutableLiveData.setValue(response.body().getArticles());
            }
            @Override
            public void onFailure(Call<BaseObject> call, Throwable t) {
                Log.i(ViewModelNews.class.getSimpleName() , " onFailure :::: " + t.getMessage());
            }
        });

    }
}
