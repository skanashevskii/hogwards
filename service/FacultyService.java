package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyHogwards= new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultyHogwards.put(lastId,faculty);
        return faculty;
    }

    public Faculty findFaculty(long id){
        return facultyHogwards.get(id);
    }
    public Faculty editFaculty(Faculty faculty) {
        if (!facultyHogwards.containsKey(faculty.getId())) {
            return null;
        }
        facultyHogwards.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return facultyHogwards.remove(id);
    }
    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultyHogwards.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }
}
