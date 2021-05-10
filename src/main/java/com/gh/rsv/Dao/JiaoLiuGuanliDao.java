package com.gh.rsv.Dao;

import com.gh.rsv.bean.infoCommunication;
import com.gh.rsv.bean.notiInfo;
import com.gh.rsv.bean.reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiaoLiuGuanliDao {

    public List<infoCommunication> getAllInfoCommunication();

    public List<reply> getSomeoneReply(int mid);

    public int addInfoCommunication(String title, String dates, String sendUsername);

    public int addReply(String content, String dates, String replyUsername, int mid);
}
