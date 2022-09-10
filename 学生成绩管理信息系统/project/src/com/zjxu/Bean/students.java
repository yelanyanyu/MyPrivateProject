package com.zjxu.Bean;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class students {
    Integer id;
    String name;
    String classname;
    String Chinese;
    String math;
    String English;

    public students(Integer id, String name, String classname, String chinese, String math, String english) {
        this.id = id;
        this.name = name;
        this.classname = classname;
        Chinese = chinese;
        this.math = math;
        English = english;
    }

    public students() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getChinese() {
        return Chinese;
    }

    public void setChinese(String chinese) {
        Chinese = chinese;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", Chinese='" + Chinese + '\'' +
                ", math='" + math + '\'' +
                ", English='" + English + '\'' +
                '}';
    }
}
