package springdemo.bean;

import com.example.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Department department = (Department) context.getBean("departmentBean");

        System.out.println("Department Bean Loaded:");
        System.out.println(department);
    }
}
