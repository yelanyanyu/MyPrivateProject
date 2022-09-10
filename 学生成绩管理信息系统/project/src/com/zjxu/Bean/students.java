package com.zjxu.Bean;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class students {
    Integer id;
    String name;
    String classname;
    Integer Chinese;
    Integer math;
    Integer English;

    public students() {
    }

    public students(Integer id, String name, String classname, Integer chinese, Integer math, Integer english) {
        this.id = id;
        this.name = name;
        this.classname = classname;
        Chinese = chinese;
        this.math = math;
        English = english;
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

    public Integer getChinese() {
        return Chinese;
    }

    public void setChinese(Integer chinese) {
        Chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return English;
    }

    public void setEnglish(Integer english) {
        English = english;
    }

    @Override
    public String toString() {
        return "\nstudents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classname='" + classname + '\'' +
                ", Chinese='" + Chinese + '\'' +
                ", math='" + math + '\'' +
                ", English='" + English + '\'' +
                '}';
    }
}
