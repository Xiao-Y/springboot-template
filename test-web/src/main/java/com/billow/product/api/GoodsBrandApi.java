package com.billow.product.api;

import com.billow.product.pojo.vo.GoodsBrandVo;
import com.billow.util.ConvertUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.billow.product.service.GoodsBrandService;
import com.billow.product.pojo.po.GoodsBrandPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author billow
 * @since 2020-08-08
 * @version v1.0
 */
@Slf4j
@Api(tags = {"GoodsBrandApi"},value = "品牌表")
@RestController
@RequestMapping("/goodsBrandApi")
public class GoodsBrandApi {

    @Autowired
    private GoodsBrandService goodsBrandService;

    @ApiOperation(value = "查询分页品牌表数据")
    @PostMapping(value = "/findListByPage")
    public IPage<GoodsBrandPo> findListByPage(@RequestBody GoodsBrandVo goodsBrandVo){
        return goodsBrandService.findListByPage(goodsBrandVo);
    }

    @ApiOperation(value = "根据id查询品牌表数据")
    @GetMapping(value = "/findById/{id}")
    public GoodsBrandVo findById(@PathVariable("id") String id){
        GoodsBrandPo po = goodsBrandService.getById(id);
        return ConvertUtils.convert(po, GoodsBrandVo.class);
    }

    @ApiOperation(value = "新增品牌表数据")
    @PostMapping(value = "/add")
    public GoodsBrandVo add(@RequestBody GoodsBrandVo goodsBrandVo){
        GoodsBrandPo po = ConvertUtils.convert(goodsBrandVo, GoodsBrandPo.class);
        goodsBrandService.save(po);
        return ConvertUtils.convert(po, GoodsBrandVo.class);
    }

    @ApiOperation(value = "删除品牌表数据")
    @DeleteMapping(value = "/delById/{id}")
    public boolean delById(@PathVariable("id") String id){
        return goodsBrandService.removeById(id);
    }

    @ApiOperation(value = "更新品牌表数据")
    @PutMapping(value = "/update")
    public GoodsBrandVo update(@RequestBody GoodsBrandVo goodsBrandVo){
        GoodsBrandPo po = ConvertUtils.convert(goodsBrandVo, GoodsBrandPo.class);
        goodsBrandService.updateById(po);
        return ConvertUtils.convert(po, GoodsBrandVo.class);
    }

    @ApiOperation("根据ID禁用品牌表数据")
    @PutMapping("/prohibitById/{id}")
    public boolean prohibitById(@PathVariable String id) {
        return goodsBrandService.prohibitById(id);
    }
}
