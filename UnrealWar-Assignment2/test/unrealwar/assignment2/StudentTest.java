/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unrealwar.assignment2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author c0687799
 */
public class StudentTest {

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetName() {
        System.out.println("name");
        Student instance = new Student("Bob", "", "", 0);
        String expResult = "Bob";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("name");
        String name = "Noob";
        Student instance = new Student();
        instance.setName(name);
        String expResult = instance.getName();
        assertEquals(expResult, name);

    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        Student instance = new Student("", "abc3421", "", 0);
        String expResult = "abc3421";
        String result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "2";
        Student instance = new Student();
        instance.setId(id);
        String expResult = instance.getId();
        assertEquals(expResult, id);

    }

    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Student instance = new Student("", "", "Male", 0);

        String expResult = "Male";

        String result = instance.getGender();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "Male";
        Student instance = new Student();
        instance.setGender(gender);
        String expResult = instance.getGender();
        assertEquals(expResult, gender);

    }

    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        Student instance = new Student("", "", "", 93.1);

        Double expResult = 93.1;

        Double result = instance.getGrade();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetGrade() {
        System.out.println("setGrade");
        Double grade = 0.0;
        Student instance = new Student();
        instance.setGrade(grade);
        Double expResult = instance.getGrade();
        assertEquals(expResult, grade);
    }

    @Test
    public void testEmptyConstructor() {
        System.out.println("Student(...)");
        String name = "";
        String id = "";
        String gender = "";
        double grade = 0.0;

        Student instance = new Student();
        assertEquals(name, instance.getName());
        assertEquals(id, instance.getId());
        assertEquals(gender, instance.getGender());
        assertEquals(grade, instance.getGrade(), 0.0);

    }

    @Test
    public void testFullConstructor() {
        System.out.println("Student(...)");
        String name = "Bob";
        String id = "abc3421";
        String gender = "Male";
        double grade = 90;

        Student instance = new Student(name, id, gender, grade);
        assertEquals(name, instance.getName());
        assertEquals(id, instance.getId());
        assertEquals(gender, instance.getGender());
        assertEquals(grade, instance.getGrade(), 0.001);
    }


    @Test
    public void testNullisNotEqual() {
        System.out.println("equals");
        Object obj = null;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testEqualsSameNameSameId() {
        System.out.println("testEqualsSameNameSameId");
        boolean result = false;
        Student obj = new Student("Noob", "2", "Male", 0.0);
        Student instance = new Student("Noob", "2", "Male", 0.0);
        assertEquals(obj, instance);

    }

    @Test
    public void testSameNameDifferentIdIsNotEqual() {
        String name = "Bob";
        String id = "abc1234";
        String id2 = "cba1234";
        Student instance = new Student(name, id, "Male", 0.0);
        instance.setName(name);
        instance.setId(id);
        Student instance2 = new Student(name, id, "Male", 0.0);
        instance2.setName(name);
        instance2.setId(id2);
        assertNotEquals(instance, instance2);
    }

    @Test
    public void testDifferentNameSameIdIsNotEqual() {
        String name = "Bob";
        String name2 = "Obopeieirp";
        String id = "abc3421";
        Student instance = new Student(name, id, "Male", 0.0);
        instance.setName(name);
        instance.setId(id);
        Student instance2 = new Student(name, id, "Male", 0.0);
        instance2.setName(name2);
        instance2.setId(id);
        assertNotEquals(instance, instance2);
    }

    @Test
    public void testDifferentNameDifferentIdIsNotEqual() {
        String name = "Bob";
        String name2 = "Obo";
        String id = "abc3421";
        String id2 = "cba1234";
        Student instance = new Student(name, id, "Male", 0.0);
        instance.setName(name);
        instance.setId(id);
        Student instance2 = new Student(name, id, "Male", 0.0);
        instance2.setName(name2);
        instance2.setId(id2);
        assertNotEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        try {
            System.out.println("toString");
            Student instance = new Student();
            instance.setName("Bill Smith");
            instance.setId("c0123456");
            instance.setGender("male");
            instance.setGrade(89.3);
            String jsonString = instance.toString();
            JSONObject result = (JSONObject) new JSONParser().parse(jsonString);
            JSONObject expResult = (JSONObject) new JSONParser().parse("{\"name\":\"Bill Smith\",\"id\":\"c0123456\",\"gender\":\"male\",\"grade\":89.3}");
            assertEquals(expResult, result);
        } catch (ParseException ex) {
            System.err.println("Invalid JSON Format");
            fail("Invalid JSON Format");
        }
    }
}
