package com.thoughtworks.trains;

import com.thoughtworks.trains.core.Route;
import com.thoughtworks.trains.core.RouteFactory;
import com.thoughtworks.trains.core.Town;
import com.thoughtworks.trains.filter.RouteFilter;
import com.thoughtworks.trains.view.RouteView;

import java.util.List;

/**
 * Created by tao on 16-11-28.
 */
public class QueryCommand {
    /**
     * 需要执行过滤器u
     */
    private RouteFilter routeFilter;

    /**
     * 视图解析器
     */
    private RouteView routeView;

    private RouteFactory routeFactory;

    private Town start;

    private Town end;

    public QueryCommand(RouteFilter routeFilter, RouteView routeView, RouteFactory routeFactory, Town start, Town end) {
        this.routeFilter = routeFilter;
        this.routeView = routeView;
        this.routeFactory = routeFactory;
        this.start = start;
        this.end = end;
    }

    public void execute(){
        List<Route> allRoutes = routeFactory.getAllRoutes(start,end);
        allRoutes = this.routeFilter.filter(allRoutes);
        System.out.println(routeView.routeViewer(allRoutes));
    }

}
