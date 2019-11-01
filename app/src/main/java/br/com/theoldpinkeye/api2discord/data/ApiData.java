package br.com.theoldpinkeye.api2discord.data;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiData implements Serializable, Parcelable {

    @SerializedName("target")
    @Expose
    private Object target;
    @SerializedName("html")
    @Expose
    private Object html;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Parcelable.Creator<ApiData> CREATOR = new Creator<ApiData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ApiData createFromParcel(Parcel in) {
            return new ApiData(in);
        }

        public ApiData[] newArray(int size) {
            return (new ApiData[size]);
        }

    };
    private final static long serialVersionUID = -7157917222153211410L;

    protected ApiData(Parcel in) {
        this.target = ((Object) in.readValue((Object.class.getClassLoader())));
        this.html = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.data, (br.com.theoldpinkeye.api2discord.data.Datum.class.getClassLoader()));
    }

    public ApiData() {
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getHtml() {
        return html;
    }

    public void setHtml(Object html) {
        this.html = html;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(target);
        dest.writeValue(html);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return "ApiData{" +
                "target=" + target +
                ", html=" + html +
                ", data=" + data +
                '}';
    }
}

