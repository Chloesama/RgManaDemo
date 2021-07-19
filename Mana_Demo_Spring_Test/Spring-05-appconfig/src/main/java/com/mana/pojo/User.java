package com.mana.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    public String name;

    public String getName() {
        return name;
    }

    @Value("Chloe")
    public void setName(String name) {
        this.name = name;
    }
}
