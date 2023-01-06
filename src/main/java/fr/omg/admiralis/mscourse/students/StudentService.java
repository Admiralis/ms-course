package fr.omg.admiralis.mscourse.students;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Affiche tous les étudiants
     * @return la liste des étudiants
     */
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * Ajoute un nouvel étudiant ou le met à jour si il existe déjà
     * @param student à ajouter ou modifier
     * @return l'étudiant ajouté ou modifié
     */
    public Student save(Student student) {
        return studentRepository.save(student);
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
