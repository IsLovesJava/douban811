package com.pan.demo.service.impl;

import com.pan.demo.mapper.MovieMapper;
import com.pan.demo.model.Movie;
import com.pan.demo.model.Tag;
import com.pan.demo.pojo.PieChart;
import com.pan.demo.pojo.ScatterChart;
import com.pan.demo.service.MovieSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.*;

@Service("movieService")
public class MovieServiceImpl implements MovieSercice {
    @Autowired
    MovieMapper movieMapper;

    @Override
    public List<String> get100MovieLink(int strat){
        return movieMapper.select100MovieCode(strat);
    }

    @Override
    public void upload(Movie movie) {
        movieMapper.insertMovie(movie);
    }

    @Override
    public void update(Movie movie) {
        movieMapper.updateMovieInfo(movie);
    }


    @Override
    public String getRatingDistribution() {
        List<Integer> res=new ArrayList<>();
        List<String> des=new ArrayList<>();
        des.add("0~2");
        des.add("2~4");
        des.add("4~6");
        des.add("6~8");
        des.add("8~10");
        res.add(movieMapper.getRatingCount(0,2));
        res.add(movieMapper.getRatingCount(2,4));
        res.add(movieMapper.getRatingCount(4,6));
        res.add(movieMapper.getRatingCount(6,8));
        res.add(movieMapper.getRatingCount(8,10));

        PieChart pieChart=new PieChart("电影评分分布情况","不完全统计");

        pieChart.setValueList(res);
        pieChart.setDescriptionList(des);

        return pieChart.getJsonString();
    }

    @Override
    public String getRatingAndCount() {

        ScatterChart scatterChart=new ScatterChart();
        scatterChart.setMovieNameList(movieMapper.selectMovieNameList());
        scatterChart.setRatingCountList(movieMapper.selectRatingCountList());
        scatterChart.setRatingList(movieMapper.selectRatingList());

        return scatterChart.getJsonString();

    }

    @Override
    public String getLocation() {
        List<String> locationList=movieMapper.selectLocationGroup();
        Set<String> set=new HashSet<>();

        for (int i = 0; i < locationList.size(); i++) {
            String str=locationList.get(i);
            if (str!=null){
                if (str.contains("/")){
                    String[] list=str.split("/");
                    for (int i1 = 0; i1 < list.length; i1++) {
                        String s=list[i1].trim();
                        set.add(s);
                    }
                }else {
                   set.add(str);
                }
            }
        }

        List<Tag> tagList=new ArrayList<>();
        for (String s : set) {
            tagList.add(new Tag(s,movieMapper.getLocationCount(s)));
        }

        Tag[] tags = tagList.toArray(new Tag[0]);
        Arrays.sort(tags);

        return PieChart.getJsonString(tags,20);
    }

    @Override
    public String getMonthCount(String year) {
        StringBuilder res= new StringBuilder();
        res.append("{");
        res.append("\"year\":").append(year).append(",");
        res.append("\"data\":[");
        res.append(movieMapper.getSingleMonth(year, "01")).append(",");
        res.append(movieMapper.getSingleMonth(year, "02")).append(",");
        res.append(movieMapper.getSingleMonth(year, "03")).append(",");
        res.append(movieMapper.getSingleMonth(year, "04")).append(",");
        res.append(movieMapper.getSingleMonth(year, "05")).append(",");
        res.append(movieMapper.getSingleMonth(year, "06")).append(",");
        res.append(movieMapper.getSingleMonth(year, "01")).append(",");
        res.append(movieMapper.getSingleMonth(year, "08")).append(",");
        res.append(movieMapper.getSingleMonth(year, "09")).append(",");
        res.append(movieMapper.getSingleMonth(year, "10")).append(",");
        res.append(movieMapper.getSingleMonth(year, "11")).append(",");
        res.append(movieMapper.getSingleMonth(year, "12")).append("]}");

        return res.toString();
    }

}
