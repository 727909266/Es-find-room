package com.huhaoran.esproject.vo;

import com.huhaoran.esproject.enums.ResultEnum;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    @NonNull
    private int code;
    @NonNull
    private String message;
    private Object data;
    private boolean more;

    public static ApiResponse ofMessage(int code, String msg) {
        return new ApiResponse(code, msg);
    }
    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data, false);
    }
    public static ApiResponse ofResultEnum(ResultEnum resultEnum) {
        return new ApiResponse(resultEnum.getCode(), resultEnum.getMsg());
    }
}
