package com.safiya.obviousassignment;

import android.os.Parcel;
import android.os.Parcelable;

public class GridImages implements Parcelable {

    protected GridImages(Parcel in) {
        date = in.readString();
        explanation = in.readString();
        hdurl = in.readString();
        media_type = in.readString();
        service_version = in.readString();
        title = in.readString();
        copyright = in.readString();
        url = in.readString();
    }
    protected  GridImages(){
        
    }

    public static final Creator<GridImages> CREATOR = new Creator<GridImages>() {
        @Override
        public GridImages createFromParcel(Parcel in) {
            return new GridImages(in);
        }

        @Override
        public GridImages[] newArray(int size) {
            return new GridImages[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public void setService_version(String service_version) {
        this.service_version = service_version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String date;
    String explanation;
    String hdurl;
    String media_type;
    String service_version;
    String title;
    String url;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    String copyright;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(explanation);
        dest.writeString(hdurl);
        dest.writeString(service_version);
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(copyright);
        dest.writeString(media_type);

    }
}
