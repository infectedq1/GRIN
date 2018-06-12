package com.nstu.grin.utils;

import java.awt.*;
import java.util.Random;
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

    public static <T> void safeAction(T data, Consumer<T> consumer, Action alertAction){
        if (data != null){
            consumer.accept(data);
        } else {
            alertAction.call();
        }
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return new Color(
                random.nextInt((256 - 128)) + 128,
                random.nextInt((256 - 128) ) + 128,
                random.nextInt((256 - 128)) + 128
        );
    }
}
