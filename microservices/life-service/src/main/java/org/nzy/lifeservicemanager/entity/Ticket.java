package org.nzy.lifeservicemanager.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "ticket")
public class Ticket {
    @TableId(value = "ticket_id")
    private long ticketId;
    private String fromCity;
    private String reachCity;
    private Date startTime;
    private Date reachTime;
    private float price;
    private String type;
    private String fromAirport;
    private String reachAirport;
    private int count;


}
