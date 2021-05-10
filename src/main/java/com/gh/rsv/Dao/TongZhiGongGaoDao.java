package com.gh.rsv.Dao;

import com.gh.rsv.bean.notiInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TongZhiGongGaoDao {

    public List<notiInfo> getAllNotiInfo();

    public notiInfo getSomeoneNotiInfo(int id);

    public int addNoticeInfo(String title, String dates, String content);
}
