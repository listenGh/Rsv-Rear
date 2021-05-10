package com.gh.rsv.Dao;

import com.gh.rsv.bean.MainMenu;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMainMennu();

    public List<MainMenu> getMainMennuOfStudent();

    public List<MainMenu> getMainMennuOfTeacher();
}
