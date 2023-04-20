package fr.omg.admiralis.mscourse.courses;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByLabelAndStartDate(String label, LocalDate startDate);
}
