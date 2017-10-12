package com.baufest.bat.core.enums;

/**
 implements enumerated operations
 * Created by Miguel D'Alessio
 * on 11/10/2017.
 */
public enum LogType {

    INFO("INFO"),
    ERROR("ERROR"),
    FATAL("FATAL"),
    WARNING("WARNING"),
    SKIP("SKIP"),
    PASS("PASS"),
    START("START"),
    PREFIX(">>>");

    LogType(String element) {
        this.element = element;
    }

    private String element;

    public String element() {
        return element;
    }
}
