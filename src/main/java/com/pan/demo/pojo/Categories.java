package com.pan.demo.pojo;

import com.pan.demo.model.BookTag;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private String description;
    private List<String> xAxis=new ArrayList<>();
    private List<String> seriesData=new ArrayList<>();

    public Categories(List<BookTag> tagList) {
        for (int i = 0; i < tagList.size(); i++) {
            this.xAxis.add(tagList.get(i).getTitle());
            this.seriesData.add(tagList.get(i).getGrade());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public List<String> getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(List<String> seriesData) {
        this.seriesData = seriesData;
    }

    public static String getJsonString(List<String> xAxis, List<String> seriesData){
        StringBuilder res=new StringBuilder();
        res.append("{");
        res.append("\"xAxis\":[");

        for (int i = 0; i < xAxis.size()-1; i++) {
            res.append("\"");
            res.append(xAxis.get(i));
            res.append("\",");
        }
        res.append("\"");
        res.append(xAxis.get(xAxis.size()-1));
        res.append("\"");

        res.append("],\"seriesData\":[");

        for (int i = 0; i < seriesData.size()-1; i++) {
            res.append(seriesData.get(i));
            res.append(",");
        }
        res.append(seriesData.get(seriesData.size()-1));

        res.append("]}");

        return res.toString();
    }
}
