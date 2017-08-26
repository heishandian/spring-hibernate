package com.kk.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;


@Entity
@Table(name = "news", schema = "hibernate5")
public class NewsEntity {
    @Id
/*    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name="sequence", sequenceName = "new_sqs, allocationSize = 1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")*/
    private int id;

    @Basic
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Basic
    @Column(name = "AUTHOR", nullable = true, length = 255)
    private String author;

    @Basic
    @Column(name = "DATE", nullable = true)
    private Date date;

    @Basic
    @Column(name = "CONTENT", nullable = true)
    private String content;

    @Basic
    @Column(name = "PICTURE", nullable = true)
    private byte[] picture;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsEntity that = (NewsEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (!Arrays.equals(picture, that.picture)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
