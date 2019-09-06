package com.manager.entry.common;

import com.manager.util.Message;

public class CommonException extends RuntimeException {

    private String message;

    private String code;

    private Message messageEnum;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public Message getMessageEnum() {
        return messageEnum;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CommonException(Message m) {
        super(m.getMessage(), null, false, false);
        this.messageEnum = m;
        this.message = m.getMessage();
        this.code = m.getCode();
    }
}
