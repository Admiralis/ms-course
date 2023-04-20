package fr.omg.admiralis.mscourse.courses;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Récupère toutes les formations
     * @return la liste des formations
     */
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    /**
     * Enregistre une nouvelle formation
     * @param course à ajouter
     * @return la formation ajoutée
     */
    public Course save(Course course) {
        if (course.getStartDate() == null) {
            course.setStartDate(LocalDate.now());
        }

        Optional<Course> existingCourse = courseRepository.findByLabelAndStartDate(course.getLabel(), course.getStartDate());
        return existingCourse.orElseGet(() -> courseRepository.save(course));

    }

    /**
     * Récupère une formation par son identifiant
     * @param id de la formation
     * @return la formation
     */
    public Course findById(String id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Supprime une formation par son identifiant
     * @param id
     */
    public void deleteById(String id) {
        courseRepository.deleteById(id);
    }

    public Course findByLabelAndStartDate(String label, LocalDate startDate) {
        Course courses = courseRepository.findByLabelAndStartDate(label, startDate).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (courses == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return courses;
    }
}
