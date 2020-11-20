/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareengineeringdriver;

import com.mycompany.softwareengineering.*;
import com.mycompany.softwareengineering.Module;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author duffy
 */
public class testClass {

    public static void main(String[] args) {
        ArrayList<Student> students = populateStudents("students.csv");
        ArrayList<Course> courses = populateCourses("courses.csv");
        ArrayList<Module> modules = populateModules("modules.csv");
        courses.get(0).addModule(modules.get(3));
        courses.get(0).addModule(modules.get(4));
        courses.get(0).addModule(modules.get(5));
        courses.get(1).addModule(modules.get(3));
        courses.get(1).addModule(modules.get(4));
        courses.get(1).addModule(modules.get(5));
        courses.get(2).addModule(modules.get(0));
        courses.get(2).addModule(modules.get(1));
        courses.get(2).addModule(modules.get(2));
        courses.get(3).addModule(modules.get(0));
        courses.get(3).addModule(modules.get(1));
        courses.get(3).addModule(modules.get(2));

//        for (int x = 0; x < students.size(); x++) {
//            students.get(x).setCourse(courses.get(x%4));
//            System.out.print(students.get(x).toString());
//        }
        
            for (int x = 0; x < students.size(); x++) {
            courses.get(x%4).addStudent(students.get(x));
            //System.out.print(courses.get(x%4).toString());
        }
            for (int x = 0; x<courses.size();x++){
                System.out.print(courses.get(x).toString());
            }
        
    }

    public static ArrayList<Student> populateStudents(String csvFile) {
        ArrayList<Student> students = new ArrayList<Student>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] student = line.split(cvsSplitBy);
                students.add(new Student(student[0], student[1], student[2], Integer.parseInt(student[3])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return students;
    }

    public static ArrayList<Course> populateCourses(String csvFile) {
        ArrayList<Course> courses = new ArrayList<Course>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] course = line.split(cvsSplitBy);
                courses.add(new Course(course[0], course[1], course[2], course[3]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return courses;
    }

    public static ArrayList<Module> populateModules(String csvFile) {
        ArrayList<Module> modules = new ArrayList<Module>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] module = line.split(cvsSplitBy);
                modules.add(new Module(module[0], module[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return modules;
    }

}
