package com.pan.demo.mapper;

import com.pan.demo.model.Movie;
import com.pan.demo.pojo.ScatterChart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("select movieCode from all_movie limit #{p1},100")
    List<String> select100MovieCode(int strat);

    @Insert("insert into movie_info(movieCode,movieName,datePublished,ratingCount,ratingValue,type,location,language,length)" +
            "values(#{movieCode},#{movieName},#{datePublished},#{ratingCount},#{ratingValue},#{type},#{location},#{language},#{length})")
    int insertMovie(Movie movie);

    @Update("update movie_info set movieName=#{movieName}, type=#{type}, location=#{location}, language=#{language}" +
            ", length=#{length}  where movieCode=#{movieCode}")
    int updateMovieInfo(Movie movie);

    @Select("select count(id) from movie_info where ratingValue >= #{i1} and  ratingValue < #{i2}")
    Integer getRatingCount(int i1, int i2);

    @Select(" select movieName from movie_info order by ratingCount desc limit 50;")
    List<String> selectMovieNameList();

    @Select(" select ratingValue from movie_info order by ratingCount desc limit 50;")
    List<Double> selectRatingList();

    @Select(" select ratingCount from movie_info order by ratingCount desc limit 50;")
    List<Integer> selectRatingCountList();

    ScatterChart selectRatingWithCount();

    @Select("select location from movie_info group by location;")
    List<String> selectLocationGroup();

    @Select("select count(id) from movie_info where location like '%${s}%' ;")
    int getLocationCount(String s);

    @Select("SELECT count(*) FROM movie_info where datePublished like '${year}-${s}%'")
    int getSingleMonth(String year, String s);
}
