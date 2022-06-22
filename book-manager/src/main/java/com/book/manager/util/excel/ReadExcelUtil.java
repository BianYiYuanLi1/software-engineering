package com.book.manager.util.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.book.manager.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtil extends AnalysisEventListener<Student> {
    //    定义一个list,存放excel解读出来的数据
    public List<Student> list =new ArrayList<>();
    //    解析完一行，就会执行这个方法
    @Override
    public void invoke(Student data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}