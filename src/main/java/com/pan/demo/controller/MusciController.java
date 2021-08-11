package com.pan.demo.controller;

import com.pan.demo.pojo.Singer;
import com.pan.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MusciController {

    @Autowired
    MusicService musicService;

    @RequestMapping("/popularSinger")
    @ResponseBody
    public List<Singer> popularSinger(int amount){
        return musicService.getPopularSinger(amount);
    }

    @RequestMapping("/music")
    public String musicIndex(){
        return "forward:/page/music.html";
    }

    @RequestMapping("/music/tag")
    public String musicTag(){
        return "forward:/page/music.html";
    }
}
