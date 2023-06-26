package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<student> list = new ArrayList<student>();
        int course;
        course = 2;
        stud(list, course);

        course = 3;
        stud(list, course);

        course = 4;
        stud(list, course);

        list.add(new student(3, "Тащук"));
        list.add(new student(3, "Савескул"));
        list.add(new student(2, "Баланюк"));
        list.add(new student(2, "Шлемкевичк"));
        list.add(new student(4, "Гостюк"));
    }

    public static void stud(List<student> students, int course) {
        System.out.println("Студенти " + course + " курсу:");

        Iterator<student> iter = students.iterator();
        while (iter.hasNext()) {
            student student = iter.next();
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

}
class student {

    private int course;
    private String name;

    public student(int course, String name) {
        this.course = course;
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}