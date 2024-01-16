package ru.gb;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component //myStudentRepositoryBean"
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Fanur", "Law"));
        students.add(new Student("Anastasia", "Law"));
        students.add(new Student("Sergei", "Engineering"));
        students.add(new Student("Sergei", "Law"));
        students.add(new Student("Galina", "Medicine"));
    }

    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public Student getByGroup(String groupName) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .findFirst()
                .orElse(null);
    }

    public void deleteStudent(long id) {
        students.removeIf(it -> it.getId().equals(id));
    }

}
