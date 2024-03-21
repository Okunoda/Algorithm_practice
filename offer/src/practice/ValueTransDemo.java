package practice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Okunoda
 * @date 2023年03月14日16:06
 */
public class ValueTransDemo {
    class Student{
        int age;
    }

    public static void main(String[] args) {
//        Student student = new ValueTransDemo().new Student();
//        student.age = 2;
//        System.out.println(student.age);
//        method1(student);
//        System.out.println(student.age);

//        System.out.println(method2("hello"));


    }


    public static void method1(Student s){
        s.age = 10000;
    }

    //通过反射更改String的值，原本String的值是不可以更改的，因为其是final类型的char[]
    public static String method2(String s){
//        try {
//            Field value = String.class.getDeclaredField("value");
//            value.setAccessible(true);
//            char[] chars = (char[]) value.get(s);
//            chars[0] = '_';
//            return s;
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
        Map map = new ConcurrentHashMap();


        return null;
    }


}
