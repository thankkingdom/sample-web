package com.example.sampleweb.domain.entity;

import java.util.List;

import lombok.Data;

@Data
public class GreetingRequest {
    
    private List<Integer> greeting;
}
