package br.com.theoldpinkeye.api2discord.data;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable, Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("drop_txt")
    @Expose
    private String dropTxt;
    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
            ;
    private final static long serialVersionUID = -5327138784707262254L;

    protected Datum(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.dropTxt = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDropTxt() {
        return dropTxt;
    }

    public void setDropTxt(String dropTxt) {
        this.dropTxt = dropTxt;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(dropTxt);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "date='" + date + '\'' +
                ", dropTxt='" + dropTxt + '\'' +
                '}';
    }
}
