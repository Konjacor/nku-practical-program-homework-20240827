package com.example.controller;

import com.example.common.Result;
import com.example.entity.ChatGroup;
import com.example.service.ChatGroupService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 聊天组前端操作接口
 **/
@Api(tags = "聊天组前端操作接口")
@RestController
@RequestMapping("/chatGroup")
public class ChatGroupController {

    @Resource
    private ChatGroupService chatGroupService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "chatGroup",value = "聊天组信息",required = true)
    @ApiOperation(value = "新增聊天组")
    public Result add(@RequestBody ChatGroup chatGroup) {
        chatGroupService.add(chatGroup);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "聊天组id",required = true)
    @ApiOperation(value = "根据id删除聊天组")
    public Result deleteById(@PathVariable Integer id) {
        chatGroupService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个聊天组id",required = true)
    @ApiOperation(value = "根据id批量删除聊天组")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        chatGroupService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "chatGroup",value = "修改后的聊天组信息",required = true)
    @ApiOperation(value = "修改聊天组")
    public Result updateById(@RequestBody ChatGroup chatGroup) {
        chatGroupService.updateById(chatGroup);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "想要查询的聊天组的id",required = true)
    @ApiOperation(value = "根据id查询聊天组信息")
    public Result selectById(@PathVariable Integer id) {
        ChatGroup chatGroup = chatGroupService.selectById(id);
        return Result.success(chatGroup);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "chatGroup",value = "查询条件",required = false)
    @ApiOperation(value = "查询满足条件（若有）的所有聊天组信息")
    public Result selectAll(ChatGroup chatGroup) {
        List<ChatGroup> list = chatGroupService.selectAll(chatGroup);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="chatGroup", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询满足条件（若有）的聊天组信息")
    public Result selectPage(ChatGroup chatGroup,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ChatGroup> page = chatGroupService.selectPage(chatGroup, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 聊天列表
     */
    @GetMapping("/selectUserGroup")
    @ApiOperation(value = "获取用户的聊天组列表")
    public Result selectUserGroup() {
        List<ChatGroup> chatGroupList = chatGroupService.selectUserGroup();
        return Result.success(chatGroupList);
    }

}