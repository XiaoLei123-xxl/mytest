
package com.xusanjin.mytest.common.exception;

/**
 * @author Cang Jie
 * @ClassName: BizException
 * @Description: TODO
 * @date 2017年6月16日 下午12:55:22
 * <p>
 * 自定义异常基类
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -474750917914696393L;

    public BizException(String msg) {
        super(msg);
    }
}
