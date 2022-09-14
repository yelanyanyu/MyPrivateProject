package com.zjxu.studentManageSystem.Run;

import com.zjxu.studentManageSystem.service.studentsService;
import org.junit.jupiter.api.Test;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MyTest {
    com.zjxu.studentManageSystem.service.studentsService studentsService = new studentsService();

    @Test
    public void Test_01() {
        studentsService.findByName("牛大锤");
    }

    @Test
    public void Test_02() {
        studentsService.OrderByChinese("down");
    }

    @Test
    public void Test_03() {
        studentsService.OrderByCourseSum("up");
    }

    @Test
    public void Test_04() {
        studentsService.OrderByCourseSum("up");
        studentsService.OrderByCourseSum("down");
    }

    @Test
    public void Test_05() {
        studentsService.OrderById("up");
        studentsService.OrderById("down");
    }

    @Test
    public void Test_06() {
        studentsService.OrderByAvg("up");
        studentsService.OrderByAvg("down");
    }

    @Test
    public void Test_07() {
        studentsService.add(6, "gang", "母鸡养殖211", 44, 55, 66);
    }

    @Test
    public void Test_08() {
        studentsService.findMaxChinese();
        studentsService.findMaxEnglish();
        studentsService.findMaxMath();
    }

    @Test
    public void Test_09() {
        studentsService.findMinChinese();
        studentsService.findMinMath();
        studentsService.findMinEnglish();
    }

    @Test
    public void Test_10() {
        String reg = "^[A-Z]+[\\d|_|a-z|A-Z]*$";
        String str = "z1234_afjsf";
        if (str.matches(reg)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }
}
