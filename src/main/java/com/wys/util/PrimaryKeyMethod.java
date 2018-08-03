package com.wys.util;

import com.wys.core.Column;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyMethod implements TemplateMethodModel {

    @Override
    public TemplateModel exec(List columns) throws TemplateModelException {
        // 检查参数是否传入
        if (!columns.isEmpty()) {
            throw new TemplateModelException("This Method doesn't allow parameters.");
        }
        if(columns.get(0).getClass()!=Column.class){
            throw new TemplateModelException("Wrong Type of parameters.");
        }
        SimpleSequence res= new SimpleSequence();
        for(Object column:columns){
            Column c=(Column) column;  //强转为子类型，以调用具体方法
            if(c.getIndex().contains("PRI")){
                res.add(c.getName());
            }
        }
        return res;


        }
    }