package org.nzy.lifeservicemanager.service;

import org.nzy.lifeservicemanager.entity.Ticket;

import java.util.List;

public interface TicketService {
    int addTicket(Ticket ticket);

    int editTicket(Ticket ticket);

    int removeTicket(long ticketId);

    List<Ticket> queryTicket(Ticket ticket);

    Ticket queryTicketById(long ticketId);
}
