package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Route;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 过滤出最短的路径
 * Created by tao on 16-11-28.
 */
public class ShortestRoute implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        Route last = null;
        BigDecimal lastDistance = new BigDecimal(Integer.MAX_VALUE);
        for (Route route :routes){
            if (lastDistance.compareTo(route.sumDistance())>=0){
                last = route;
                lastDistance = route.sumDistance();
            }
        }
        return Arrays.asList(last);
    }
}
