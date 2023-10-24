package mobina.tech.school.Student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController {

    @Autowired
    lateinit var studentRepository: StudentRepository;

    @GetMapping
    fun getStudents(): MutableList<Student> {
        return studentRepository.findAll()
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student {
        return studentRepository.save(student)
    }
}