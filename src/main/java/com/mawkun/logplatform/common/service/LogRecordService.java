package com.mawkun.logplatform.common.service;

import com.mawkun.logplatform.common.annotation.LogRecord;

public class LogRecordService {

    @LogRecord(context = "修改订单地址，从“#oldAddress”,修改到“#request.address”",
                operator = "#request.userName", bizNo="#request.deliveryOrderNo")
    public void modifyAddress(String request, String oldAddress) {
        //更新派送信息，电话，收件人，地址
    }
}
