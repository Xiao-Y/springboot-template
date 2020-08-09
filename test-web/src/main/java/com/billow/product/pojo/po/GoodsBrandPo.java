package com.billow.product.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.billow.mybatis.pojo.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 品牌表
 * </p>
 *
 * @author billow
 * @since 2020-08-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("p_goods_brand")
@ApiModel(value = "GoodsBrandPo对象", description = "品牌表")
public class GoodsBrandPo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "分类排序")
    private Long brandSort;


}
