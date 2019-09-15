package com.manager.tour.dao;

import com.manager.entry.tour.RegionShow;

public interface RegionShowMapper {
    int deleteByPrimaryKey(String sc0204Id);

    int insert(RegionShow record);

    int insertSelective(RegionShow record);

    RegionShow selectByPrimaryKey(String sc0204Id);

    int updateByPrimaryKeySelective(RegionShow record);

    int updateByPrimaryKey(RegionShow record);
}