package com.example.reservation_system.service;

import com.example.reservation_system.dao.EvaluateDAO;
import com.example.reservation_system.daomain.Evaluate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EvaluateService {
    @Resource
    private EvaluateDAO evaluateDAO;

    //写评价
    public void evaluate(Evaluate evaluate){
        evaluateDAO.add(evaluate);
    }

    //查询所有评价
    public List<Evaluate> listInfo(){
        return evaluateDAO.listAll();
    }
}
