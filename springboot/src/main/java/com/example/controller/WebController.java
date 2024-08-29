package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.exception.CustomException;
import com.example.service.AdminService;
import com.example.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础前端接口
 */
@Api(tags = "基础前端接口")
@RestController
public class WebController {

    @Resource
    private AdminService adminService;
    @Resource
    UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "访问根路径", notes = "返回访问成功的消息")
    @ApiResponse(code = 200, message = "访问成功", response = String.class)
    public Result hello() {
        return Result.success("访问成功");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "根据用户提供的信息登录")
    @ApiImplicitParam(name = "account", value = "登录信息", required = true, dataType = "Account")
    @ApiResponses({
            @ApiResponse(code = 200, message = "登录成功", response = Account.class),
            @ApiResponse(code = 400, message = "登录失败", response = Result.class)
    })
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            account = adminService.login(account);
        } else if (RoleEnum.USER.name().equals(account.getRole())) {
            account = userService.login(account);
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        return Result.success(account);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "根据用户提供的信息注册")
    @ApiImplicitParam(name = "account", value = "注册信息", required = true, dataType = "Account")
    @ApiResponses({
            @ApiResponse(code = 200, message = "注册成功"),
            @ApiResponse(code = 400, message = "注册失败", response = Result.class)
    })
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            userService.register(account);
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    @ApiOperation(value = "修改密码", notes = "根据信息修改密码")
    @ApiImplicitParam(name = "account", value = "密码修改信息", required = true, dataType = "Account")
    @ApiResponses({
            @ApiResponse(code = 200, message = "密码修改成功"),
            @ApiResponse(code = 400, message = "密码修改失败", response = Result.class)
    })
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            adminService.updatePassword(account);
        } else if (RoleEnum.USER.name().equals(account.getRole())) {
            userService.updatePassword(account);
        }
        return Result.success();
    }

}
