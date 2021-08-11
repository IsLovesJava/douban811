package com.pan.demo.service;

import com.pan.demo.model.Movie;

import java.util.List;

public interface MovieSercice {
    List<String> get100MovieLink(int strat);

    void upload(Movie movie);

    void update(Movie movie);
    /**    评分分布情况
     *
     * @return
     */
    String getRatingDistribution();

    String getRatingAndCount();

    String getLocation();

    String getMonthCount(String year);
}
