package org.duku.mall.framework.starter.common.modules.page.entity.dos;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.common.utils.StringUtils;
import org.duku.mall.framework.starter.common.modules.page.entity.enums.PageEnum;
import org.duku.mall.framework.starter.common.mybatis.BaseEntity;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.convention.enums.SwitchEnum;

@Data
@TableName("li_page_data")
@ApiModel(value = "页面数据DO")
@NoArgsConstructor
public class PageData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页面名称")

    private String name;

    @ApiModelProperty(value = "页面数据")
    private String pageData;

    /**
     * @see SwitchEnum
     */
    @ApiModelProperty(value = "页面开关状态", allowableValues = "OPEN,CLOSE")
    private String pageShow;

    /**
     * @see PageEnum
     */
    @ApiModelProperty(value = "页面类型", allowableValues = "INDEX,STORE,SPECIAL")
    private String pageType;

    /**
     * @see ClientTypeEnum
     */
    @ApiModelProperty(value = "客户端类型", allowableValues = "PC,H5,WECHAT_MP,APP")
    private String pageClientType;

    @ApiModelProperty(value = "值")
    private String num;

    public PageData(String name, String pageClientType, String pageData, String num) {
        this.name = name;
        this.pageClientType = pageClientType;
        this.pageData = pageData;
        this.num = num;
        this.pageShow = SwitchEnum.CLOSE.name();
        this.pageType = PageEnum.STORE.name();
    }

    public String getPageData() {
        if (StringUtils.isNotEmpty(pageData)) {
            return HtmlUtil.unescape(pageData);
        }
        return pageData;
    }
}
