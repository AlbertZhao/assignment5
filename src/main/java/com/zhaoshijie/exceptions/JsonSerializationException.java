package com.zhaoshijie.exceptions;

/**
 * Demo class
 *
 * @author Zhao shijie
 * @date 2019/08/12
 */
public class JsonSerializationException extends RuntimeException {

    private transient Object target;

    public JsonSerializationException(Throwable cause) {
        super("JSON serialization failed.", cause);
    }

    public JsonSerializationException(Throwable cause, Object obj) {
        this(cause);
        this.target = obj;
    }

    public Object getTarget() {
        return this.target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String getMessage() {
        return String.format("Unable to serialize target object [%s] to JSON string. Cause[%s].", this.target, this.getCause());
    }
}
