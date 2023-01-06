package fr.omg.admiralis.mscourse.students;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.omg.admiralis.mscourse.students.dto.StudentFullDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    private final ObjectMapper objectMapper;

    public StudentController(StudentService studentService, ObjectMapper objectMapper) {
        this.studentService = studentService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<StudentFullDto> findAll() {
        List<Student> students = studentService.findAll();
        return students.stream().map(student -> objectMapper.convertValue(student, StudentFullDto.class)).toList();
    }

    @PostMapping
    public StudentFullDto save(@RequestBody Student newStudent) {
        Student student = studentService.save(newStudent);
        return objectMapper.convertValue(student, StudentFullDto.class);
    }

    @GetMapping("{id}")
    public StudentFullDto findById(@PathVariable String id) {
        Student student = studentService.findById(id);
        return objectMapper.convertValue(student, StudentFullDto.class);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        studentService.deleteById(id);
    }
}
