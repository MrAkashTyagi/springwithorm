
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student){
        int i = (Integer) this.hibernateTemplate.save(student);
        return 1;
    }

    //get a single student
    public Student getStudentById(int id){
        Student student = this.hibernateTemplate.get(Student.class,id);
        return student;
    }
    //get all student
    public List<Student> getAllStudent(){
        List<Student> studentList = this.hibernateTemplate.loadAll(Student.class);
        return studentList;
    }
    //delete student
    @Transactional
    public void deleteStudent(int id){
        Student student = this.hibernateTemplate.get(Student.class,id);
        this.hibernateTemplate.delete(student);
    }
    //update student
    @Transactional

            public void updateStudent(Student student){
//    public void updateStudent(int id ,String name, String city){
//        Student student2 = this.hibernateTemplate.get(Student.class,id);
//        student2.setName(name);
//        student2.setCity(city);
        this.hibernateTemplate.saveOrUpdate(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
