package com.zjxu.studentManageSystem.Utils;

import com.zjxu.studentManageSystem.service.studentsService;
import com.zjxu.studentManageSystem.service.usersService;
import com.zjxu.studentManageSystem.view.*;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class ViewUtils {
    public static ExitView exitView = new ExitView();
    public static LoginView loginView = new LoginView();
    public static com.zjxu.studentManageSystem.view.mainView mainView = new mainView();
    public static com.zjxu.studentManageSystem.view.methodView methodView = new methodView();
    public static RegisterView registerView = new RegisterView();

    public static usersService usersService = new usersService();
    public static studentsService studentsService = new studentsService();

}
