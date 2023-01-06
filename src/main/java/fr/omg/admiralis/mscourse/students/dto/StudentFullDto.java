package fr.omg.admiralis.mscourse.students.dto;

import fr.omg.admiralis.mscourse.courses.Course;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
public class StudentFullDto {
    private String id;
    private String firstName;
    private String lastName;
    @DBRef
    private Course course;
}
