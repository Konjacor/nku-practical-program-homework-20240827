package com.example.controller;

import com.example.common.Result;
import com.example.entity.Likes;
import com.example.service.LikesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "收藏操作接口")
@RestController
@RequestMapping("/likes")
public class LikesController {

    @Resource
    LikesService likesService;

    @PostMapping("/add")
    @ApiImplicitParam(name = "likes",value = "收藏信息增加",required = true)
    @ApiOperation(value = "收藏信息增加")
    public Result add(@RequestBody Likes likes) {
        likesService.add(likes);
        return Result.success();
    }

}
