package com.ddup.springstudy.domain;

/**
 * <p> </p>
 *
 * @author chenglu
 * @date 2019/11/8
 */
public class EventDTO {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
