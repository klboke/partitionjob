package com.kailing.bootbatch.partitionjob.entity;

import javax.persistence.*;

/**
 * Created by kl on 2018/3/14.
 * Content :文章实体
 */
@Entity
@Table(name = "kl_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "arcid", nullable = false)
    private long arcid;
    private String username;
    private String property;
    private String pic;
    private long colid;
    private String keyword;
    private String description;
    private String content;
    private long createtime;
    private long updatetime;
    private long click;
    private long mid;
    private String source;
    private long ord;
    private String title;
    private long ischeck;


    public long getArcid() {
        return arcid;
    }

    public void setArcid(long arcid) {
        this.arcid = arcid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public long getColid() {
        return colid;
    }

    public void setColid(long colid) {
        this.colid = colid;
    }


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }


    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }


    public long getClick() {
        return click;
    }

    public void setClick(long click) {
        this.click = click;
    }


    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public long getOrd() {
        return ord;
    }

    public void setOrd(long ord) {
        this.ord = ord;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public long getIscheck() {
        return ischeck;
    }

    public void setIscheck(long ischeck) {
        this.ischeck = ischeck;
    }


}
