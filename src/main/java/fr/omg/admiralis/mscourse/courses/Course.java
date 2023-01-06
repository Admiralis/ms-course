package fr.omg.admiralis.mscourse.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "courses")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Course {
    @Id
    private String id;

    private String label;

    private LocalDate startDate;

    private LocalDate endDate;
}
