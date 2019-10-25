package org.nzy.lifeservicemanager.service.Impl;

import org.nzy.lifeservicemanager.dao.TicketMapper;
import org.nzy.lifeservicemanager.entity.Ticket;
import org.nzy.lifeservicemanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public int addTicket(Ticket ticket) {
        return ticketMapper.insert(ticket);
    }

    @Override
    public int editTicket(Ticket ticket) {
        return ticketMapper.updateById(ticket);
    }

    @Override
    public int removeTicket(long ticketId) {
        return ticketMapper.deleteById(ticketId);
    }

    @Override
    public List<Ticket> queryTicket(Ticket ticket) {
        return ticketMapper.selectList(null);
    }

    @Override
    public Ticket queryTicketById(long ticketId) {
        return ticketMapper.selectById(ticketId);
    }
}
