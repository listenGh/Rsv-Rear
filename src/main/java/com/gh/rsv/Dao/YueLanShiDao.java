package com.gh.rsv.Dao;

import com.gh.rsv.bean.ReadRoomClass;
import com.gh.rsv.bean.readRoomInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YueLanShiDao {
    //获取全部ReadRoomClass信息
    public List<ReadRoomClass> getAllReadClass();
    //新增readRoomClass
    public int addReadRoomClass(String type,int limit);
    //获取全部ReadRoomInfo信息
    public List<readRoomInfo> getAllreadRoomInfo();
    //新增ReadRoomInfo
    public int addReadRoomInfo(@Param("rRI")readRoomInfo rRI);
    //新增positionInfo
    public void addpositionInfo(int num, String mid);
}
