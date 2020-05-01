package pc.example.news.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articles {


    @SerializedName("author")
    @Expose
    private String author ;

    @SerializedName("title")
    @Expose
    private String title ;

    @SerializedName("source")
    @Expose
    private Source source ;

    @SerializedName("description")
    @Expose
    private String description ;

    @SerializedName("url")
    @Expose
    private String url ;

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage ;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt ;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Source getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
