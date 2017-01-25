/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unrealwar.assignment2;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author c0533886
 */
public class Course {

    private List<Student> students;

    public Course() {
        students = new ArrayList<>();
    }

    public Course(List<Student> students) {
        this.students = students;
    }

    public void add(Student s) {
        students.add(s);
    }

    public void remove(Student s) {
        students.remove(s);
    }

    public void remove(String id) {
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
            }
        }
    }

    public void remove(int position) {
        students.remove(position);
    }

    public void insert(Student s, int position) {
        students.set(position, s);
    }

    public Student get(String id) {
        int i;
        for (i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student get(int position) {
        if (position >= students.size() || position < 0) {
            return null;
        }
        return students.get(position);
    }

    public List<Student> getAll() {
        return students;
    }

    public boolean equals(ArrayList<Object> list1, ArrayList<Object> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if ((list1 == null && list2 != null) || (list1 != null && list2 == null)) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        for (Object itemList1 : list1) {
            if (!list2.contains(itemList1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        JsonArray jsonArray = new JsonArray();
        JsonParser parser = new JsonParser();
        for (Student s : students) {
            JsonElement jsonObj = parser.parse(s.toString());
            jsonArray.add(jsonObj);
        }
        return jsonArray.toString();
    }

    public Student getAllbyGender(String gender) {
        for (Student s : students) {
            if (s.getGender().equals(gender)) {
                return s;
            }
        }
        return null;
    }

    public Map<String, Set<Student>> getGradeMap() {
        Map<String, Set<Student>> s = new HashMap<>();

        Set<Student> studentA = new HashSet<>();
        Set<Student> studentB = new HashSet<>();
        Set<Student> studentC = new HashSet<>();
        Set<Student> studentD = new HashSet<>();
        Set<Student> studentE = new HashSet<>();

        for (int x = 0; x < students.size(); x++) {
            if (students.get(x).getGrade() < 1) {
                studentA.add(students.get(x));
            } else if (students.get(x).getGrade() >= 1 && students.get(x).getGrade() < 2) {
                studentB.add(students.get(x));
            } else if (students.get(x).getGrade() >= 2 && students.get(x).getGrade() < 3) {
                studentC.add(students.get(x));
            } else if (students.get(x).getGrade() >= 3 && students.get(x).getGrade() < 4) {
                studentD.add(students.get(x));
            } else if (students.get(x).getGrade() >= 4 && students.get(x).getGrade() < 5) {
                studentE.add(students.get(x));
            }
        }

        s.put("A", studentE);
        s.put("B", studentD);
        s.put("C", studentC);
        s.put("D", studentB);
        s.put("F", studentA);

        return s;
    }
}
