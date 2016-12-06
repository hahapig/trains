package com.thoughtworks.trains.core;

import java.util.*;

/**
 * Created by tao on 16-11-27.
 */
public class RouteFactory {

    /**
     *所有的路径集合
     */
    private Map<Town,Set<Edge>> siteItem = new HashMap<Town, Set<Edge>>();

    /**
     *
     */
    private Set<Edge> destinationSets = new HashSet<Edge>();

    /**
     * 增加站点条目
     * @param start 开始城镇
     * @param end 结束城镇
     */
    public void addSiteItem(Town start,Edge end){
         if (siteItem.containsKey(start)){
             siteItem.get(start).add(end);
         }else {
             Set<Edge> nxtLs = new HashSet<Edge>();
             nxtLs.add(end);
             siteItem.put(start,nxtLs);
         }
        destinationSets.add(end);
    }

    /**
     * 获取所有可选路径
     * @param start 开始位置
     * @param end 结束位置
     * @return 所有的路径集合
     */
    public List<Route> getAllRoutes(Town start,Town end){
        if (!siteItem.containsKey(start)){
            return Collections.EMPTY_LIST;
        }
        List<Route> routeContainer = new ArrayList<Route>();

         Set<Edge> nextTownsSet = siteItem.get(start);
        for (Edge edge :nextTownsSet){
            Route route = new Route();
            route.setStartNode(start);
            route.addRouteNode(edge);
            route.setFinalNode(edge);
            routeContainer.add(route);
            deepSearchRoute(edge,route,routeContainer);
        }
        ListIterator<Route> it = routeContainer.listIterator();
        while (it.hasNext()){
            if (!it.next().getFinalNode().getTarget().equals(end)){
                it.remove();
            }
        }
        return routeContainer;
    }

    /**
     * 子路径查询
     * @param start 开始的位置
     * @param lastRoute 当前正在计算的路径
     * @param routeContainer 路径集合
     */
    private void deepSearchRoute(Edge start, Route lastRoute, List<Route> routeContainer){
        // 如果没有临近节点，说明也结束了
        Set<Edge> nextTownsSet = siteItem.get(start.getTarget());
        if (nextTownsSet == null){
            lastRoute.setFinalNode(start);
            return;
        }
        // 如果邻近节点有多个，需要fork出N-1个新的路径出来
        for (Edge edge :nextTownsSet){
            // 遇到了重复路径，直接跳过，不走重复的路
            if (lastRoute.constainsEdge(edge)){
                continue;
            }
            Route route = forkNew(lastRoute);
            route.setFinalNode(edge);
            routeContainer.add(route);
            route.addRouteNode(edge);
            deepSearchRoute(edge,route,routeContainer);
        }

    }

    /**
     * 复制出一个新的路径
     * @param original 原始路径
     * @return 新路径
     */
    private Route forkNew(Route original){
        Route route = new Route();
        route.setStartNode(original.getStartNode());
        route.setFinalNode(original.getFinalNode());
        route.getRouteNode().addAll(original.getRouteNode());
        route.getRouteSet().putAll(original.getRouteSet());
        return route;
    }

}
