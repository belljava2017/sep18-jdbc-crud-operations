package com.bellinfo.advanced.jdbc;

import java.util.Objects;

public class Department {

    private int id;
    private String name;
    private String loc;

    public Department() {
    }

    public Department(int id, String name, String loc) {
        this.id = id;
        this.name = name;
        this.loc = loc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, loc);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
