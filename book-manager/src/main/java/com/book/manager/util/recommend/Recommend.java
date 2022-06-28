package com.book.manager.util.recommend;


import com.book.manager.entity.Book;
import com.book.manager.entity.UserBookRelation;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author junfeng.lin
 * @date 2021/3/18 13:42
 */
@Component
public class Recommend {

    //每个用户的每本图书的评分
    Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
    /**
     * 在给定user的情况下，计算其他用户和它的距离并排序
     * @return
     */
    private Map<Double, Integer> computeNearestNeighbor(Integer u1, List<UserBookRelation> userBookRelations) {
        Map<Double, Integer> distances = new TreeMap<>();

        for (UserBookRelation userBookRelation:userBookRelations) {
            Integer userId = userBookRelation.getUserId();
            if(map.containsKey(userId)){
                Map<Integer, Integer> map1 = map.get(userId);
                map1.put(userBookRelation.getBookId(),userBookRelation.getScore());
            }
            else {
                Map<Integer,Integer> map1 = new HashMap<>();
                map1.put(userBookRelation.getBookId(),userBookRelation.getScore());
                map.put(userId,map1);
            }
        }

        for (int i = 0; i < userBookRelations.size(); i++) {
            Integer u2 = userBookRelations.get(i).getUserId();

            if (!u2.equals(u1)) {
                double distance = pearson_dis(map.get(u2), map.get(u1));
                distances.put(distance, u2);
            }

        }
        System.out.println("该用户与其他用户的皮尔森相关系数 -> " + distances);
        return distances;
    }


    /**
     * 计算2个打分序列间的pearson距离
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(Map<Integer,Integer> rating1, Map<Integer,Integer> rating2) {
        int n=rating1.size();
        Collection<Integer> rating1ScoreCollect = rating1.values();
        Collection<Integer> rating2ScoreCollect = rating2.values();

        double Ex= rating1ScoreCollect.stream().mapToDouble(x->x).sum();
        double Ey= rating2ScoreCollect.stream().mapToDouble(y->y).sum();
        double Ex2=rating1ScoreCollect.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=rating2ScoreCollect.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= rating1.keySet().stream().mapToDouble(i->rating1.get(i)*rating2.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }


    public List<Integer> recommend(Integer userId, List<UserBookRelation> userBookRelations) {
        //找到最近邻
        Map<Double, Integer> distances = computeNearestNeighbor(userId, userBookRelations);
        Integer nearest = distances.values().iterator().next();
        System.out.println("最近邻 -> " + nearest);

        //找到最近邻看过，但是我们没看过的电影，计算推荐
        Map<Integer, Integer> map1 = map.get(nearest);
        Set<Integer> set1 = map1.keySet();
        System.out.println("最近邻的书 -> " + map1);
        Set<Integer> set = map.get(userId).keySet();
        System.out.println("用户的书 -> " + map);
        //在最近邻用户看的书里面选五本评分最高的书
        Queue<UserBookRelation> priorityQueue= new PriorityQueue<>(((o1, o2) -> o1.getScore()-o2.getScore()));
        for (UserBookRelation relation : userBookRelations) {
            if(relation.getUserId()==nearest){
                priorityQueue.add(relation);
                if(priorityQueue.size()>5){
                    priorityQueue.remove();
                }
            }
        }
        int size = priorityQueue.size();
        Integer[] arr = new Integer[size];
        while (priorityQueue.size()>0){
            arr[--size]=priorityQueue.remove().getBookId();
        }
        List<Integer> bookIds=Arrays.asList(arr);
        System.out.println("推荐的书 -> " + bookIds);


        //根据自己和邻居的电影计算推荐的电影
        return bookIds;
    }
}
