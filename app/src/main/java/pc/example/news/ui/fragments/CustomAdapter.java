package pc.example.news.ui.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import pc.example.news.R;
import pc.example.news.Utils;
import pc.example.news.pojo.Articles;
import pc.example.news.pojo.BaseObject;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Articles> arrayList = new ArrayList<>();
    private Context context;
    private YasminListener yasminListener ;


    public CustomAdapter(Context context, YasminListener yasminListener) {
        this.context = context;
        this.yasminListener = yasminListener;
    }

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new CustomViewHolder(rootView , yasminListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();
        Glide.with(context)
                .load(arrayList.get(position).getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                        holder.mProgressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        holder.mProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                }).transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.mImageView);
        holder.mTitle.setText(arrayList.get(position).getTitle());
        holder.mDesc.setText(arrayList.get(position).getDescription());
        holder.mAuthor.setText(arrayList.get(position).getAuthor());
        holder.mSource.setText(arrayList.get(position).getSource().getName());
        holder.mTime.setText("\u2022" +
                Utils.DateToTimeFormat(arrayList.get(position).getPublishedAt()));
        holder.mPublishedAt.setText(Utils.DateFormat(arrayList.get(position).getPublishedAt()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setArrayList(ArrayList<Articles> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView mTitle, mDesc, mSource, mAuthor, mTime, mPublishedAt;
        ImageView mImageView;
        ProgressBar mProgressBar;
        YasminListener yasminListener ;

        public CustomViewHolder(@NonNull View itemView , YasminListener yasminListener) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.mtitle);
            mDesc = itemView.findViewById(R.id.desc);
            mSource = itemView.findViewById(R.id.source);
            mAuthor = itemView.findViewById(R.id.author);
            mPublishedAt = itemView.findViewById(R.id.publishedAt);
            mTime = itemView.findViewById(R.id.mTTime);
            mImageView = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(this);
            this.yasminListener = yasminListener ;

            mProgressBar = itemView.findViewById(R.id.progress_laod_photo);
        }

        @Override
        public void onClick(View v) {
            yasminListener.yasminClick(getAdapterPosition());
        }
    }
    public interface YasminListener{
        void yasminClick(int position);
    }
}
