package fr.omg.admiralis.mscourse.courses;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return courseRepository.save(course);
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
}
