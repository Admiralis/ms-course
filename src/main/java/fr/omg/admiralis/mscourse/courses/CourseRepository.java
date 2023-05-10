package fr.omg.admiralis.mscourse.courses;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findByLabelAndStartDate(String label, LocalDate startDate);
    Optional<List<Course>> findByEndDateAfterOrEndDateIsNull(LocalDate endDate);

    Optional<List<Course>> findByLabelContainingIgnoreCase(String label);

}
