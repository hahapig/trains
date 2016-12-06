package com.thoughtworks.trains.filter;

import com.thoughtworks.trains.core.Edge;
import com.thoughtworks.trains.core.Route;
import com.thoughtworks.trains.core.Town;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 仅仅返回指定的路线
 * Created by tao on 16-11-28.
 */
public class SpecialRouteFilter implements RouteFilter{
    List<Town> townsSeq;

    public SpecialRouteFilter(List<Town> townsSeq){
        this.townsSeq = townsSeq;

    }

    public List<Route> filter(List<Route> routes) {
        for (Route route :routes){
            if (route.getRouteNode().size() != townsSeq.size() -1){
                continue;
            }
            int index = 1;
            for (Edge edge :route.getRouteNode()){
                if (!edge.getTarget().equals(townsSeq.get(index))){
                    break;
                }
                index++;
            }
            if (index == townsSeq.size()){
                return Arrays.asList(route);
            }
        }
        return Collections.EMPTY_LIST;
    }
}
