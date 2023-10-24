package mobina.tech.school.Subject

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import mobina.tech.school.Student.Student
import mobina.tech.school.Teacher.Teacher

@Entity
class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    var name: String? = null;

    @JvmName("getName1")
    fun getName(): String? {
        return name
    }

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "student_enrolled",
        joinColumns = [JoinColumn(name = "subject_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )

    var enrolledStudents : MutableSet<Student> = HashSet();
    @JvmName("getEnrolledStudents1")
    fun getEnrolledStudents(): MutableSet<Student>{
        return enrolledStudents;
    }
    @JsonIgnore
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")

    var teacher : Teacher? = null;
    @JvmName("getTeacher1")
    fun getTeacher(): Teacher?{
        return teacher
    }
    @JvmName("setTeacher1")
    fun setTeacher(teacher: Teacher?){
        this.teacher = teacher
    }

    fun assignTeacher(teacher: Teacher) {
        this.teacher = teacher
    }

    fun assignedStudent(student: Student) {
        enrolledStudents.add(student)
    }
}