package org.duku.mall.framework.starter.common.modules.file.entity.dto;

import com.alipay.api.internal.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.distributedid.toolkit.DateUtil;
import org.duku.mall.framework.starter.common.common.vo.PageVO;

import java.util.Calendar;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileOwnerDTO extends PageVO {

    @ApiModelProperty(value = "拥有者id")
    private String ownerId;

    @ApiModelProperty(value = "拥有者名称")
    private String ownerName;

    @ApiModelProperty(value = "用户类型")
    private String userEnums;

    @ApiModelProperty(value = "原文件名")
    private String name;

    @ApiModelProperty(value = "存储文件名")
    private String fileKey;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "文件夹ID")
    private String fileDirectoryId;

    @ApiModelProperty(value = "起始日期")
    private String startDate;

    @ApiModelProperty(value = "结束日期")
    private String endDate;

    public Date getConvertStartDate() {
        if (StringUtils.isEmpty(startDate)) {
            return null;
        }
        return DateUtil.toDate(startDate, DateUtil.STANDARD_DATE_FORMAT);
    }

    public Date getConvertEndDate() {
        if (StringUtils.isEmpty(endDate)) {
            return null;
        }
        //结束时间等于结束日期+1天 -1秒，
        Date date = DateUtil.toDate(endDate, DateUtil.STANDARD_DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        calendar.set(Calendar.SECOND, -1);
        return calendar.getTime();
    }
}
