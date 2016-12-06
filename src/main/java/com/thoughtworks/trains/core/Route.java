package com.thoughtworks.trains.core;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tao on 16-11-27.
 */
public class Route {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private static final int MAX_CYCLE_REF = 3;


    private int id = 0;

    public Route(){
        id = counter.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    /**
     * 开始城镇
     */
    private Town startNode;

    /**
     * 结束城镇
     */
    private Edge finalNode;

    /**
     * 途经站点
     */
    private List<Edge> routeNode = new LinkedList<Edge>();

    private Map<Edge,Integer> routeSet = new HashMap<Edge, Integer>();
    /**
     * 路径是否有效
     */
    private boolean valid = true;

    public Map<Edge,Integer> getRouteSet() {
        return routeSet;
    }

    public void setRouteSet(Map<Edge,Integer> routeSet) {
        this.routeSet = routeSet;
    }

    /**
     * 增加途经的站点
     * @param edge
     */
    public void addRouteNode(Edge edge){
        routeNode.add(edge);
        if (routeSet.containsKey(edge)){
            routeSet.put(edge,routeSet.get(edge).intValue()+1);
        }else {
            routeSet.put(edge,1);
        }
    }

    public boolean constainsEdge(Edge edge){
        return !routeSet.containsKey(edge)?false:routeSet.get(edge)>MAX_CYCLE_REF;
    }
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<Edge> getRouteNode() {
        return routeNode;
    }

    /**
     * 计算总的距离
     * @return 距离数
     */
    public BigDecimal sumDistance(){
        BigDecimal sum = new BigDecimal("0");
        for (Edge edge :routeNode){
            sum = sum.add(edge.getDistance());
        }
        return sum;
    }

    /**
     * 计算途经站点数
     * @return
     */
    public int sumStopping(){
        return routeNode.size();
    }


    public Town getStartNode() {
        return startNode;
    }

    public void setStartNode(Town startNode) {
        this.startNode = startNode;
    }

    public Edge getFinalNode() {
        return finalNode;
    }

    public void setFinalNode(Edge finalNode) {
        this.finalNode = finalNode;
    }


}
