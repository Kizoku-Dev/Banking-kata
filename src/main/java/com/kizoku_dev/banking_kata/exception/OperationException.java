package com.kizoku_dev.banking_kata.exception;

public class OperationException extends Exception {

    public static final String NOT_ENOUGH_MONEY = "Balance is not sufficient to perform the withdrawal.";
    public static final String ZERO_VALUE = "You can't perform a %s of 0.";

    public OperationException(String message) {
        super(message);
    }
}
