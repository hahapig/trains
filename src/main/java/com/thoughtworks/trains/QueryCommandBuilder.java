package com.thoughtworks.trains;

import com.thoughtworks.trains.core.RouteFactory;
import com.thoughtworks.trains.core.Town;
import com.thoughtworks.trains.filter.RouteFilter;
import com.thoughtworks.trains.view.RouteView;

/**
 * Created by tao on 16-11-28.
 */
public class QueryCommandBuilder {

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


    public QueryCommandBuilder withFilter(RouteFilter routeFilter){
        this.routeFilter = routeFilter;
        return this;
    }

    public QueryCommandBuilder withView(RouteView routeView){
        this.routeView = routeView;
        return this;
    }

    public QueryCommandBuilder withFactory(RouteFactory routeFactory){
        this.routeFactory = routeFactory;
        return this;
    }

    public QueryCommandBuilder withStart(Town town){
        this.start = town;
        return this;
    }

    public QueryCommandBuilder withDestination(Town town){
        this.end = town;
        return this;
    }

    public QueryCommand build(){
        if (routeFilter == null){
            throw new IllegalStateException("routeFilter may not be null");
        }
        if (routeView == null){
            throw new IllegalStateException("routeView may not be null");
        }
        if (routeFactory == null){
            throw new IllegalStateException("routeFactory may not be null");
        }
        if (start == null){
            throw new IllegalStateException("start may not be null");
        }
        if (end == null){
            throw new IllegalStateException("end may not be null");
        }

        return new QueryCommand(this.routeFilter,this.routeView,this.routeFactory,this.start,this.end);
    }
}
