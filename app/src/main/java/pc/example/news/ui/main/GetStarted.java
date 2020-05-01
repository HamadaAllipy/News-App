package pc.example.news.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pc.example.news.R;

public class GetStarted extends AppCompatActivity {

    ImageView imageView ;
    Button btnStart ;
    ViewModelNews viewModelNews ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started);
//        TextView textView = findViewById(R.id.author);
//        viewModelNews = new ViewModelNews();
//        viewModelNews = ViewModelProviders.of(this).get(ViewModelNews.class);
//        viewModelNews.getPost();
//        viewModelNews.mutableLiveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.i(GetStarted.class.getSimpleName() , "i love yasmin " + s);
//                textView.setText(s);
//            }
//        });

        imageView = findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.myanim);
        imageView.startAnimation(animation);

        btnStart = findViewById(R.id.btnstarted);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetStarted.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
