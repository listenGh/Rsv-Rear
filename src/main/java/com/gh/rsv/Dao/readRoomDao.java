package com.gh.rsv.Dao;

import com.gh.rsv.bean.User;
import com.gh.rsv.bean.hasReserv;
import com.gh.rsv.bean.positionInfo;
import com.gh.rsv.bean.readRoomInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface readRoomDao {
    //获取目前所有的阅览室
    public List<readRoomInfo> getAllReadRoomInfo();
    //获取特定阅览室的可用桌子号
    public List<hasReserv> getListOfZH(@Param("room") String room, @Param("startTime") String startTime, @Param("endTime") String endTime);
    //获取特定阅读室的信用积分标准
    public String getTypeOfReadRoom(@Param("room") String room);
    //获取特定阅读室的信用积分标准
    public int getStandardOfReadRoom(@Param("type") String type);
    //获取特定学生的信用积分
    public int getCreditOfStudent(@Param("username") String username);
    //产生已占信息
    public int insertHasReserv(@Param("hR")hasReserv hR);
    //更新positonInfo
    public int updatePositionInfo(@Param("state")int state,@Param("num")int num, @Param("startTime") String startTime,
                                  @Param("endTime") String endTime,
                                  @Param("name") String name);

    //确定特定阅览室的总桌子数（n）
    public readRoomInfo getNOfReadRoom(@Param("name") String name);

    //获取全部已占记录
    public List<hasReserv> getListOfAllHasReserv();

    //获取特定时间和阅览室的已占座位信息
    public  List<hasReserv> getListOfSTHasReserv(String room, String startTime, String endTime);
    //插入扣分表信息
    public int insertDeduction(String jBusername, String bjBusername, String content, String dates);
    //查询个人占位记录
    public List<hasReserv> getListOfGRHasReserv(String username);
    //取消占位记录
    public int deleteHasReserv(int id);
}
