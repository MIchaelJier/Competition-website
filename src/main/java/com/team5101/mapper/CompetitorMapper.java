package com.team5101.mapper;


import com.team5101.pojo.Competitor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CompetitorMapper {
    Competitor getCompetitorById(Integer c_id);
   Integer addCompetitor(Competitor competitor);
}
