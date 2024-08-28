package com.example.controller;

import com.example.common.Result;
import com.example.entity.ChatInfo;
import com.example.service.ChatInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 聊天信息前端操作接口
 **/
@Api(tags = "聊天信息前端操作接口")
@RestController
@RequestMapping("/chatInfo")
public class ChatInfoController {

    @Resource
    private ChatInfoService chatInfoService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "chatInfo",value = "聊天信息",required = true)
    @ApiOperation(value = "新增聊天信息")
    public Result add(@RequestBody ChatInfo chatInfo) {
        chatInfoService.add(chatInfo);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "聊天信息id",required = true)
    @ApiOperation(value = "根据id删除聊天信息")
    public Result deleteById(@PathVariable Integer id) {
        chatInfoService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个聊天信息id",required = true)
    @ApiOperation(value = "根据id批量删除聊天信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        chatInfoService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "chatInfo",value = "修改后的聊天信息",required = true)
    @ApiOperation(value = "修改聊天信息")
    public Result updateById(@RequestBody ChatInfo chatInfo) {
        chatInfoService.updateById(chatInfo);
        return Result.success();
    }

    @PutMapping("/updateRead/{chatUserId}")
    @ApiImplicitParam(name = "chatUserId",value = "聊天时对面用户的id",required = true)
    @ApiOperation(value = "修改聊天信息的状态为已读")
    public Result updateRead(@PathVariable Integer chatUserId) {
        chatInfoService.updateRead(chatUserId);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "想要查询的聊天信息的id",required = true)
    @ApiOperation(value = "根据id查询聊天信息")
    public Result selectById(@PathVariable Integer id) {
        ChatInfo chatInfo = chatInfoService.selectById(id);
        return Result.success(chatInfo);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "chatInfo",value = "查询条件",required = false)
    @ApiOperation(value = "查询满足条件（若有）的所有聊天信息")
    public Result selectAll(ChatInfo chatInfo) {
        List<ChatInfo> list = chatInfoService.selectAll(chatInfo);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="chatInfo", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询满足条件（若有）的聊天信息")
    public Result selectPage(ChatInfo chatInfo,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<ChatInfo> page = chatInfoService.selectPage(chatInfo, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询聊天记录
     */
    @GetMapping("/selectUserChat/{chatUserId}")
    @ApiImplicitParam(name = "chatUserId",value = "指定的聊天用户的id",required = true)
    @ApiOperation(value = "查询当前用户和指定聊天用户的所有聊天记录")
    public Result selectUserChat(@PathVariable Integer chatUserId) {
        List<ChatInfo> chatInfoList = chatInfoService.selectUserChat(chatUserId);
        return Result.success(chatInfoList);
    }

}