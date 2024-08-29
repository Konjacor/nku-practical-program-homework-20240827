package com.example.controller;

import com.example.common.Result;
import com.example.entity.Posts;
import com.example.service.PostsService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 帖子前端操作接口
 **/
@Api(tags = "帖子操作接口")
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Resource
    private PostsService postsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "posts",value="帖子信息",required = true)
    @ApiOperation(value = "增加帖子信息")
    public Result add(@RequestBody Posts posts) {
        postsService.add(posts);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value="帖子信息id",required = true)
    @ApiOperation(value = "帖子信息删除")
    public Result deleteById(@PathVariable Integer id) {
        postsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个帖子信息id",required = true)
    @ApiOperation(value = "根据id批量删除帖子信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        postsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "posts",value = "帖子信息修改",required = true)
    @ApiOperation(value = "帖子信息修改")
    public Result updateById(@RequestBody Posts posts) {
        postsService.updateById(posts);
        return Result.success();
    }

    @PutMapping("/updateCount/{id}")
    @ApiImplicitParam(name = "id",value = "帖子信息数量修改",required = true)
    @ApiOperation(value = "帖子信息数量修改")
    public Result updateCount(@PathVariable Integer id) {
        postsService.updateCount(id);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "帖子信息id",required = true)
    @ApiOperation(value = "根据帖子信息id查询")
    public Result selectById(@PathVariable Integer id) {
        Posts posts = postsService.selectById(id);
        return Result.success(posts);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "posts",value = "查询条件",required = false)
    @ApiOperation(value = "查询帖子信息")
    public Result selectAll(Posts posts) {
        List<Posts> list = postsService.selectAll(posts);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="posts", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询所有帖子信息")
    public Result selectPage(Posts posts,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Posts> page = postsService.selectPage(posts, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 前台分页查询
     */
    @GetMapping("/selectFrontPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="posts", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "前台分页查询所有帖子信息")
    public Result selectFrontPage(Posts posts,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Posts> page = postsService.selectFrontPage(posts, pageNum, pageSize);
        return Result.success(page);
    }

}