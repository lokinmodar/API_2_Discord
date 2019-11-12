package br.com.theoldpinkeye.api2discord.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class DropJson implements Serializable, Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("embeds")
    @Expose
    private List<Embed> embeds = null;
    public final static Parcelable.Creator<DropJson> CREATOR = new Creator<DropJson>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DropJson createFromParcel(Parcel in) {
            return new DropJson(in);
        }

        public DropJson[] newArray(int size) {
            return (new DropJson[size]);
        }

    };

    private final static long serialVersionUID = 1810576626499259713L;

    protected DropJson(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.avatarUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.content = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.embeds, (br.com.theoldpinkeye.api2discord.data.Embed.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DropJson() {
    }

    /**
     *
     * @param avatarUrl
     * @param embeds
     * @param content
     * @param username
     */
    public DropJson(String username, String avatarUrl, String content, List<Embed> embeds) {
        super();
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.content = content;
        this.embeds = embeds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DropJson withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public DropJson withAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DropJson withContent(String content) {
        this.content = content;
        return this;
    }

    public List<Embed> getEmbeds() {
        return embeds;
    }

    public void setEmbeds(List<Embed> embeds) {
        this.embeds = embeds;
    }

    public DropJson withEmbeds(List<Embed> embeds) {
        this.embeds = embeds;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("username", username).append("avatarUrl", avatarUrl).append("content", content).append("embeds", embeds).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(avatarUrl);
        dest.writeValue(content);
        dest.writeList(embeds);
    }

    public int describeContents() {
        return 0;
    }

}
