package pc.example.news.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pc.example.news.R;
import pc.example.news.pojo.Articles;
import pc.example.news.pojo.BaseObject;
import pc.example.news.ui.main.ViewModelNews;

public class NewsFragment extends Fragment implements CustomAdapter.YasminListener {

    private final String LOG = NewsFragment.class.getSimpleName();
    TextView textView ;
    ViewModelNews viewModelNews ;
    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       Log.i(LOG , "on create view NewsFragment");
        View rootView = inflater.inflate(R.layout.recycler ,container, false);
        viewModelNews = new ViewModelNews();
        viewModelNews = ViewModelProviders.of(this).get(ViewModelNews.class);
        viewModelNews.getPost();
        CustomAdapter customAdapter = new CustomAdapter(getActivity() , this);
        RecyclerView recyclerView1 = rootView.findViewById(R.id.recycler_view);
        viewModelNews.mutableLiveData.observe(getViewLifecycleOwner()
                , new Observer<ArrayList<Articles>>() {
                    @Override
                    public void onChanged(ArrayList<Articles> articles) {
                        Log.i(NewsFragment.class.getSimpleName() , "onChanged :::" +articles.get(0).getTitle());
                        customAdapter.setArrayList(articles);
                    }
                });
        recyclerView1.setAdapter(customAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(linearLayoutManager);
        return rootView;
    }

    @Override
    public void yasminClick(int position) {
        Toast toast = Toast.makeText(getActivity() , "تم الضغط علي العنصر " , Toast.LENGTH_LONG);
        toast.show();
    }
}
