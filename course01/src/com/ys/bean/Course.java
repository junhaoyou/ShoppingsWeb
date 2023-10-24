package com.ys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String course_id;
    private String course_name;
    private String teacher;
    private Integer point;
    private String time_1;
    private String time_2;
    private String location;
    private Integer limited;
    private Integer sum_person;


    @Override
    public String toString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", point=" + point +
                ", time_1='" + time_1 + '\'' +
                ", time_2='" + time_2 + '\'' +
                ", location='" + location + '\'' +
                ", limited=" + limited +
                ", sum_person=" + sum_person +
                '}';
    }
}
