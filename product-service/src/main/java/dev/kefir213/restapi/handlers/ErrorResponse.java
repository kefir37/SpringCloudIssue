package dev.kefir213.restapi.handlers;

import java.util.Map;

public record ErrorResponse(
        Map<String,String> errors
) {
}
