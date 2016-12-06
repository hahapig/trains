package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Route;

import java.util.List;

/**
 * Created by tao on 16-11-28.
 */
public class DefaultFilter implements RouteFilter {

    public List<Route> filter(List<Route> routes) {
        return routes;
    }
}
