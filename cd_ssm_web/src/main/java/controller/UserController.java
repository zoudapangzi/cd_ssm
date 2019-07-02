package controller;

import domain.Role;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId ,@RequestParam(name = "ids",required = true) String[] roleId){
        userService.addRoleToUser(userId,roleId);
        return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId){
        //1.根据用户ID查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户ID查询用户可以添加的角色
        List<Role> roleList=userService.findOtherRoles(userId);

        ModelAndView mv=new ModelAndView();
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     *根据id查询用户详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 添加用户
     * @param userInfo 页面写的数据
     * @return
     */
    @RequestMapping("save")
    public String save(UserInfo userInfo){

        userService.save(userInfo);

        return "redirect:findAll";
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<UserInfo> users= userService.findAll();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }
}
