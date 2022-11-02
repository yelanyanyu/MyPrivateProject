package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Bean.students;
import com.zjxu.studentManageSystem.Utils.ViewUtils;
import com.zjxu.studentManageSystem.Utils.inputUtility;

import java.util.List;
import java.util.Map;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class methodView {
    public static void methodView() {
        System.out.println("=========功能选择界面========");
        System.out.print("输入1退出，其他数字继续：");
        if (inputUtility.readInt() == 1) {
            ViewUtils.exitView.exitSure();
        }
        System.out.println("输入1查询相关信息，输入2修改信息，输入-1退出：");
        System.out.print("你的选择：");
        int i = inputUtility.readInt();
        if (i == 1) {
            findView();
        } else if (i == 2) {
            updateView();
        } else if (i == -1) {
            ViewUtils.exitView.exitSure();
        }
    }

    public static void findView() {
        boolean loop = true;
        while (loop) {
            System.out.println("=========查询界面=========");
            System.out.println("1:按学号查询学生");
            System.out.println("2:按姓名查询学生");
            System.out.println("3:按班级查询学生");
            System.out.println("4:按课程名查询学生");
            System.out.println("5:按照语文成绩排序全部");
            System.out.println("6:按照数学成绩排序全部");
            System.out.println("7:按照英语成绩排序全部");
            System.out.println("8:按照总成绩排序全部");
            System.out.println("9:按照平均成绩排序全部");
            System.out.println("10:按照学号排序全部");
            System.out.println("11:查询每个课程的最高分");
            System.out.println("12:查询每个班级某门课程的优秀率");
            System.out.println("13:查询每个班级某门课程的不及格率");
            System.out.println("0:返回上一页面!");
            System.out.println("-1:退出!");
            int i = inputUtility.readInt();
            switch (i) {
                case 0:
                    loop = false;
                    methodView();
                    break;
                case -1:
                    loop = false;
                    ViewUtils.exitView.exitSure();
                    break;
                case 1:
                    System.out.print("请输入学号：");
                    String id = inputUtility.readString(64);
                    students studentId = ViewUtils.studentsService.findById(id);
                    System.out.println(studentId);
                    break;
                case 2:
                    System.out.print("输入姓名：");
                    String name = inputUtility.readString(64);
                    students studentName = ViewUtils.studentsService.findByName(name);
                    //显示数据
                    dataView.studentSingleView(studentName);
                    break;
                case 3:
                    System.out.print("请输入班级：");
                    String classname = inputUtility.readString(64);
                    List<students> byClassname = ViewUtils.studentsService.findByClassname(classname);
                    dataView.studentsListView(byClassname);
                    break;
                case 4:
                    System.out.print("请输入课程名：");
                    String course = inputUtility.readString(64);
                    List<students> studentsList = ViewUtils.studentsService.AllStudents();
                    dataView.studentsListView(studentsList);
                    break;
                case 5:
                    System.out.print("输入up升序，down降序：");
                    String choice1 = inputUtility.readString(64);
                    List<students> orderByChinese = ViewUtils.studentsService.OrderByChinese(choice1);
                    dataView.studentsListView(orderByChinese);
                    break;
                case 6:
                    System.out.print("输入up升序，down降序：");
                    String choice2 = inputUtility.readString(64);
                    List<students> ordermath = ViewUtils.studentsService.OrderMath(choice2);
                    dataView.studentsListView(ordermath);
                    break;
                case 7:
                    System.out.print("输入up升序，down降序：");
                    String choice3 = inputUtility.readString(64);
                    List<students> orderByEnglish = ViewUtils.studentsService.OrderByEnglish(choice3);
                    dataView.studentsListView(orderByEnglish);
                    break;
                case 8:
                    System.out.print("输入up升序，down降序：");
                    String choice4 = inputUtility.readString(64);
                    List<Map<String, Object>> mapListSum = ViewUtils.studentsService.OrderByCourseSum(choice4);
                    dataView.mapListViewOfSumOrAvg(mapListSum, "Sum");
                    break;
                case 9:
                    System.out.print("输入up升序，down降序：");
                    String choice5 = inputUtility.readString(64);
                    List<Map<String, Object>> mapListAvg = ViewUtils.studentsService.OrderByAvg(choice5);
                    dataView.mapListViewOfSumOrAvg(mapListAvg, "Avg");
                    break;
                case 10:
                    System.out.print("输入up升序，down降序：");
                    String choice6 = inputUtility.readString(64);
                    List<students> studentsList1 = ViewUtils.studentsService.OrderById(choice6);
                    dataView.studentsListView(studentsList1);
                    break;
                case 11:
                    System.out.print("请输入课程：");
                    String selectedCourse = inputUtility.readString(64);
                    if (selectedCourse.equals("Chinese")) {
                        List<students> maxChinese = ViewUtils.studentsService.findMaxChinese();
                        dataView.studentsListView(maxChinese);
                    } else if (selectedCourse.equals("math")) {
                        List<students> maxMath = ViewUtils.studentsService.findMaxMath();
                        dataView.studentsListView(maxMath);
                    } else if (selectedCourse.equals("English")) {
                        List<students> maxEnglish = ViewUtils.studentsService.findMaxEnglish();
                        dataView.studentsListView(maxEnglish);
                    }
                    break;
                case 12:
                    System.out.print("请输入查询的课程：");
                    String course1 = inputUtility.readString(64);
                    List<Map<String, Object>> excellenceRateAll = ViewUtils.studentsService.getExcellenceRateAll(course1);
                    dataView.mapListViewOfRate(excellenceRateAll, course1);
                    break;
                case 13:
                    System.out.print("请输入查询的课程：");
                    String course2 = inputUtility.readString(64);
                    List<Map<String, Object>> failureRateAll = ViewUtils.studentsService.getFailureRateAll(course2);
                    dataView.mapListViewOfRate(failureRateAll, course2);
                    break;
            }
        }
    }

    public static void updateView() {
        boolean loop = true;
        while (loop) {
            System.out.println("=========修改界面=========");
            System.out.println("1.增添记录；");
            System.out.println("2.修改记录：");
            System.out.println("3.删除记录：");
            System.out.println("0:返回上一页面!");
            System.out.println("-1:退出!");
            int i = inputUtility.readInt();
            switch (i) {
                case 0:
                    loop = false;
                    methodView();
                    break;
                case -1:
                    loop = false;
                    ViewUtils.exitView.exitSure();
                    break;
                case 1:
                    System.out.println("请输入你的信息：");
                    System.out.print("学生学号：");
                    int id = inputUtility.readInt();
                    System.out.print("学生姓名：");
                    String name = inputUtility.readString(64);
                    System.out.print("学生班级：");
                    String classname = inputUtility.readString(64);
                    System.out.print("学生语文成绩：");
                    int Chinese = inputUtility.readInt();
                    System.out.print("学生数学成绩：");
                    int math = inputUtility.readInt();
                    System.out.print("学生英语成绩：");
                    int English = inputUtility.readInt();
                    int add = ViewUtils.studentsService.add(id, name, classname, Chinese, math, English);
                    if (add > 0) {
                        System.out.println("增添成功！！");
                    } else {
                        System.out.println("失败");
                    }
                    break;
                case 2:
                    System.out.print("学生学号：");
                    int id1 = inputUtility.readInt();
                    System.out.print("学生语文成绩：");
                    int Chinese1 = inputUtility.readInt();
                    System.out.print("学生数学成绩：");
                    int math1 = inputUtility.readInt();
                    System.out.print("学生英语成绩：");
                    int English1 = inputUtility.readInt();
                    int update = ViewUtils.studentsService.updateCourseById(id1, Chinese1, math1, English1);
                    if (update > 0) {
                        System.out.println("修改成功~");
                    } else {
                        System.out.println("修改失败！！！");
                    }
                    break;
                case 3:
                    System.out.print("学生学号：");
                    int id2 = inputUtility.readInt();
                    boolean b = ViewUtils.studentsService.deleteLineById(id2);
                    if (b) {
                        System.out.println("删除成功~");
                    } else {
                        System.out.println("删除失败！！！");
                    }
                    break;
            }
        }
    }


}
