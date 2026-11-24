package com.moying.test.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moying.test.common.Result;
import com.moying.test.entity.PageDto;
import com.moying.test.entity.User;
import com.moying.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 墨莹
 * @date 2026/11/24 14:50
 */


@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping("/get/{id}")
    public Result<User> get(@PathVariable Integer id) {
        return userService.selectUser(id) != null ? Result.success(userService.selectUser(id)):Result.fail("filed select");
    }

    @PostMapping("/add")
    public Result<String> add(@RequestBody User user) {
        return userService.addUser(user) == 1 ? Result.success("Succeed add !"):Result.fail("Filed add!");
    }

    @DeleteMapping("/delete")
    public Result<String> delete(@RequestParam Integer id) {
        return userService.deleteUser(id) == 1 ? Result.success("Succeed delete !"):Result.fail("Filed delete!");
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody User user) {
        return userService.updateUser(user) == 1 ? Result.success("Succeed update !"):Result.fail("Filed update!");
    }

    @GetMapping("/page")
    public Result<Page<User>> page(@ModelAttribute PageDto pageDto) {
        return userService.findByPage(pageDto) != null ? Result.success(userService.findByPage(pageDto)):Result.fail("Filed add!");
    }


}
