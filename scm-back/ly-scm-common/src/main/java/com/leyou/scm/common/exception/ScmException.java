package com.leyou.scm.common.exception;

import com.leyou.scm.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScmException extends RuntimeException{
    private ExceptionEnum exceptionEnum;

}
