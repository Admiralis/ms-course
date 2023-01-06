package fr.omg.admiralis.mscourse.courses.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseFullDto {
    private String id;
    private String label;
    private LocalDate startDate;
    private LocalDate endDate;
}
