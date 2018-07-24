package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * @author huiliu
 * @date 2017/10/10
 *
 * @email liu594545591@126.com
 * @introduce  智羽
 */
public class ZyPushMessage implements Parcelable {
    private long time;

    private int type;

    private String obj;

    private String title;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.time);
        dest.writeInt(this.type);
        dest.writeString(this.obj);
        dest.writeString(this.title);
    }

    public ZyPushMessage() {
    }

    private ZyPushMessage(Parcel in) {
        this.time = in.readLong();
        this.type = in.readInt();
        this.obj = in.readString();
        this.title = in.readString();
    }

    public static final Creator<ZyPushMessage> CREATOR = new Creator<ZyPushMessage>() {
        @Override
        public ZyPushMessage createFromParcel(Parcel source) {
            return new ZyPushMessage(source);
        }

        @Override
        public ZyPushMessage[] newArray(int size) {
            return new ZyPushMessage[size];
        }
    };
}
