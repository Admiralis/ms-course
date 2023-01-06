package fr.omg.admiralis.mscourse.courses;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.omg.admiralis.mscourse.courses.dto.CourseCompletDto;
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
    public List<CourseCompletDto> findAll() {
        List<Course> courses = courseService.findAll();
        return courses.stream().map(course -> objectMapper.convertValue(course, CourseCompletDto.class)).toList();
    }

    @PostMapping
    public CourseCompletDto save(@RequestBody Course newCourse) {
        Course course =  courseService.save(newCourse);
        return objectMapper.convertValue(course, CourseCompletDto.class);
    }

    @GetMapping("/{id}")
    public CourseCompletDto findById(@PathVariable String id) {
        Course course = courseService.findById(id);
        return objectMapper.convertValue(course, CourseCompletDto.class);
    }

    public void deleteById(String id) {
        courseService.deleteById(id);
    }
}
