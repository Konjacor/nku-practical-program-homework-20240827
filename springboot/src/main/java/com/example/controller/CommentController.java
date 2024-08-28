package com.example.controller;

import com.example.common.Result;
import com.example.entity.Comment;
import com.example.service.CommentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表前端操作接口
 **/
@Api(tags = "评论表前端操作接口")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "comment",value = "评论信息",required = true)
    @ApiOperation(value = "新增评论信息")
    public Result add(@RequestBody Comment comment) {
        commentService.add(comment);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "评论信息id",required = true)
    @ApiOperation(value = "根据id删除评论信息")
    public Result deleteById(@PathVariable Integer id) {
        commentService.deleteById(id);
        return Result.success();
    }

    /**
     * 递归删除
     */
    @DeleteMapping("/deleteDeep/{id}")
    @ApiImplicitParam(name = "id",value = "评论信息id",required = true)
    @ApiOperation(value = "根据id递归删除评论信息")
    public Result deleteDepp(@PathVariable Integer id) {
        commentService.deleteDeep(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个评论信息id",required = true)
    @ApiOperation(value = "根据id批量删除评论信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        commentService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "comment",value = "修改后的评论信息",required = true)
    @ApiOperation(value = "修改评论信息")
    public Result updateById(@RequestBody Comment comment) {
        commentService.updateById(comment);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "想要查询的评论信息的id",required = true)
    @ApiOperation(value = "根据id查询评论信息")
    public Result selectById(@PathVariable Integer id) {
        Comment comment = commentService.selectById(id);
        return Result.success(comment);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "comment",value = "查询条件",required = false)
    @ApiOperation(value = "查询满足条件（若有）的所有评论信息")
    public Result selectAll(Comment comment) {
        List<Comment> list = commentService.selectAll(comment);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="comment", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询满足条件（若有）的评论信息")
    public Result selectPage(Comment comment,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Comment> page = commentService.selectPage(comment, pageNum, pageSize);
        return Result.success(page);
    }

    @GetMapping("/selectTree/{fid}/{module}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fid", value = "关联id", required = true),
            @ApiImplicitParam(name="module", value = "模块名称", required = true),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询出具有嵌套结构的评论信息")
    public Result selectTree(@PathVariable Integer fid, @PathVariable String module,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "5") Integer pageSize) {
        PageInfo<Comment> pageInfo = commentService.selectTree(fid, module, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/selectCount/{fid}/{module}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fid", value = "关联id", required = true),
            @ApiImplicitParam(name="module", value = "模块名称", required = true)
    })
    @ApiOperation(value = "查询出具有嵌套结构的评论信息")
    public Result selectCount(@PathVariable Integer fid, @PathVariable String module) {
        Integer count = commentService.selectCount(fid, module);
        return Result.success(count);
    }

}