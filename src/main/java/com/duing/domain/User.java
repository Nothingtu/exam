package com.duing.domain;

import lombok.Data;

@Data
public class User {
    //id用来表示学号
    private Integer id;
    private String name;
    private String password;


    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof User){
            User another = (User)obj;
            if(this.id == another.id && this.name.equals(another.name) && this.password.equals(another.password)){
                return true;
            }
        }
        return false;
    }

}
