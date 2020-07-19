package com.example.reservation_system.service;

import com.example.reservation_system.dao.WindowDAO;
import com.example.reservation_system.daomain.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class WindowService {

    @Autowired
    private WindowDAO windowDAO;

    public void addWindow(Window window){
        windowDAO.add(window);
    }

    public List<Window> getPageAll(Integer pageNum, Integer pageSize){
        return windowDAO.getAll(pageNum, pageSize);
    }

    public List<Window> getAll(){
        return windowDAO.listAll();
    }

    public void deleteById(Integer id){
        windowDAO.delete(id);
    }
    public Window getWindowById(Integer id){
        return windowDAO.getById(id);
    }
    public void updateWindow(Window window){
        windowDAO.update(window);
    }

    public void setServerId(Integer wid, Integer rid) {
        Window window = windowDAO.getById(wid);
        window.setCurrentSid(rid);
        windowDAO.update(window);
    }
}
