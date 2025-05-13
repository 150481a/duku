package org.duku.mall.framework.starter.common.modules.good.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.good.entity.enums.GoodsWordsTypeEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;

@Data
@TableName("li_goods_words")
@ApiModel(value = "商品关键字")
@NoArgsConstructor
public class GoodsWords extends BaseEntity {

    private static final long serialVersionUID = 5709806638518675229L;

    /**
     * 商品关键字
     */
    @ApiModelProperty(value = "商品关键字")
    private String words;

    /**
     * 全拼音
     */
    @ApiModelProperty(value = "全拼音")
    private String wholeSpell;

    /**
     * 缩写
     */
    @ApiModelProperty(value = "缩写")
    private String abbreviate;

    /**
     * @see  GoodsWordsTypeEnum
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;
}
