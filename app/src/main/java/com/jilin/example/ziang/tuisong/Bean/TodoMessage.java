package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author huiliu
 * @date 2017/11/16
 * @email liu594545591@126.com
 * @introduce
 */
public class TodoMessage implements Parcelable {

    /**
     * 指定自增，每个对象需要有一个主键
     */
    private int key_id;
    private String id;
    private String title;
    private String content;
    private int type;
    private String time;

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TodoMessage{" +
                "key_id=" + key_id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.key_id);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.type);
        dest.writeString(this.time);
    }

    public TodoMessage() {
    }

    protected TodoMessage(Parcel in) {
        this.key_id = in.readInt();
        this.id = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.type = in.readInt();
        this.time = in.readString();
    }

    public static final Creator<TodoMessage> CREATOR = new Creator<TodoMessage>() {
        @Override
        public TodoMessage createFromParcel(Parcel source) {
            return new TodoMessage(source);
        }

        @Override
        public TodoMessage[] newArray(int size) {
            return new TodoMessage[size];
        }
    };
}
