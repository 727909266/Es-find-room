package com.huhaoran.esproject.utils;

import com.huhaoran.esproject.enums.CodeEnum;

public class CodeEnumUtil {
    public static <T extends CodeEnum> T getBycode(int code, Class<T> codeEnumClass) {
        for(T each: codeEnumClass.getEnumConstants()) {
            if(each.getCode() == code) {
                return each;
            }
        }
        return null;
    }
}
