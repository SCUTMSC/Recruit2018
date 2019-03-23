package com.leyou.scm.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    TEAM_NAME_CONFLICT(201,"队伍名字已存在"),
    TEAM_INSERT_ERROR(201,"队伍新增失败"),
    TEAM_MATE_EXISTED(201,"队伍中有队员已经报名"),
    TEAM_MATE_INSERT_ERROR(201,"队伍中某名队员新增失败"),
    FILE_UPLOAD_ERROR(201,"文件上传失败"),
    INVALID_FILE_TYPE(201,"无效的文件类型"),
    TEAM_NOT_REGISTED(201,"所提交的队伍未报名或不存在"),
    TEAM_NOT_FOUND(201,"所查询的队伍未报名"),
    TEAM_NOT_MATCH(201,"队伍名字和队长信息不匹配")
    ;

    private int code;
    private String msg;

}
