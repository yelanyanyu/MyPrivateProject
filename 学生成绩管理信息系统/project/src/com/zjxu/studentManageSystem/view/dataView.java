package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Bean.students;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class dataView {
    //单个学生全列展示
    public static void studentSingleView(students student) {
        AllColView();
        allStudentsCols(student);
    }

    //students表全列字段值展示
    private static void allStudentsCols(students student) {
        System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t"
                + student.getClassname() + "\t\t" + student.getChinese() + "\t\t" +
                student.getMath() + "\t\t" + student.getEnglish() + "\t\t");
    }

    //全列展示
    private static void AllColView() {
        System.out.println("id\t\tname\t\tclassname\t\tChinese\t\tmath\t\tEnglish\t\t");
    }

    public static void studentsListView(List<students> studentsList) {
        AllColView();
        for (students student : studentsList) {
            allStudentsCols(student);
        }
    }

    private static void mapListView(List<Map<String, Object>> mapList) {
        for (Map<String, Object> map : mapList) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                Object value = entry.getValue();
                System.out.println(value + "\t\t");
            }
        }
    }

    public static void mapListViewOfSumOrAvg(List<Map<String, Object>> mapList, String str) {
        if ("Sum".equals(str)) {
            System.out.println("id\t\tname\t\tclassname\t\tsum\t\t");
            mapListView(mapList);
        } else if ("Avg".equals(str)) {
            System.out.println("id\t\tname\t\tclassname\t\tavg\t\t");
            mapListView(mapList);
        }
    }


}
