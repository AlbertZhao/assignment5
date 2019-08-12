package com.zhaoshijie.exceptions;

/**
 * JsonDeserializationException class
 *
 * @author Zhao Shijie
 * @date 2019/08/12
 */
public class JsonDeserializationException extends RuntimeException{
    private transient Object target;

    private String jsonString;

    public JsonDeserializationException(Throwable cause) {
        super("JSON deserialization failed.", cause);
    }

    public JsonDeserializationException(Throwable cause, String jsonString) {
        this(cause);
        this.jsonString = jsonString;
    }

    public Object getTarget() {
        return this.target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String getMessage() {
        return String.format("Unable to deserialize Json string [%s] to Object. Cause[%s].", this.jsonString, this.getCause());
    }
}
