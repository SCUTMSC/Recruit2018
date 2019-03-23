package com.leyou.scm.common.advice;

import com.leyou.scm.common.enums.ExceptionEnum;
import com.leyou.scm.common.exception.ScmException;
import com.leyou.scm.common.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ScmException.class)
    public ResponseEntity<ExceptionResult> handleException(ScmException e){
        ExceptionEnum em = e.getExceptionEnum();
        return ResponseEntity.status(em.getCode()).body(new ExceptionResult(em));
    }
}
