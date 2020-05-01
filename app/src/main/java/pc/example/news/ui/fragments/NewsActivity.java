package pc.example.news.ui.fragments;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pc.example.news.R;

public class NewsActivity extends AppCompatActivity {
    private final String LOG = NewsActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        Log.i(LOG , "onCreate NewsActivty");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containers, new NewsFragment())
                .commit();
    }
}
