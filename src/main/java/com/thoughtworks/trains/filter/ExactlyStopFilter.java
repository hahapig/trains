package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据准确的停靠站数过滤
 * Created by tao on 16-11-28.
 */
public class ExactlyStopFilter implements RouteFilter {

    private int stopNum;

    public ExactlyStopFilter(int stopNum){
        this.stopNum = stopNum;
    }

    public List<Route> filter(List<Route> routes) {
        List<Route> result = new ArrayList<Route>();
        for (Route route :routes){
            if (route.getRouteNode().size() == stopNum){
                result.add(route);
            }
        }
        return result;
    }
}
