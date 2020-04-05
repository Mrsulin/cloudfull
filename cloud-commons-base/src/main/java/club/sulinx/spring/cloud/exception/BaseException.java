package club.sulinx.spring.cloud.exception;

import lombok.Data;

/**
 * Title: 基础异常
 */
@Data
public class BaseException extends RuntimeException{

    private int  code;
    private String msg;

    public BaseException(String msg){
        super(msg);
        this.msg=msg;
    }
    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
