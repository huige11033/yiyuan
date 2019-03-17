package com.team.azusa.yiyuan.app;

import com.team.azusa.yiyuan.event.LoginEvent;
import com.team.azusa.yiyuan.model.UserBean;
import com.team.azusa.yiyuan.utils.UserUtils;

import de.greenrobot.event.EventBus;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/17
 */
public class UserManager {
    private static UserManager userManager = null;
    private UserBean userBean;

    public UserManager(){

    }

    public static UserManager getInstance() {
        if (userManager == null) {
            synchronized (UserManager.class) {
                if (userManager == null) {
                    userManager = new UserManager();
                }
            }
        }
        return userManager;
    }

    public UserBean getUser(){
        return userBean;
    }

    public void saveUser(UserBean user){
        userBean = user;
    }

    public void loginOut(){
        userBean = null;
        UserUtils.userisLogin = false;
        EventBus.getDefault().post(new LoginEvent(false));
    }

    public void login(UserBean userBean){
        this.userBean = userBean;
        UserUtils.userisLogin = true;
        EventBus.getDefault().post(new LoginEvent(true));
    }
}
