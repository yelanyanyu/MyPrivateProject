package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Utils.Utility;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class ExitView extends AllView{


    public void exitSure() {
        boolean loop = true;
        System.out.println("您确定退出吗？退出选1，否则选0");
        while (loop) {
            System.out.print("你的选择：");
            int i = Utility.readInt();
            if (i == 1) {
                System.exit(1);
                loop = false;
            } else if (i == 0) {
                methodView.methodView();
                loop = false;
            } else {
                System.out.println("请选择正确的选项！！！");
            }
        }
    }
}
