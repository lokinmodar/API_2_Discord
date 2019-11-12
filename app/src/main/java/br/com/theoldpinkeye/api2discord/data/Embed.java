package br.com.theoldpinkeye.api2discord.data;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Embed implements Serializable, Parcelable
{

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("color")
    @Expose
    private Integer color;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("author")
    @Expose
    private Author author;
    public final static Parcelable.Creator<Embed> CREATOR = new Creator<Embed>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Embed createFromParcel(Parcel in) {
            return new Embed(in);
        }

        public Embed[] newArray(int size) {
            return (new Embed[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5845416450468705215L;

    protected Embed(Parcel in) {
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.color = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.timestamp = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((Author) in.readValue((Author.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Embed() {
    }

    /**
     *
     * @param color
     * @param author
     * @param description
     * @param url
     * @param timestamp
     */
    public Embed(String description, String url, Integer color, String timestamp, Author author) {
        super();
        this.description = description;
        this.url = url;
        this.color = color;
        this.timestamp = timestamp;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Embed withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Embed withUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Embed withColor(Integer color) {
        this.color = color;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Embed withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Embed withAuthor(Author author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("description", description).append("url", url).append("color", color).append("timestamp", timestamp).append("author", author).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(description);
        dest.writeValue(url);
        dest.writeValue(color);
        dest.writeValue(timestamp);
        dest.writeValue(author);
    }

    public int describeContents() {
        return 0;
    }

}