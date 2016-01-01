package main.java.manager.controllers;

import main.java.Property;
import main.java.PropertyManager;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import javax.inject.Inject;

@Model
public class Controller {

    List<Property> propertyList;

    private String key;
    private String value;

    @PostConstruct
    public void readDB() {
        propertyList = ejb.queryCache();

    }
    @Inject
    PropertyManager ejb;

    public void save() {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        ejb.save(p);
        propertyList.add(p);
        key = "";
        value = "";
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
