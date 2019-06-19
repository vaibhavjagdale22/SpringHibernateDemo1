package com.prj.controller;
import com.prj.entities.UserInfo;
import com.prj.services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ProjectController {
    private LoginServices loginServices;

    @Autowired(required = true)
    private void setLoginServices(LoginServices loginServices) {
        this.loginServices = loginServices;
    }

    @RequestMapping(value = "/click", method = RequestMethod.GET)
    public ModelAndView clickMe(@ModelAttribute ("userinfo") UserInfo userInfo){
        loginServices.addUser(userInfo);
        return new ModelAndView("click");
    }

}
