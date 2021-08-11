package com.pan.demo.pojo;

public class Singer {
    private String name;
    private String songCount;
    private String avgRating;

    public Singer() {
    }

    public Singer(String name, String songCount, String avgRating) {
        this.name = name;
        this.songCount = songCount;
        this.avgRating = avgRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount;
    }

    public String getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(String avgRating) {
        this.avgRating = avgRating;
    }
}
