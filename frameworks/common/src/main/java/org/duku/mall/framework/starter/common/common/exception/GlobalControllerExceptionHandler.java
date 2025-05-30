package org.duku.mall.framework.starter.common.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.duku.mall.framework.starter.convention.exception.ServiceException;
import org.duku.mall.framework.starter.common.common.enums.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
    /**
     * 异常处理长度返回，防止返回过长
     */
    static   Integer  MAX_LENGTH=200;


    /**
     * 自定义异常处理
     * @param request
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultMessage<Object> handleServiceException(HttpServletRequest request, final Exception e, HttpServletResponse response) {


        //如果是自定义异常，则获取异常，返回自定义错误消息
        if (e instanceof ServiceException) {
            ServiceException serviceException = ((ServiceException) e);
            ResultCode resultCode = (ResultCode) serviceException.getResultCode();

            Integer code = null;
            String message = null;

            if (resultCode != null) {
                code = resultCode.code();
                message = resultCode.message();
            }
            //如果有扩展消息，则输出异常中，跟随补充异常
            if (!serviceException.getMsg().equals(ServiceException.DEFAULT_MESSAGE)) {
                message += ":" + serviceException.getMsg();
            }

            // 对一些特殊异常处理，不再打印error级别的日志
            assert serviceException.getResultCode() != null;
            if (serviceException.getResultCode().equals(ResultCode.DEMO_SITE_EXCEPTION)) {
                log.debug("[DEMO_SITE_EXCEPTION]:{}", serviceException.getResultCode().message(), e);
                return ResultUtil.error(code, message);
            }
            if (serviceException.getResultCode().equals(ResultCode.USER_AUTH_EXPIRED)) {
                log.debug("403 :{}", serviceException.getResultCode().message(), e);
                return ResultUtil.error(code, message);
            }


            log.error("全局异常[ServiceException]:{}-{}", serviceException.getResultCode().code(), serviceException.getResultCode().message(), e);
            return ResultUtil.error(code, message);

        } else {

            log.error("全局异常[ServiceException]:", e);
        }

        //默认错误消息
        String errorMsg = "服务器异常，请稍后重试";
        if (e != null && e.getMessage() != null && e.getMessage().length() < MAX_LENGTH) {
            errorMsg = e.getMessage();
        }
        return ResultUtil.error(ResultCode.ERROR.code(), errorMsg);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultMessage<Object> runtimeExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {

        log.error("全局异常[RuntimeException]:", e);

        return ResultUtil.error(ResultCode.ERROR);
    }

    //   /**
//    * 通用的接口映射异常处理方
//    */
//   @Override
//   protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//       if (ex instanceof MethodArgumentNotValidException) {
//           MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
//           return new ResponseEntity<>(new ResultUtil<>().setErrorMsg(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
//           status);
//       }
//       if (ex instanceof MethodArgumentTypeMismatchException) {
//           MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
//           logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
//                   + ",信息：" + exception.getLocalizedMessage());
//           return new ResponseEntity<>(new ResultUtil<>().setErrorMsg("参数转换失败"), status);
//       }
//       ex.printStackTrace();
//       return new ResponseEntity<>(new ResultUtil<>().setErrorMsg("未知异常，请联系管理员"), status);
//   }


    /**
     * bean校验未通过异常处理
     * @param request
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultMessage<Object> validExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {

        BindException exception = (BindException) e;
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        // 错误消息处理
        try {
            if (!fieldErrors.isEmpty()) {
                return ResultUtil.error(ResultCode.PARAMS_ERROR.code(),
                        fieldErrors.stream()
                                .map(FieldError::getDefaultMessage) // 获取每个对象的名称字段
                                .collect(Collectors.joining(", ")));
            }
            return ResultUtil.error(ResultCode.PARAMS_ERROR);
        } catch (Exception ex) {
            return ResultUtil.error(ResultCode.PARAMS_ERROR);
        }
    }

    /**
     * bean校验未通过异常
     *
     * @see javax.validation.Valid
     * @see org.springframework.validation.Validator
     * @see org.springframework.validation.DataBinder
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultMessage<Object> constraintViolationExceptionHandler(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        ConstraintViolationException exception = (ConstraintViolationException) e;
        return ResultUtil.error(ResultCode.PARAMS_ERROR.code(), exception.getMessage());
    }

}
