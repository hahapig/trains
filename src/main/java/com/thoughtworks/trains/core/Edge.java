package com.thoughtworks.trains.core;

import java.math.BigDecimal;

/**
 * Created by tao on 16-11-27.
 */
public class Edge {

    private Town parent;

    /**
     * 距离
     */
    private BigDecimal distance;

    /**
     * 小镇
     */
    private Town target;

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Town getTarget() {
        return target;
    }

    public void setTarget(Town target) {
        this.target = target;
    }

    public Town getParent() {
        return parent;
    }

    public void setParent(Town parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        return (target.getIdentify() + parent.getIdentify()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!Edge.class.isInstance(obj)){
            return false;

        }
        return this.target.equals(Edge.class.cast(obj).getTarget())
                && this.parent.equals(Edge.class.cast(obj).getParent());
    }

    @Override
    public String toString() {
        return parent.getIdentify()+target.getIdentify()+distance;
    }
}
