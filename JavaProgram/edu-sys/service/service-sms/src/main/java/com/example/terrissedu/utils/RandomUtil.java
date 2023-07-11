package com.example.terrissedu.utils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author Terriss
 * @time 2023-07-06 15:07:32
 * @description TODO
 */
public class RandomUtil {

    private static final Random random = new Random();

    private static final DecimalFormat fourFormat = new DecimalFormat("0000");

    public static String getCode() {
        return fourFormat.format(random.nextInt(10000));
    }
}
