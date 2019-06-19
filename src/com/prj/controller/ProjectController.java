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

    /*@Autowiring
    * Why we need it?
    *To getting an object form application context we needs bean and for that bean configuration
    * is required(for example: <bean id = "loginServices" class="com.prj.servicesimpl.LoginServiceImpl" ></bean>).
    * and to get an object of purticular class we need to go through ApplicationContext's getBean()method.
    * instead of writing a code for getBean() we can inject required object by using @Autowired annotations.
    *
    * whenever we use @Autowired annotation spring framework manage life cycle of that object and inject
    * it to specified object.
    * for Example(
    *  private LoginServices loginServices;
    *  @Autowired(required = true)
        private void setLoginServices(LoginServices loginServices) {
            this.loginServices = loginServices;
        }
    * )
    * for more information goto : https://www.youtube.com/watch?v=x_-Tx6OFYLg
    * */
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
