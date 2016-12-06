package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Route;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao on 16-11-28.
 */
public class DistanceFilter implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        ArrayList<Route> re = new ArrayList<Route>();
        for (Route route :routes){
            if (route.sumDistance().compareTo(new BigDecimal("30")) <0){
                re.add(route);
            }
        }
        return re;
    }
}
