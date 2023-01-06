package fr.omg.admiralis.mscourse.students;

import fr.omg.admiralis.mscourse.courses.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "students")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    @DBRef
    private Course course;
}
