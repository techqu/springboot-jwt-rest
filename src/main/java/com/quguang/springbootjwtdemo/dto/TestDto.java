package com.quguang.springbootjwtdemo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {
    private String name;
    private Integer age;

}
