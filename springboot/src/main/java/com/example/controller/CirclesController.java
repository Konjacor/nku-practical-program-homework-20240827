package com.example.controller;

import com.example.common.Result;
import com.example.entity.Circles;
import com.example.service.CirclesService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 圈子前端操作接口
 **/
@Api(tags = "圈子前端操作接口")
@RestController
@RequestMapping("/circles")
public class CirclesController {

    @Resource
    private CirclesService circlesService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "circles",value = "圈子信息",required = true)
    @ApiOperation(value = "新增圈子信息")
    public Result add(@RequestBody Circles circles) {
        circlesService.add(circles);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "圈子信息id",required = true)
    @ApiOperation(value = "根据id删除圈子信息")
    public Result deleteById(@PathVariable Integer id) {
        circlesService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个圈子信息id",required = true)
    @ApiOperation(value = "根据id批量删除圈子信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        circlesService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "circles",value = "修改后的圈子信息",required = true)
    @ApiOperation(value = "修改圈子信息")
    public Result updateById(@RequestBody Circles circles) {
        circlesService.updateById(circles);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "想要查询的圈子信息的id",required = true)
    @ApiOperation(value = "根据id查询圈子信息")
    public Result selectById(@PathVariable Integer id) {
        Circles circles = circlesService.selectById(id);
        return Result.success(circles);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "circles",value = "查询条件",required = false)
    @ApiOperation(value = "查询满足条件（若有）的所有圈子信息")
    public Result selectAll(Circles circles) {
        List<Circles> list = circlesService.selectAll(circles);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="circles", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询满足条件（若有）的圈子信息")
    public Result selectPage(Circles circles,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Circles> page = circlesService.selectPage(circles, pageNum, pageSize);
        return Result.success(page);
    }

}