package com.pan.demo.service;

import com.pan.demo.pojo.Singer;

import java.util.List;

public interface MusicService {

    List<Singer> getPopularSinger(int n);
}
