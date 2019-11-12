package br.com.theoldpinkeye.api2discord.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Author implements Serializable, Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    public final static Parcelable.Creator<Author> CREATOR = new Creator<Author>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        public Author[] newArray(int size) {
            return (new Author[size]);
        }

    }
            ;
    private final static long serialVersionUID = -4628210545909152073L;

    protected Author(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.iconUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Author() {
    }

    /**
     *
     * @param name
     * @param iconUrl
     * @param url
     */
    public Author(String name, String url, String iconUrl) {
        super();
        this.name = name;
        this.url = url;
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author withName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Author withUrl(String url) {
        this.url = url;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Author withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("url", url).append("iconUrl", iconUrl).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(url);
        dest.writeValue(iconUrl);
    }

    public int describeContents() {
        return 0;
    }

}
