package com.api.book.BookMgmntAPI.model;

import java.util.ArrayList;
import java.util.List;

public class TimeResponse {

    private List<TimeObject> timeObjects;

    public TimeResponse() {
        this.timeObjects = new ArrayList<TimeObject>();
    }

    public List<TimeObject> getTimeObjects() {
        return timeObjects;
    }

    public void setTimeObjects(List<TimeObject> timeObjects) {
        this.timeObjects = timeObjects;
    }

    public void addTimeObject(TimeObject timeObject) {
        this.timeObjects.add(timeObject);
    }

}