package com.thoughtworks.trains.view;

import com.thoughtworks.trains.core.Route;

import java.util.List;

/**
 * 返回路线条数
 * Created by tao on 16-11-28.
 */
public class TripNumbersView  implements RouteView{


    public Object routeViewer(List<Route> route) {
        if (route==null || route.isEmpty()){
            return DEFAULT_NO_ROUTE;
        }

        return route.size();
    }
}
