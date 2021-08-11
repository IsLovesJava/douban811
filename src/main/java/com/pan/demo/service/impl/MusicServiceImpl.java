package com.pan.demo.service.impl;

import com.pan.demo.mapper.MusicMapper;
import com.pan.demo.pojo.Singer;
import com.pan.demo.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("musicService")
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicMapper musicMapper;

    @Override
    public List<Singer> getPopularSinger(int n) {
        return musicMapper.selectPopularSinger(n);
    }
}
