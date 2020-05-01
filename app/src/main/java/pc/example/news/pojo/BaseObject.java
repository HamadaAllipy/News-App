package pc.example.news.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseObject {

    @SerializedName("articles")
    @Expose
    private ArrayList<Articles> articles ;

    @SerializedName("status")
    @Expose
    private String status ;

    @SerializedName("totalResults")
    @Expose
    private String totalResults ;


    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }
}

