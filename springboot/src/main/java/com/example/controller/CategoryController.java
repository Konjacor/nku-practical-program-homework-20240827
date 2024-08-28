package com.example.controller;

import com.example.common.Result;
import com.example.entity.Category;
import com.example.service.CategoryService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 分类前端操作接口
 **/
@Api(tags = "商品类别后端操作接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "类别信息", required = true),
            @ApiImplicitParam(name = "id", value = "类别编码", required = true),
            @ApiImplicitParam(name = "name", value = "类别名", required = false),
    })
    @ApiOperation(value = "增加商品类别")
    public Result add(@RequestBody Category category) {
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "类别编码", required = true)
    @ApiOperation(value = "删除商品类别")
    public Result deleteById(@PathVariable Integer id) {
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids", value = "多个类别编码", required = true)
    @ApiOperation(value = "删除多个商品类别")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        categoryService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "类别信息", required = true),
            @ApiImplicitParam(name = "id", value = "类别编码", required = true),
            @ApiImplicitParam(name = "name", value = "类别名", required = false),
    })
    @ApiOperation(value = "更改商品类别信息")
    public Result updateById(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id", value = "类别编码", required = true)
    @ApiOperation(value = "选择商品类别")
    public Result selectById(@PathVariable Integer id) {
        Category category = categoryService.selectById(id);
        return Result.success(category);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别编码", required = true),
            @ApiImplicitParam(name = "name", value = "类别名", required = false),
    })
    @ApiOperation(value = "选择所有商品类别")
    public Result selectAll(Category category) {
        List<Category> list = categoryService.selectAll(category);
        return Result.success(list);
    }

    /**
     * 分页查询
     */

    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "类别编码", required = true),
            @ApiImplicitParam(name = "name", value = "类别名", required = false),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true),
            @ApiImplicitParam(name = "pageSize",value = "一共存在多少页",required = true)
    })
    @ApiOperation(value = "选择商品类别页数")
    public Result selectPage(Category category,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Category> page = categoryService.selectPage(category, pageNum, pageSize);
        return Result.success(page);
    }

}