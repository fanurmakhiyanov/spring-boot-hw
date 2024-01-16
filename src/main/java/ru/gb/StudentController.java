package ru.gb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 3.1 GET /student/{id} - получить студента по ID
 * * 3.2 GET /student - получить всех студентов
 * * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
 * * 3.4 GET /group/{groupName}/student - получить всех студентов группы
 * * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
 * * 3.6 DELETE /student/{id} - удалить студента
 */

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository repository;

    @GetMapping("/all")
    public List<Student> getStudents() {
        return repository.getAll();
    }

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping //  /students?name=Anastasia
    public Student getStudentByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    @GetMapping("/{groupName}/student") //  /{groupName}/student
    public Student getStudentByGroup(@PathVariable String groupName) {
        return repository.getByGroup(groupName);
    }

    @PatchMapping("/update/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student existsStudent = repository.getById(id);
        if (existsStudent == null) { // 404
            throw new IllegalArgumentException();
        }
        existsStudent.setName(student.getName());
        existsStudent.setGroupName(student.getGroupName());
        return existsStudent;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteStudent(id);
    }

}
