package com.spf.euraka_client.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spf.euraka_client.model.TbUser;
import com.spf.euraka_client.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ShuPF
 * @since 2018-10-30
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    @Autowired
    private TbUserService userService;

    @RequestMapping("findAll")
    public Object findAll() {
        List<TbUser> users = userService.list(new QueryWrapper<>());
        return users;
    }

    @RequestMapping("page")
    public Object page() {
        IPage<TbUser> page = new Page<>(1,2);
        IPage<TbUser> pages =  userService.page(page, new QueryWrapper<>());
        return pages;
    }

    @RequestMapping("name")
    public Object name(@NotBlank(message = "name 不能为空") String name) {
       TbUser user = userService.findByUser(name);
        return user;
    }

}
