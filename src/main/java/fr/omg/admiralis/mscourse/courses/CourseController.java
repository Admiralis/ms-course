package fr.omg.admiralis.mscourse.courses;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.omg.admiralis.mscourse.courses.dto.CourseFullDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {
    private final CourseService courseService;
    private final ObjectMapper objectMapper;

    public CourseController(CourseService courseService, ObjectMapper objectMapper) {
        this.courseService = courseService;
        this.objectMapper = objectMapper;
    }


    @GetMapping
    public List<CourseFullDto> findAll() {
        List<Course> courses = courseService.findAll();
        return courses.stream().map(course -> objectMapper.convertValue(course, CourseFullDto.class)).toList();
    }

    @PostMapping
    public CourseFullDto save(@RequestBody Course newCourse) {
        Course course =  courseService.save(newCourse);
        return objectMapper.convertValue(course, CourseFullDto.class);
    }

    @GetMapping("/{id}")
    public CourseFullDto findById(@PathVariable String id) {
        Course course = courseService.findById(id);
        return objectMapper.convertValue(course, CourseFullDto.class);
    }

    public void deleteById(String id) {
        courseService.deleteById(id);
    }
}
