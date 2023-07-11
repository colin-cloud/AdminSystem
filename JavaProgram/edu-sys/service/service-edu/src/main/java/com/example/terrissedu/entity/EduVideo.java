package com.example.terrissedu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduVideo对象", description="课程视频")
public class EduVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "视频ID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @ApiModelProperty(value = "课程ID")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long courseId;

    @ApiModelProperty(value = "章节ID")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long chapterId;

    @ApiModelProperty(value = "小节(视频)名称")
    private String title;

    @ApiModelProperty(value = "云端视频资源")
    private String videoSourceId;

    @ApiModelProperty(value = "原始文件名称")
    private String videoOriginalName;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @ApiModelProperty(value = "播放次数")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long playCount;

    @ApiModelProperty(value = "是否可以试听：0收费 1免费")
    private Integer isFree;

    @ApiModelProperty(value = "视频时长（秒）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long duration;

    @ApiModelProperty(value = "0未上传 1转码中  2正常")
    private Integer status;

    @ApiModelProperty(value = "视频源文件大小（字节）")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long size;

    @ApiModelProperty(value = "乐观锁")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT) // 创建时自动填充
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE) // 创建时自动填充
    private Date updateTime;
}
