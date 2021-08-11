package com.pan.demo.mapper;

import com.pan.demo.pojo.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MusicMapper {
    @Select("select singer as name ,count(1) as songCount,avg(ratingValue) as avgRating from music_info GROUP BY singer ORDER BY count(1) desc limit #{n}")
    List<Singer> selectPopularSinger(int n);
}
