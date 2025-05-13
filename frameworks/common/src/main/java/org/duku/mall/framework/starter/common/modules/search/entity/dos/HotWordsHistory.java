package org.duku.mall.framework.starter.common.modules.search.entity.dos;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.mybatis.BaseIdEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("li_hot_words_history")
public class HotWordsHistory extends BaseIdEntity implements Comparable<HotWordsHistory>, Serializable {


    /**
     * 词
     */
    private String keywords;

    /**
     * 分数
     */
    private Integer score;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public HotWordsHistory(String keywords, Integer score) {
        this.keywords = keywords;
        this.score = score;
    }

    @Override
    public int compareTo(HotWordsHistory hotWordsHistory) {
        return hotWordsHistory.getScore() - this.score;
    }
}
