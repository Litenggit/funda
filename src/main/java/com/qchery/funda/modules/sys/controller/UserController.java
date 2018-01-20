package com.qchery.funda.modules.sys.controller;

import com.qchery.funda.Result;
import com.qchery.funda.modules.sys.entity.User;
import com.qchery.funda.modules.sys.model.UserModel;
import com.qchery.funda.modules.sys.service.UserService;
import com.qchery.funda.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Result list(@RequestBody UserModel userModel) {
        List<User> userList = userService.listByAgeLargeThan(userModel.getAge());
        return ResultUtils.success(userList);
    }

    @RequestMapping("login")
    public Result login(@RequestBody @Valid UserModel userModel) {
        User user = userService.login(userModel.getUsername(), userModel.getPassword());
        return ResultUtils.success(user);
    }

}
