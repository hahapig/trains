package com.thoughtworks.trains.view;

import com.thoughtworks.trains.core.Route;

import java.util.List;

/**
 * Created by tao on 16-11-27.
 */
public interface RouteView {

    String DEFAULT_NO_ROUTE = "NO SUCH ROUTE";

    /**
     * 根据不同的路径进行选择性的打印
     * @param routes
     * @return 视图对象
     */
    Object routeViewer(List<Route> routes);


}
