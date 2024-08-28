package com.example.controller;

import com.example.common.Result;
import com.example.entity.Collect;
import com.example.entity.Help;
import com.example.service.CollectService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "收藏前端操作接口")
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Resource
    CollectService collectService;

    @PostMapping("/add")
    @ApiImplicitParam(name = "collect",value = "收藏信息",required = true)
    @ApiOperation(value = "新增收藏信息")
    public Result add(@RequestBody Collect collect) {
        collectService.add(collect);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "收藏信息id",required = true)
    @ApiOperation(value = "根据id删除收藏信息")
    public Result deleteById(@PathVariable Integer id) {
        collectService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个收藏信息id",required = true)
    @ApiOperation(value = "根据id批量删除收藏信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        collectService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询所有的收藏信息")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Collect> page = collectService.selectPage(pageNum, pageSize);
        return Result.success(page);
    }

}
