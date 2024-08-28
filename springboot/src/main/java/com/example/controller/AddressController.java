package com.example.controller;

import com.example.common.Result;
import com.example.entity.Address;
import com.example.service.AddressService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 收货地址前端操作接口
 **/
@Api(tags = "用户地址后端操作接口")
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "用户地址信息", required = true),
            @ApiImplicitParam(name = "id", value = "用户地址编码", required = true),
            @ApiImplicitParam(name = "name", value = "用户联系地址", required = false),
            @ApiImplicitParam(name = "phone", value = "用户电话号码", required = false),
            @ApiImplicitParam(name = "userID", value = "用户编码", required = true),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true),
    })
    @ApiOperation(value = "添加用户地址")
    public Result add(@RequestBody Address address) {
        addressService.add(address);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id", value = "用户地址编码", required = true)
    @ApiOperation(value = "删除用户地址")
    public Result deleteById(@PathVariable Integer id) {
        addressService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids", value = "多个用户地址编码", required = true)
    @ApiOperation(value = "删除用户多个地址")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        addressService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址信息", required = true),
            @ApiImplicitParam(name = "id", value = "用户地址编码", required = true),
            @ApiImplicitParam(name = "name", value = "用户联系地址", required = true),
            @ApiImplicitParam(name = "phone", value = "用户电话号码", required = false),
            @ApiImplicitParam(name = "userID", value = "用户编码", required = true),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true),
    })
    @ApiOperation(value = "更新用户地址")
    public Result updateById(@RequestBody Address address) {
        addressService.updateById(address);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id", value = "用户地址编码", required = true)
    @ApiOperation(value = "选择用户地址")
    public Result selectById(@PathVariable Integer id) {
        Address address = addressService.selectById(id);
        return Result.success(address);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址信息", required = true),
            @ApiImplicitParam(name = "id", value = "用户地址编码", required = true),
            @ApiImplicitParam(name = "name", value = "用户联系地址", required = true),
            @ApiImplicitParam(name = "phone", value = "用户电话号码", required = false),
            @ApiImplicitParam(name = "userID", value = "用户编码", required = true),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true),
    })
    @ApiOperation(value = "选择用户所有地址")
    public Result selectAll(Address address) {
        List<Address> list = addressService.selectAll(address);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "address", value = "地址信息", required = true),
            @ApiImplicitParam(name = "id", value = "用户地址编码", required = true),
            @ApiImplicitParam(name = "name", value = "用户联系地址", required = true),
            @ApiImplicitParam(name = "phone", value = "用户电话号码", required = false),
            @ApiImplicitParam(name = "userID", value = "用户编码", required = true),
            @ApiImplicitParam(name = "userName", value = "用户姓名", required = true),
            @ApiImplicitParam(name = "pageNum", value = "用户地址当前页数", required = true),
            @ApiImplicitParam(name = "pageSize",value = "用户地址总页数",required = true)
    })
    @ApiOperation(value = "选择用户地址页数")
    public Result selectPage(Address address,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Address> page = addressService.selectPage(address, pageNum, pageSize);
        return Result.success(page);
    }

}