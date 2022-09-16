package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.service.studentsService;
import com.zjxu.studentManageSystem.service.usersService;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class AllView {
    public static ExitView exitView = new ExitView();
    public static LoginView loginView = new LoginView();
    public static mainView mainView = new mainView();
    public static methodView methodView = new methodView();
    public static RegisterView registerView = new RegisterView();

    public static usersService usersService = new usersService();
    public static studentsService studentsService = new studentsService();
}
