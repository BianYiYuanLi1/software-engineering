package com.book.manager.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @ExcelProperty(index = 0,value = "姓名")
    private String name;

    @ExcelProperty(index = 1,value = "学号")
    private String studentId;

    @ExcelProperty(index = 2,value = "身份证号")
    private String id;

    @ExcelProperty(index = 3,value = "手机")
    private String tel;

}
