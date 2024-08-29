package com.example.controller;

import cn.hutool.core.lang.Dict;
import com.example.common.Result;
import com.example.entity.Orders;
import com.example.service.OrdersService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 订单信息前端操作接口
 **/
@Api(tags = "订单信息前端操作接口")
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    /**
     * 新增
     */
    @PostMapping("/add")
    @ApiImplicitParam(name = "orders",value = "订单信息",required = true)
    @ApiOperation(value = "新增订单信息")
    public Result add(@RequestBody Orders orders) {
        ordersService.add(orders);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    @ApiImplicitParam(name = "id",value = "订单信息id",required = true)
    @ApiOperation(value = "根据id删除订单信息")
    public Result deleteById(@PathVariable Integer id) {
        ordersService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    @ApiImplicitParam(name = "ids",value = "多个订单信息id",required = true)
    @ApiOperation(value = "批量删除订单信息")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        ordersService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiImplicitParam(name = "orders",value = "修改订单信息",required = true)
    @ApiOperation(value = "修改订单信息")
    public Result updateById(@RequestBody Orders orders) {
        ordersService.updateById(orders);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    @ApiImplicitParam(name = "id",value = "查询的订单信息id",required = true)
    @ApiOperation(value = "根据订单信息id查询")
    public Result selectById(@PathVariable Integer id) {
        Orders orders = ordersService.selectById(id);
        return Result.success(orders);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    @ApiImplicitParam(name = "orders",value = "查询条件",required = false)
    @ApiOperation(value = "查询订单信息")
    public Result selectAll(Orders orders) {
        List<Orders> list = ordersService.selectAll(orders);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orders", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "分页查询的订单信息")
    public Result selectPage(Orders orders,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Orders> page = ordersService.selectPage(orders, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 卖家的分页查询
     */
    @GetMapping("/selectSalePage")
    @ApiImplicitParams({
            @ApiImplicitParam(name="orders", value = "查询条件", required = false),
            @ApiImplicitParam(name = "pageNum",value = "当前页数",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页记录数",required = true)
    })
    @ApiOperation(value = "卖家分页查询的订单信息")
    public Result selectSalePage(Orders orders,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Orders> page = ordersService.selectSalePage(orders, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询折线图数据
     */
    @GetMapping("/selectLine")
    @ApiOperation(value = "查询折线图数据", notes = "获取折线图数据")
    public Result selectLine() {
        List<Dict> dictList = ordersService.selectLine();
        return Result.success(dictList);
    }

    /**
     * 查询柱状图数据
     */
    @GetMapping("/selectBar")
    @ApiOperation(value = "查询柱状图数据", notes = "获取柱状图数据")
    public Result selectBar() {
        List<Dict> dictList = ordersService.selectBar();
        return Result.success(dictList);
    }


}