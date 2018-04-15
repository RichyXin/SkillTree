package com.richy.skilltree.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * User: Richy
 * Date: 2018-04-15
 * Time: 16:24
 */
public class Book implements Parcelable{
    char name;
    String info;

    public Book(char name, String info) {
        this.name = name;
        this.info = info;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.name);
        dest.writeString(this.info);
    }

    protected Book(Parcel in) {
        this.name = (char) in.readInt();
        this.info = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
