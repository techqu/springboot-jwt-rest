package com.quguang.springbootjwtdemo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import lombok.Data;

/**
 *
 * 接口最终返回对象
 */

@Data
public class ResultResponse {
//    private BaseErrorType error;
    private Boolean ok = true;
    private String errorCode;
    private String errorMsg;
    private Object data;


    public ResultResponse() {
    }

//    public String toJson() {
//        if (null != this.error) {
//            this.ok = false;
//            this.errorCode = error.getCode();
//            this.errorMsg = errorMsg == null ? error.getMessage() : errorMsg;
//        }
//        SimplePropertyPreFilter filter = new MyPropertyPreFilter(this.getClass(), "error");
//        return JSON.toJSONString(this, filter, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.UseISO8601DateFormat);
//    }

   /**
     * 创建 rest 返回对象
     *
     * @return
     */

    public static ResultResponse createResultResponse() {
        return new ResultResponse();
    }

   /**
     * 创建 rest返回对象
     *
     * @param errorType
     * @return
     */

    public static ResultResponse createResultResponse(BaseErrorType errorType) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setErrorMsg(errorType.getMessage());
        resultResponse.setErrorCode(errorType.getCode());
        return resultResponse;
    }



    public static ResultResponse createResultResponse(Object data) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setOk(true);
        resultResponse.setData(data);
        return resultResponse;
    }
    public static ResultResponse createResultResponse(String code ,String msg) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setErrorMsg(msg);
        resultResponse.setErrorCode(code);
        return resultResponse;
    }


}
