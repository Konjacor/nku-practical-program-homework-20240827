package com.example.controller;

import com.example.common.Result;
import com.example.entity.Help;
import com.example.service.HelpService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 求购信息前端操作接口
 **/
@Api(tags = "求购信息前端操作接口")
@RestController
@RequestMapping("/help")
public class HelpController {

    @Resource
    private HelpService helpService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "help",value = "求购信息",required = true)
    @ApiOperation(value = "新增求购信息")
    public Result add(@RequestBody Help help) {
        helpService.add(help);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "求购信息id",required = true)
    @ApiOperation(value = "根据id删除求购信息")
    public Result deleteById(@PathVariable Integer id) {
        helpService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个求购信息id",required = true)
    @ApiOperation(value = "批量删除求购信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        helpService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "help",value = "修改求购信息",required = true)
    @ApiOperation(value = "修改求购信息")
    public Result updateById(@RequestBody Help help) {
        helpService.updateById(help);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "查询的求购信息id",required = true)
    @ApiOperation(value = "查询求购信息")
    public Result selectById(@PathVariable Integer id) {
        Help help = helpService.selectById(id);
        return Result.success(help);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "help",value = "查询条件",required = false)
    @ApiOperation(value = "查询求购信息")
    public Result selectAll(Help help) {
        List<Help> list = helpService.selectAll(help);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="help", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询的求购信息")
    public Result selectPage(Help help,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Help> page = helpService.selectPage(help, pageNum, pageSize);
        return Result.success(page);
    }

    @GetMapping("/selectFrontPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="help", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "前台分页查询所有求购信息")
    public Result selectFrontPage(Help help,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Help> page = helpService.selectFrontPage(help, pageNum, pageSize);
        return Result.success(page);
    }

}