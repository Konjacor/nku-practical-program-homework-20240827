package com.example.controller;

import com.example.common.Result;
import com.example.entity.Feedback;
import com.example.service.FeedbackService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 反馈信息前端操作接口
 **/
@Api(tags="用户反馈接口")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "feedback",value="反馈信息",required = true)
    @ApiOperation(value = "增加反馈信息")
    public Result add(@RequestBody Feedback feedback) {
        feedbackService.add(feedback);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value="反馈信息id",required = true)
    @ApiOperation(value = "删除评论信息")
    public Result deleteById(@PathVariable Integer id) {
        feedbackService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value="选取的多个反馈信息",required = true)
    @ApiOperation(value = "批量删除反馈信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        feedbackService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "feedback",value="反馈信息修改",required = true)
    @ApiOperation(value = "修改反馈信息")
    public Result updateById(@RequestBody Feedback feedback) {
        feedbackService.updateById(feedback);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value="反馈信息id",required = true)
    @ApiOperation(value = "反馈信息查询")
    public Result selectById(@PathVariable Integer id) {
        Feedback feedback = feedbackService.selectById(id);
        return Result.success(feedback);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "feedback",value="反馈信息",required = false)
    @ApiOperation(value = "查询反馈信息")
    public Result selectAll(Feedback feedback) {
        List<Feedback> list = feedbackService.selectAll(feedback);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="feedback", value = "反馈信息", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询满足条件（若有）的反馈信息")

    public Result selectPage(Feedback feedback,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Feedback> page = feedbackService.selectPage(feedback, pageNum, pageSize);
        return Result.success(page);
    }

}