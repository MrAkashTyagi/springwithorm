
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String class_path_loc = "config.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(class_path_loc);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student = new Student(102,"Akash","MZN");
//        int r = studentDao.insert(student);
//        System.out.println("done : "+r);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean check = true;
        while (check){
            System.out.println("Enter 1 to enter a new student");
            System.out.println("Enter 2 to display all students");
            System.out.println("Enter 3 to display one student");
            System.out.println("Enter 4 to delete a student");
            System.out.println("Enter 5 to update a student");
            System.out.println("Enter 6 to exit");
            try{
                int input = Integer.parseInt(br.readLine());
                switch (input){
                    case 1:
                        //add new student
                        System.out.println("Enter user id : ");
                        int sid = Integer.parseInt(br.readLine());
                        System.out.println("Enter name of student");
                        String sname = br.readLine();
                        System.out.println("Enter user city : ");
                        String scity = br.readLine();

                        Student student = new Student();
                        student.setId(sid);
                        student.setName(sname);
                        student.setCity(scity);
                        int r = studentDao.insert(student);
                        System.out.println(r+" student inserted");
                        System.out.println("**********************************");
                        System.out.println();
                    break;
                    case 2:
                        //get all student

                        List<Student> studentList = studentDao.getAllStudent();
                        for (Student st:studentList){
                            System.out.println("Id is : "+st.getId());
                            System.out.println("Name is : "+st.getName());
                            System.out.println("City is : "+st.getCity());
                            System.out.println("______________________________________________");
                        }
                        System.out.println("**********************************");

                        break;
                    case 3:
                        //get one students
                        System.out.println("Please enter student id");
                        int id = Integer.parseInt(br.readLine());
                        Student student1 = studentDao.getStudentById(id);
                        System.out.println("ID : "+ student1.getId());
                        System.out.println("Name : "+student1.getName());
                        System.out.println("City : "+student1.getCity());
                        System.out.println("_______________________________________");
                        break;
                    case 4:
                        //delete student
                        System.out.println("Enter student id to delete a student :");
                        int stuid = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(stuid);
                        System.out.println("Student deleted...");
                        System.out.println("***************************************");
                        break;
                    case 5:
                        //update student
                        System.out.println("Please enter student id to update : ");
                        int studid = Integer.parseInt(br.readLine());
                        System.out.println("Enter new Name : ");
                        //String name = br.readLine();
                        System.out.println("Enter new city : ");
//                        String city = br.readLine();
//                        studentDao.updateStudent(studid,name,city);

                        Student student2 = studentDao.getStudentById(studid);
                        String updatedName = br.readLine();
                        student2.setName(updatedName);
                        String updatedCity = br.readLine();
                        student2.setCity(updatedCity);
                        studentDao.updateStudent(student2);
                        System.out.println("Student updated successfully....");
                        System.out.println("****************************************************");
                        break;
                    case 6:
                        //exit
                        check = false;
                        System.out.println("Thank you for using our application!!");
                        System.out.println("See you soon...");
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid input, please enter correct one");
                System.out.println(e.getMessage());


            }

        }
    }

}
