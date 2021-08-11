package com.pan.demo.pojo;

import com.pan.demo.model.Tag;

import java.util.List;

public class PieChart {
    private String text;
    private String subtext;
    private List<Integer> valueList;
    private List<String> descriptionList;

    public PieChart() {
    }

    public PieChart(String text, String subtext) {
        this.text = text;
        this.subtext = subtext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public List<Integer> getValueList() {
        return valueList;
    }

    public void setValueList(List<Integer> valueList) {
        this.valueList = valueList;
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<String> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public String getJsonString() {
        StringBuilder res = new StringBuilder();
        res.append("{");

        res.append("\"text\":\""+text+"\",");
        res.append("\""+"subtext\":\""+subtext+"\",");

        res.append("\"data\":[");

        for (int i = 0; i < valueList.size() - 1; i++) {
            res.append("{\"value\":");
            res.append(valueList.get(i));
            res.append(",");

            res.append("\"name\":\"");
            res.append(descriptionList.get(i));
            res.append("\"},");

        }
        res.append("{\"value\":");
        res.append(valueList.get(valueList.size()-1));
        res.append(",");

        res.append("\"name\":\"");
        res.append(descriptionList.get(valueList.size()-1));
        res.append("\"}");

        res.append("]}");

        return res.toString();
    }

    public static String getJsonString(Tag[] tags,int length){

        length= Math.min(length, tags.length);

        StringBuilder res = new StringBuilder();
        res.append("{");

        res.append("\"text\":\""+"首映地点分布情况"+"\",");
        res.append("\""+"subtext\":\""+"不完全统计"+"\",");

        res.append("\"data\":[");

        for (int i = tags.length-1; i > tags.length - length; i--) {
            res.append("{\"value\":");
            res.append(tags[i].getTagCount());
            res.append(",");

            res.append("\"name\":\"");
            res.append(tags[i].getTagDescription());
            res.append("\"},");
        }

        int otherCount=0;
        for (int i = length-1; i >=0; i--) {
           otherCount=otherCount+tags[i].getTagCount();
        }

        res.append("{\"value\":");
        res.append(otherCount);
        res.append(",");

        res.append("\"name\":\"");
        res.append("其他");
        res.append("\"}");

        res.append("]}");

        return res.toString();
    }
}
