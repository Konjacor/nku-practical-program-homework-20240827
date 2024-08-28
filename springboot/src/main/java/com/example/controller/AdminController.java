package com.example.controller;

import com.example.common.Result;
import com.example.entity.Admin;
import com.example.service.AdminService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员前端操作接口
 **/
@Api(tags = "管理员信息管理后端操作接口")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "admin",value = "管理员信息",required = true)
    @ApiOperation(value = "添加管理员")
    public Result add(@RequestBody Admin admin) {
        adminService.add(admin);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "管理员编号",required = true)
    @ApiOperation(value = "删除管理员")
    public Result deleteById(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个管理员编号",required = true)
    @ApiOperation(value = "删除多个管理员")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        adminService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "admin",value = "管理员信息",required = true)
    @ApiOperation(value = "更新管理员信息")
    public Result updateById(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "管理员编号",required = true)
    @ApiOperation(value = "选择管理员编号")
    public Result selectById(@PathVariable Integer id) {
        Admin admin = adminService.selectById(id);
        return Result.success(admin);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin", value = "管理员信息", required = true),
            @ApiImplicitParam(name = "id", value = "管理员编码", required = true),
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true),
            @ApiImplicitParam(name = "name", value = "名字", required = false),
            @ApiImplicitParam(name = "phone", value = "电话号码", required = false),
            @ApiImplicitParam(name = "email", value = "邮件", required = false),
            @ApiImplicitParam(name = "avatar", value = "头像", required = false),
            @ApiImplicitParam(name = "role", value = "角色", required = true)
    })
    @ApiOperation(value = "选择全部管理员")
    public Result selectAll(Admin admin ) {
        List<Admin> list = adminService.selectAll(admin);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "admin", value = "管理员信息", required = true),
            @ApiImplicitParam(name = "id", value = "管理员编码", required = true),
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true),
            @ApiImplicitParam(name = "name", value = "名字", required = false),
            @ApiImplicitParam(name = "phone", value = "电话号码", required = false),
            @ApiImplicitParam(name = "email", value = "邮件", required = false),
            @ApiImplicitParam(name = "avatar", value = "头像", required = false),
            @ApiImplicitParam(name = "role", value = "角色", required = true),
            @ApiImplicitParam(name = "page",value = "页数",required = true),
            @ApiImplicitParam(name = "pageNum", value = "管理员信息当前页数", required = true),
            @ApiImplicitParam(name = "pageSize",value = "管理员信息总页数",required = true)
    })
    @ApiOperation(value = "选择管理员信息页数")
    public Result selectPage(Admin admin,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Admin> page = adminService.selectPage(admin, pageNum, pageSize);
        return Result.success(page);
    }

}