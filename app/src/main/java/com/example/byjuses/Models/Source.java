package com.example.byjuses.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source implements Parcelable {

    @SerializedName("name")
    @ColumnInfo(name = "source_name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }




    public String getName() {
        return name;
    }



    protected Source(Parcel in) {
        name = in.readString();

    }

    public static final Parcelable.Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);

    }


}
