package mobina.tech.school.Teacher

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import mobina.tech.school.Subject.Subject

@Entity
class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null;

    var name: String? = null;

    @JvmName("getName1")
    fun getName(): String? {
        return name
    }

    @JvmName("setName1")
    fun setName(name: String?) {
        this.name = name
    }

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    val subjects : MutableSet<Subject> = HashSet();
    @JvmName("getSubject1")
    fun getSubject():MutableSet<Subject> {
        return subjects;
    }
}