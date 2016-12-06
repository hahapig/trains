package com.thoughtworks.trains;

import com.thoughtworks.trains.core.Edge;
import com.thoughtworks.trains.core.RouteFactory;
import com.thoughtworks.trains.core.Town;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * 文件读取器
 * Created by tao on 16-11-28.
 */
public class Reader {

    private RouteFactory routeFactory = new RouteFactory();


    /**
     * 从文件中读取图信息
     * @param file
     * @throws IOException
     */
    public RouteFactory init(String file) throws IOException{
        InputStream stream = Reader.class.getResourceAsStream(file);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = bufferedReader.readLine();
        while ((str !=null) && (str.trim().length()!=0)){
            resolveLine(str);
            str = bufferedReader.readLine();
        }
        return routeFactory;
    }

    /**
     * 解析行
     */
    public void resolveLine(String line){
        String[] edges = line.split(",");
        for (String edge :edges){
            if (isBlank(edge)){
                continue;
            }
            edge = edge.trim();
            if (edge.length() != 3){
                System.out.println("illegal graph format:"+edge);
                continue;
            }
            Town start = new Town();
            start.setIdentify(String.valueOf(edge.charAt(0)));
            Town end = new Town();
            end.setIdentify(String.valueOf(edge.charAt(1)));
            BigDecimal distance = new BigDecimal(edge.substring(2));
            Edge nextTown = new Edge();
            nextTown.setTarget(end);
            nextTown.setDistance(distance);
            nextTown.setParent(start);
            routeFactory.addSiteItem(start,nextTown);
        }

    }

    private static boolean isBlank(String edge){
        return edge==null?true:edge.trim().length()==0;
    }


    public static void main(String[] args) throws IOException{
                Reader reader = new Reader();
        reader.init("/graph");

    }

}
