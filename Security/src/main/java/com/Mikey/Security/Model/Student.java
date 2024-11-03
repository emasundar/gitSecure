package com.Mikey.Security.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private long pass;


    public Student(int i, String mikey, int i1) {
    }
}
