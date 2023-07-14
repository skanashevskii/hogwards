package ru.hogwarts.school.service;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> studentHogwards = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student){
        student.setId(++lastId);
        studentHogwards.put(lastId,student);
        return student;
    }
    public Student findStudent(long id) {
        return studentHogwards.get(id);
    }

    public Student editStudent(Student student) {
        if (!studentHogwards.containsKey(student.getId())) {
            return null;
        }
        studentHogwards.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentHogwards.remove(id);
    }
    @Operation(summary = "Сортировка по возрасту")
    public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : studentHogwards.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }
    public Collection<Student> getAllStudent() {
        return studentHogwards.values();
    }
}
