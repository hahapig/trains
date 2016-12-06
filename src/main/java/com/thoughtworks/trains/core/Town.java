package com.thoughtworks.trains.core;

/**
 * Created by tao on 16-11-27.
 */
public class Town {

    public Town(String identify) {
        this.identify = identify;
    }


    public Town() {
    }



    /**
     * 小镇的标示
     */
    private String identify;

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Override
    public int hashCode() {
        return identify.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!Town.class.isInstance(obj)){
            return false;
        }
        return this.identify.equals(Town.class.cast(obj).getIdentify());
    }
}
