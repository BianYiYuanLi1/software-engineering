package com.book.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBookRelation {
    @Id
    private Integer id;


    private Integer userId;

    private Integer bookId;

    private Integer score;

    public UserBookRelation(Integer userId,Integer bookId,Integer score){
        this.userId = userId;
        this.bookId = bookId;
        this.score = score;
    }
}
