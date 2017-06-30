package com.gionee.nfcPay.vo.req.union.notify;

import com.gionee.nfcPay.vo.req.union.BaseUnionReqVo;

/**
 * @author: qiancc
 * 2017年06月28日
 */
public class CardInfoChangeOperationResultNotifyReqVo extends BaseUnionReqVo {

    /**
     * 事件名称
     */
    private String event;

    /**
     * 设备卡PAN别名
     */
    private String virtualCardRefId;

    /**
     * 操作结果
     */
    private String result;

    /**
     * 任务流水号
     */
    private String taskId;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getVirtualCardRefId() {
        return virtualCardRefId;
    }

    public void setVirtualCardRefId(String virtualCardRefId) {
        this.virtualCardRefId = virtualCardRefId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
