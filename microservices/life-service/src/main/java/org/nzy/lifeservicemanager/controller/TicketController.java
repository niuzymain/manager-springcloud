package org.nzy.lifeservicemanager.controller;

import com.alibaba.fastjson.JSON;
import org.nzy.lifeservicemanager.entity.Ticket;
import org.nzy.lifeservicemanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/addticket")
    public Map<String, Object> addTicket(HttpServletRequest request) {
        Map<String, Object> resMap = new HashMap<>();
        Ticket ticket = JSON.parseObject(request.getParameter("jsonstr"), Ticket.class);
        int res = ticketService.addTicket(ticket);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "add fail");
        }
        return resMap;
    }

    @PostMapping("/editticket")
    public Map<String, Object> editTicket(HttpServletRequest request) {
        Map<String, Object> resMap = new HashMap<>();
        Ticket ticket = JSON.parseObject(request.getParameter("jsonstr"), Ticket.class);
        int res = ticketService.editTicket(ticket);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "edit fail");
        }
        return resMap;
    }

    @PostMapping("/removeticket")
    public Map<String, Object> removeTicket(long ticketid) {
        Map<String, Object> resMap = new HashMap<>();
        int res = ticketService.removeTicket(ticketid);
        if (res > 0) {
            resMap.put("success", true);
        } else {
            resMap.put("success", false);
            resMap.put("error", "delete fail");
        }
        return resMap;
    }

    @GetMapping("/listticket")
    public Map<String, Object> listTicket(HttpServletRequest request) {
        Map<String, Object> resMap = new HashMap<>();
        List<Ticket> ticketList = ticketService.queryTicket(null);
        resMap.put("data", ticketList);
        resMap.put("success", true);
        return resMap;
    }

    @GetMapping("/listticketbyid")
    public Map<String, Object> listTicketById(String ticketid) {
        Map<String, Object> resMap = new HashMap<>();
        Ticket ticket = ticketService.queryTicketById(Long.parseLong(ticketid));
        resMap.put("data", ticket);
        resMap.put("success", true);
        return resMap;
    }
}
