package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyHogwarts= new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultyHogwarts.put(lastId,faculty);
        return faculty;
    }

    public Faculty findFaculty(long id){
        return facultyHogwarts.get(id);
    }
    public Faculty editFaculty(Faculty faculty) {
        if (!facultyHogwarts.containsKey(faculty.getId())) {
            return null;
        }
        facultyHogwarts.put(faculty.getId(), faculty);
        return faculty;
    }

    public boolean deleteFaculty(long id) {
       facultyHogwarts.remove(id);
       return true;
    }
   /* public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : facultyHogwards.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }*/
    //2 вариант
    public Collection<Faculty> findByColor(String color) {

        return facultyHogwarts.values()
                .stream()
                .filter(col->col.getColor().equals(color))
                .collect(Collectors.toList());
        };
    }

