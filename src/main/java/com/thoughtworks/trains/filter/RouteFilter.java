package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Route;

import java.util.List;

/**
 * 根据特殊条件过滤
 * Created by tao on 16-11-27.
 */
public interface RouteFilter {

    /**
     * 路线过滤器
     * @param routes
     * @return
     */
    List<Route> filter(List<Route> routes);

}
