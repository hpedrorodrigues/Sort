package com.hpedrorodrigues;

public final class Logger {

    private Logger() {
    }

    public static void log(final String message, final Object... arguments) {
        System.out.println(String.format(message, arguments));
    }
}