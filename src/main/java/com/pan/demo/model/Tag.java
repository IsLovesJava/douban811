package com.pan.demo.model;

public class Tag implements Comparable<Tag>{
    private String tagDescription;
    private int tagCount;

    public Tag() {
    }

    public Tag(String tagDescription, int tagCount) {
        this.tagDescription = tagDescription;
        this.tagCount = tagCount;
    }

    public String getTagDescription() {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription) {
        this.tagDescription = tagDescription;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    @Override
    public int compareTo(Tag tag) {
        return Integer.compare(this.tagCount, tag.getTagCount());
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagDescription='" + tagDescription + '\'' +
                ", tagCount=" + tagCount +
                '}';
    }
}
