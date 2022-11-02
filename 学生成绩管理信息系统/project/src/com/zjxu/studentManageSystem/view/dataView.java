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
        Integer id = student.getId();
        String name = student.getName();
        String classname = student.getClassname();
        Integer chinese = student.getChinese();
        Integer math = student.getMath();
        Integer English = student.getEnglish();
        System.out.printf("%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t\n", id, name, classname, chinese, math, English);
    }

    //全列展示
    private static void AllColView() {
        System.out.println("id\t\t\tname\t\tclassname\tChinese\t\tmath\t\tEnglish\t\t\t");
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
                System.out.printf("%-8s\t", value);
            }
            System.out.println();
        }
    }

    public static void mapListViewOfSumOrAvg(List<Map<String, Object>> mapList, String str) {
        if ("Sum".equals(str)) {
            System.out.println("id\t\t\tname\t\tclassname\tsum\t\t");
            mapListView(mapList);
        } else if ("Avg".equals(str)) {
            System.out.println("id\t\t\tname\t\tclassname\tavg\t\t");
            mapListView(mapList);
        }
    }

    public static void mapListViewOfRate(List<Map<String, Object>> mapList, String str) {
        if("Chinese".equals(str)){
            System.out.println("classname\tChineseRate");
            mapListView(mapList);
        }else if("math".equals(str)){
            System.out.println("classname\tmathRate");
            mapListView(mapList);
        }else if("English".equals(str)){
            System.out.println("classname\tEnglishRate");
            mapListView(mapList);
        }
    }


}
