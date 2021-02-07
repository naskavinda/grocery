package com.grocery.inventory.Utils;

import java.util.UUID;

public final class CommonFunction {

    public static final String CORRELATION_ID = "correlationId";

    private CommonFunction() {
    }

    public static String correlationId(){
        return UUID.randomUUID().toString();
    }
}
