package com.jilin.example.ziang.tuisong.Bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by huiliu on 2018/3/6.
 *
 * @email liu594545591@126.com
 * @introduce
 */
public class TodoEkongMessage implements Parcelable {
    /**
     * 指定自增，每个对象需要有一个主键
     */
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int primary_id;
    private String id;
    private String title;
    private String content;
    private int type;
    private String time;

    public int getKey_id() {
        return primary_id;
    }

    public void setKey_id(int key_id) {
        this.primary_id = key_id;
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
                "key_id=" + primary_id +
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
        dest.writeInt(this.primary_id);
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeInt(this.type);
        dest.writeString(this.time);
    }

    public TodoEkongMessage() {
    }

    protected TodoEkongMessage(Parcel in) {
        this.primary_id = in.readInt();
        this.id = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.type = in.readInt();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<TodoEkongMessage> CREATOR = new Parcelable.Creator<TodoEkongMessage>() {
        @Override
        public TodoEkongMessage createFromParcel(Parcel source) {
            return new TodoEkongMessage(source);
        }

        @Override
        public TodoEkongMessage[] newArray(int size) {
            return new TodoEkongMessage[size];
        }
    };
}
