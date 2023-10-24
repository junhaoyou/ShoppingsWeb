package com.ys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopyCourse {
    private String course_id;
    private String course_name;
    private String teacher;
    private Integer point;
    private String time_1;
    private String time_2;
    private String location;
    private Integer limited;
}
