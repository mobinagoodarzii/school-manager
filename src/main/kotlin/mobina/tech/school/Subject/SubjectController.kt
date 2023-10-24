package mobina.tech.school.Subject

import mobina.tech.school.Student.Student
import mobina.tech.school.Student.StudentRepository
import mobina.tech.school.Teacher.Teacher
import mobina.tech.school.Teacher.TeacherRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/subjects")
class SubjectController {

    @Autowired
    lateinit var subjectRepository : SubjectRepository;

    @Autowired
    lateinit var studentRepository : StudentRepository;

    @Autowired
    lateinit var teacherRepository : TeacherRepository;

    @GetMapping
    fun getSubjects():MutableList<Subject> {
        return subjectRepository.findAll()
    }

    @PostMapping
    fun createSubject(@RequestBody subject: List<Subject>): MutableList<Subject> {
        return subjectRepository.saveAll(subject)
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    fun addStudentToSubject(
        @PathVariable subjectId:Long,
        @PathVariable studentId:Long
    ): Subject {
        val subject : Subject = subjectRepository.findById(subjectId).get();
        val student : Student = studentRepository.findById(studentId).get();
        subject.assignedStudent(student);
        return subjectRepository.save(subject);
    }
    @PutMapping("/{subjectId}/teacher/{teacherId}")
    fun assignTeacherToSubject(
        @PathVariable subjectId: Long,
        @PathVariable teacherId: Long
    ): Subject {
        val subject : Subject = subjectRepository.findById(subjectId).get();
        val teacher : Teacher = teacherRepository.findById(teacherId).get();
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }
}