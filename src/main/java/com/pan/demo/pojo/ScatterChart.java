package com.pan.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.pan.demo.model.Tag;

import java.util.List;

/**
 * @author EVA
 */
public class ScatterChart {
    @JSONField(name = "movieNameList")
    private List<String> movieNameList;
    @JSONField(name = "ratingList")
    private List<Double> ratingList;
    @JSONField(name = "ratingCountList")
    private List<Integer> ratingCountList;

    public ScatterChart() {
    }

    public List<String> getMovieNameList() {
        return movieNameList;
    }

    public void setMovieNameList(List<String> movieNameList) {
        this.movieNameList = movieNameList;
    }

    public List<Double> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Double> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Integer> getRatingCountList() {
        return ratingCountList;
    }

    public void setRatingCountList(List<Integer> ratingCountList) {
        this.ratingCountList = ratingCountList;
    }

    public String getJsonString(){
        StringBuilder res=new StringBuilder();
        res.append("{");
        res.append("\"movieNameList\":[");

        for (int i = 0; i < movieNameList.size()-1; i++) {
            res.append("\"");
            res.append(movieNameList.get(i));
            res.append("\",");
        }
        res.append("\"");
        res.append(movieNameList.get(movieNameList.size()-1));
        res.append("\"");

        res.append("],\"data\":[");

        for (int i = 0; i < ratingCountList.size()-1; i++) {
            res.append("[");
            res.append(ratingCountList.get(i));
            res.append(",");
            res.append(ratingList.get(i));
            res.append("]");
            res.append(",");
        }

        res.append("[");
        res.append(ratingCountList.get(ratingCountList.size()-1));
        res.append(",");
        res.append(ratingList.get(ratingCountList.size()-1));
        res.append("]");
        res.append("]}");

        return res.toString();
    }


}
