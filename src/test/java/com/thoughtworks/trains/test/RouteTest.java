package com.thoughtworks.trains.test;

import com.thoughtworks.trains.QueryCommandBuilder;
import com.thoughtworks.trains.Reader;
import com.thoughtworks.trains.core.RouteFactory;
import com.thoughtworks.trains.core.Town;
import com.thoughtworks.trains.filter.*;
import com.thoughtworks.trains.view.DistanceView;
import com.thoughtworks.trains.view.TripNumbersView;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by tao on 16-11-28.
 */
public class RouteTest {

    static RouteFactory routeFactory;

    @BeforeClass
    public static void testBefore(){
        Reader reader = new Reader();
        try{
            routeFactory = reader.init("/graph");
        }catch (IOException exp){
            throw new RuntimeException("init failed ");
        }
    }

    @Test
    public void testCase1(){
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("B"),new Town("C"))))
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase2(){
        new QueryCommandBuilder().withDestination(new Town("D"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("D"))))
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase3(){
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("D"),new Town("C"))))
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase4(){
        new QueryCommandBuilder().withDestination(new Town("D"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("E"),new Town("B"),new Town("C"),new Town("D"))))
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase5(){
        new QueryCommandBuilder().withDestination(new Town("D"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new SpecialRouteFilter(Arrays.asList(new Town("A"),new Town("E"),new Town("D"))))
                .withView(new DistanceView()).build().execute();
    }


    @Test
    public void testCase6(){
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("C"))
                .withFactory(routeFactory)
                .withFilter(new MaxStopsFilter(3))
                .withView(new TripNumbersView()).build().execute();
    }

    @Test
    public void testCase7(){//
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new ExactlyStopFilter(4))
                .withView(new TripNumbersView()).build().execute();
    }

    @Test
    public void testCase8(){
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("A"))
                .withFactory(routeFactory)
                .withFilter(new ShortestRoute())
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase9(){//
        new QueryCommandBuilder().withDestination(new Town("B"))
                .withStart(new Town("B"))
                .withFactory(routeFactory)
                .withFilter(new ShortestRoute())
                .withView(new DistanceView()).build().execute();
    }

    @Test
    public void testCase10(){//
        new QueryCommandBuilder().withDestination(new Town("C"))
                .withStart(new Town("C"))
                .withFactory(routeFactory)
                .withFilter(new DistanceFilter())
                .withView(new TripNumbersView()).build().execute();
    }
}
