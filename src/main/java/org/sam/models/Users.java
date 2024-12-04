package org.sam.models;

public class Users {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private String job;

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", job=" + job +
                '}';
    }
}
