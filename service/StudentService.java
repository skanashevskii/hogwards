package ru.hogwarts.school.service;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exceptions.NotAnyStudent;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> studentHogwarts = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student){
        student.setId(++lastId);
        studentHogwarts.put(lastId,student);
        return student;
    }
    public Student findStudent(long id) {
        return studentHogwarts.get(id);
    }

    public Student editStudent(Student student) {
        if (!studentHogwarts.containsKey(student.getId())) {
            return null;
        }
        studentHogwarts.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentHogwarts.remove(id);
    }
    @Operation(summary = "Сортировка по возрасту")
    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentHogwarts.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
    public Collection<Student> getAllStudent(){
        if(studentHogwarts.isEmpty()){
            throw new NotAnyStudent();
        }
        return studentHogwarts.values();
    }
}
