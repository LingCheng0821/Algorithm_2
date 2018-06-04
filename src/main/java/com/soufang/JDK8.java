package com.soufang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
/**
 * Created by Laura on 2018/4/11.
 */
public class JDK8 {
    public static class Student {
        String id;
        String name;
        ArrayList<Course> courses;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Course> getCourses() {
//            if(courses == null)
//                return new ArrayList<Course>();
            return courses;
        }

        public void setCourses(ArrayList<Course> courses) {
            this.courses = courses;
        }
    }

    public static class Course {
        String id;
        String name;

        public Course() {
        }

        public Course(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    public static class CourseStundentPair {
        private Course course;
        private Student student;

        public CourseStundentPair(Course course, Student student) {
            this.course = course;
            this.student = student;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("1", "Student1");
        Student student2 = new Student("2", "Student2");
        Student student3 = new Student("3", "Student3");
        Student student4 = new Student("4", "Student4");
        Course course1 = new Course("c1", "English");
        Course course2 = new Course("c2", "Mathematics");
        Course course3 = new Course("c3", "Literature");
        ArrayList<Course> list1 = new ArrayList<Course>();
        list1.add(course1);
        list1.add(course2);
        list1.add(course3);
        student1.setCourses(list1);

        list1 = new ArrayList<Course>();
        list1.add(course1);
        list1.add(course2);
        student2.setCourses(list1);
        list1 = new ArrayList<Course>();
        list1.add(course1);
        student3.setCourses(list1);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        final Map<Course, List<Student>> courseToStudents = students.stream()
                .flatMap(s -> s.getCourses().stream().map(c -> new CourseStundentPair(c,s)))
                .collect(groupingBy(CourseStundentPair::getCourse,
                        mapping(CourseStundentPair::getStudent, toList())
                        )
                );

        for (Course course :courseToStudents.keySet()){
            System.out.printf("Course %s , Students: %s \n"
                    ,course.getName()
                    ,courseToStudents.get(course).stream().map(Student::getName)
                            .collect(joining(", ")));
        }

    }


}


