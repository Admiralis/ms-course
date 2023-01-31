package fr.omg.admiralis.mscourse.students;

import fr.omg.admiralis.mscourse.courses.Course;
import fr.omg.admiralis.mscourse.courses.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseService courseService;

    public StudentService(StudentRepository studentRepository, CourseService courseService) {
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    /**
     * Affiche tous les étudiants
     * @return la liste des étudiants
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Remplace l'id du cours par l'objet cours
     * @param courseId : Id du cours à chercher
     */
    private Course findCourse(String courseId) {
            return courseService.findById(courseId);
    }

    /**
     * Ajoute un nouvel étudiant ou le met à jour s'il existe déjà
     * @param student à ajouter ou modifier
     * @return l'étudiant ajouté ou modifié
     */
    public Student save(Student student) {
        student = studentRepository.save(student);
        if (student.getCourse() != null) {
            student.setCourse(findCourse(student.getCourse().getId()));
        }
        return student;
    }

    /**
     * Retourne un étudiant par son id
     * @param id de l'étudiant
     * @return l'étudiant demandé
     */
    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Supprime un étudiant par son id
     * @param id de l'étudiant
     */
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
