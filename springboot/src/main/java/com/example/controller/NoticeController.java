package com.example.controller;

import com.example.common.Result;
import com.example.entity.Notice;
import com.example.service.NoticeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 公告信息表前端操作接口
 **/
@Api(tags = "公告信息操作接口")
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "notice",value = "公告信息",required = true)
    @ApiOperation(value = "新增公告信息")
    public Result add(@RequestBody Notice notice) {
        noticeService.add(notice);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "公告信息id",required = true)
    @ApiOperation(value = "根据id删除公告信息")
    public Result deleteById(@PathVariable Integer id) {
        noticeService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个公告信息id",required = true)
    @ApiOperation(value = "批量删除公告信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        noticeService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "notice",value = "修改公告信息",required = true)
    @ApiOperation(value = "修改公告信息")
    public Result updateById(@RequestBody Notice notice) {
        noticeService.updateById(notice);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "查询的公告信息id",required = true)
    @ApiOperation(value = "根据公告信息id查询")
    public Result selectById(@PathVariable Integer id) {
        Notice notice = noticeService.selectById(id);
        return Result.success(notice);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "notice",value = "查询公告",required = false)
    @ApiOperation(value = "查询公告信息")
    public Result selectAll(Notice notice ) {
        List<Notice> list = noticeService.selectAll(notice);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="notice", value = "查询公告", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询的公告信息")
    public Result selectPage(Notice notice,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Notice> page = noticeService.selectPage(notice, pageNum, pageSize);
        return Result.success(page);
    }

}