package fr.omg.admiralis.mscourse.courses;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.omg.admiralis.mscourse.courses.dto.CourseFullDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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


    /**
     * Retourne toutes les formations
     * @return
     */
    @GetMapping
    public List<CourseFullDto> findAll() {
        List<Course> courses = courseService.findAll();
        return courses.stream().map(course -> objectMapper.convertValue(course, CourseFullDto.class)).toList();
    }

    /**
     * Ajoute une nouvelle formation
     * @param newCourse à ajouter
     * @return la formation ajoutée
     */
    @PostMapping
    public CourseFullDto save(@RequestBody Course newCourse) {
        Course course =  courseService.save(newCourse);
        return objectMapper.convertValue(course, CourseFullDto.class);
    }

    /**
     * Retourne une formation par son id
     * @param id de la formation
     * @return la formation demandée
     */
    @GetMapping("/{id}")
    public CourseFullDto findById(@PathVariable String id) {
        Course course = courseService.findById(id);
        return objectMapper.convertValue(course, CourseFullDto.class);
    }

    /**
     * Supprime une formation par son id
     * @param id de la formation
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        courseService.deleteById(id);
    }

    @GetMapping("/search")
    public CourseFullDto findByLabelAndStartDate(@RequestParam String label, @RequestParam LocalDate startDate) {
        Course course = courseService.findByLabelAndStartDate(label, startDate);
        return objectMapper.convertValue(course, CourseFullDto.class);
    }

//    @GetMapping("/in-progress")
//    public List<CourseFullDto> findInProgress() {
//        List<Course> courses = courseService.findByEndDateAfterOrEndDateIsNull(LocalDate.now());
//        return courses.stream().map(course -> objectMapper.convertValue(course, CourseFullDto.class)).toList();
//    }

    @GetMapping("/in-progress")
    public List<CourseFullDto> findInProgressByLabel(@RequestParam(required = false) String label) {
        if (label == null) {
            List<Course> courses = courseService.findByEndDateAfterOrEndDateIsNull(LocalDate.now());
            return courses.stream().map(course -> objectMapper.convertValue(course, CourseFullDto.class)).toList();
        }
        List<Course> courses = courseService.findByEndDateAfterOrEndDateIsNullAndLabelContainingIgnoreCase(LocalDate.now(), label);
        return courses.stream().map(course -> objectMapper.convertValue(course, CourseFullDto.class)).toList();
    }
}
