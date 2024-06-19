package com.demoqa.enums;

import lombok.Getter;

public enum Endpoints {
    ALERT("/alerts"),
    BROWSER_WINDOWS("/browser-windows"),
    BUTTONS("/buttons"),
    FRAMES("/frames"),
    MENU("/menu"),
    PRACTICE_FORM("/automation-practice-form"),
    DYNAMIC_PROPERTIES("/dynamic-properties"),
    PROGRESS_BAR("/progress-bar"),
    SELECT_MENU("/select-menu"),
    TEXT_BOX("/text-box"),
    WEBTABLE("/webtables");

    @Getter
    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
