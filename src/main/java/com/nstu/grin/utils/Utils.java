package com.nstu.grin.utils;

import java.util.function.Consumer;
import java.util.function.Function;

public class Utils {
    public static <T, R> R safeCall(T data, Function<T, R> function){
        return data != null ? function.apply(data) : null;
    }

    public static <T> void safeAction(T data, Consumer<T> consumer){
        if (data != null){
            consumer.accept(data);
        }
    }
}
