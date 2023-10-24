package mobina.tech.school.Teacher

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teachers")
class TeacherController {
    @Autowired
    lateinit var teacherRepository: TeacherRepository;

    @GetMapping
    fun getTeachers(): MutableList<Teacher> {
        return teacherRepository.findAll()
    }
    @PostMapping
    fun createTeacher(@RequestBody teacher: Teacher): Teacher {
        return teacherRepository.save(teacher)
    }
}