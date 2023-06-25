package ru.hogwarts.school;

import ru.hogwarts.school.model.Faculty;


import java.util.*;

public class FacultyConstants {
    public static long id = 1;
    public static String name1 = "name1";
    public static String name2 = "name2";
    public static String name3 = "name3";
    public static String color1 = "color1";
    public static String color2 = "color1";
    public static String color3 = "color2";
    public static Faculty faculty1 = new Faculty(name1,color1, 0L);
    public static Faculty faculty2 = new Faculty(name2,color2,1L);
    public static Faculty faculty3 = new Faculty(name3,color3,2L);
    public static Collection<Faculty> facultyList = new ArrayList<>(List.of(faculty1,faculty2));
}
