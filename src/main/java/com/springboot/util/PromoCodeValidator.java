package com.springboot.util;

import java.util.Arrays;
import java.util.List;

public class PromoCodeValidator {

    public static void validatePromoCode(String promoCode) {
        List<String> promoCodes = Arrays.asList("jk45", "945h345", "345hnhlh", "jk23hjkj", "9283nhlsd");

        if(!promoCodes.contains(promoCode)) {
            throw new RuntimeException("Invalid Promo Code !! Please verify it again...");
        }
    }
}
