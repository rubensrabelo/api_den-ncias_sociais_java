package com.platform.reporting.domain.embedded;

public record Address(
        String street,
        String neighborhood,
        String city,
        String state
) {}
