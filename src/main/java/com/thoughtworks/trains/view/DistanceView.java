package com.thoughtworks.trains.view;

import com.thoughtworks.trains.core.Edge;
import com.thoughtworks.trains.core.Route;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by tao on 16-11-28.
 */
public class DistanceView implements RouteView {

    public Object routeViewer(List<Route> route) {
        if (route==null || route.isEmpty()){
            return DEFAULT_NO_ROUTE;
        }
        BigDecimal sum = new BigDecimal("0");
        for(Route r :route){
            for (Edge edge :r.getRouteNode()){
                sum = edge.getDistance().add(sum);
            }
        }
        return sum;
    }
}
