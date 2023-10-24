package mobina.tech.school.Student

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import mobina.tech.school.Subject.Subject

@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null;

    var name :String? = null;

    @JvmName("getName1")
    fun getName(): String? {
        return name
    }
    @JvmName("setName1")
    fun setName(name: String?) {
        this.name = name
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents", fetch = FetchType.EAGER)
    val subjects: MutableSet<Subject> = HashSet()

    @JvmName("getSubjects1")
    fun getSubjects(): MutableSet<Subject> {
        return subjects
    }
}