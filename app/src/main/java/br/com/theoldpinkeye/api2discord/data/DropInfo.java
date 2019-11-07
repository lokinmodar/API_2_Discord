package br.com.theoldpinkeye.api2discord.data;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DropInfo implements Serializable, Parcelable {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Guildcard Number")
    @Expose
    private String guildcard;
    @SerializedName("Hex")
    @Expose
    private String hex;
    @SerializedName("has received")
    @Expose
    private String item;


    protected DropInfo(Parcel in) {
        date = in.readString();
        username = in.readString();
        guildcard = in.readString();
        hex = in.readString();
        item = in.readString();
    }

    public static final Creator<DropInfo> CREATOR = new Creator<DropInfo>() {
        @Override
        public DropInfo createFromParcel(Parcel in) {
            return new DropInfo(in);
        }

        @Override
        public DropInfo[] newArray(int size) {
            return new DropInfo[size];
        }
    };

    public DropInfo(String date, String username, String guildcard, String hex, String item) {
        this.date = date;
        this.username = username;
        this.guildcard = guildcard;
        this.hex = hex;
        this.item = item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(username);
        dest.writeString(guildcard);
        dest.writeString(hex);
        dest.writeString(item);
    }

    public String getDate() {
        return date;
    }

    public DropInfo setDate(String date) {
        this.date = date;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DropInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getGuildcard() {
        return guildcard;
    }

    public DropInfo setGuildcard(String guildcard) {
        this.guildcard = guildcard;
        return this;
    }

    public String getHex() {
        return hex;
    }

    public DropInfo setHex(String hex) {
        this.hex = hex;
        return this;
    }

    public String getItem() {
        return item;
    }

    public DropInfo setItem(String item) {
        this.item = item;
        return this;
    }

    @Override
    public String toString() {
        return "DropInfo{" +
                "date='" + date + '\'' +
                ", username='" + username + '\'' +
                ", guildcard='" + guildcard + '\'' +
                ", hex='" + hex + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
