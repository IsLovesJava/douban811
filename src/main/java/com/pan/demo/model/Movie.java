package com.pan.demo.model;

public class Movie {
    private String movieCode;
    private String movieName;

    private String type;
    private String location;
    private String language;
    private String length;
    private String datePublished;

    private String ratingCount;
    private String ratingValue;

    public Movie() {
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieCode='" + movieCode + '\'' +
                ", movieName='" + movieName + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", language='" + language + '\'' +
                ", length='" + length + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", ratingCount='" + ratingCount + '\'' +
                ", ratingValue='" + ratingValue + '\'' +
                '}';
    }
}
