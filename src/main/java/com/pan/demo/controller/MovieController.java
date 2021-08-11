package com.pan.demo.controller;

import com.pan.demo.model.Movie;
import com.pan.demo.pojo.PieChart;
import com.pan.demo.service.MovieSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieSercice movieService;

    @GetMapping(value = "/movie")
    public String defaultPath() {
        return "forward:/page/movie.html";
    }


    @RequestMapping("/uploadMovie")
    @ResponseBody
    public void uploadMovie(Movie movie){
        movieService.upload(movie);
    }

    @RequestMapping("/updateMovie")
    @ResponseBody
    public void updateMovie(Movie movie){
        movieService.update(movie);
    }

    @RequestMapping("/getrating")
    @ResponseBody
    public String getrating(){
        return movieService.getRatingDistribution();
    }

    @RequestMapping("/getLocation")
    @ResponseBody
    public String getLocation(){
        return movieService.getLocation();
    }

    @RequestMapping("/getRatingAndCount")
    @ResponseBody
    public String getRatingAndCount(){
        return movieService.getRatingAndCount();
    }


    @RequestMapping("/getMonthCount")
    @ResponseBody
    public String getMonthCount(String year){
        return movieService.getMonthCount(year);
    }

}
