package com.book.manager.util.excel;

import com.alibaba.excel.EasyExcel;
import com.book.manager.entity.Student;
import com.book.manager.entity.Users;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UsersExcel {
    public static List<Users> getUsersFromExcel(File file){
        ReadExcelUtil readExcelUtil = new ReadExcelUtil();
        EasyExcel.read(file, Student.class,readExcelUtil)
                .sheet()
                .headRowNumber(1)
                .doRead();
        List<Student> list = readExcelUtil.list;
        List<Users> users = new ArrayList<>();
        for (Student student : list) {
            String id = student.getId();
            Users user = new Users();
            //身份默认为学生
            user.setNickname(student.getName());
            //用户名为学号
            user.setUsername(student.getStudentId());
            //后六位为密码
            user.setPassword(id.substring(id.length()-6,id.length()));
            //默认可接数量为10
            user.setSize(10);
            //手机号
            user.setTel(student.getTel());
            //学生身份
            user.setIdentity(0);
            //非管理员
            user.setIsAdmin(1);
            //地址
            user.setAddress("南宁");
            users.add(user);
        }
        return users;
    }
}
