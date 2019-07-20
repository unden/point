package com.dlr.point.dto;

import lombok.Data;

@Data
public class PointMqMessage {

    private long id;

    private long continuousCheckInDays;

}
