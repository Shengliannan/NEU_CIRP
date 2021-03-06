package com.sun.service.impl;

import com.github.pagehelper.PageHelper;
import com.sun.dao.InformationMapper;
import com.sun.model.Information;
import com.sun.model.InformationExample;
import com.sun.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper mapper;

    @Override
    public int postInformation(Information information) {
        return mapper.insertSelective(information);
    }

    @Override
    public Information getInformationById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Information getInformationByIdWithUserAndTypeInfo(Integer id) {
        return mapper.selectByPrimaryKeyWithUserAndTypeInfo(id);
    }

    @Override
    public List<Information> getInformationsByCondition(InformationExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<Information> getInformationsByConditionWithTypeid(Integer typeid) {
        return mapper.selectByTypeid(typeid);
    }

    @Override
    public List<Information> getInformationsByConditionWithUserAndTypeInfo(InformationExample example) {
        return mapper.selectByExampleWithUserAndTypeInfo(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByTime() {
        InformationExample example=new InformationExample();
        return mapper.selectByExampleOrderByTime(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByViewAndTime() {
        InformationExample example=new InformationExample();
        return mapper.selectByExampleOrderByViewAndTime(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByViewAndTimeByPage(int pageNum,int pageSize) {
        InformationExample example=new InformationExample();
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectByExampleOrderByViewAndTime(example);
    }

    @Override
    public List<Information> getInformationsByConditionOrderByFavAndTime() {
        InformationExample example=new InformationExample();
        return mapper.selectByExampleOrderByFav(example);
    }

    @Override
    public List<Information> getInformationsByUseridOrderByView(String userid) {
        return mapper.selectByUseridOrderByView(userid);
    }

    @Override
    public List<Information> getInformationsByUseridOrderByFav(String userid) {
        return mapper.selectByUseridOrderByFav(userid);
    }

    @Override
    public List<Information> getInformationsByUseridOrderByPost(String userid) {
        return mapper.selectByUseridOrderByPost(userid);
    }

    @Override
    public int putInformation(Information information) {
        return mapper.updateByPrimaryKeySelective(information);
    }

    @Override
    public int deleteInformation(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
