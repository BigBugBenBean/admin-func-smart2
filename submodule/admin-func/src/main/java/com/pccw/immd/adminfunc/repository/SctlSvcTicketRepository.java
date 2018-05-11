package com.pccw.immd.adminfunc.repository;

/*
 *
 * Generated May 9, 2018 4:40:03 PM by Hibernate Tools 5.0.6.Final
 * FreeMarker 2.3.8
 */;

import com.pccw.immd.adminfunc.domain.SctlSvcTicketId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pccw.immd.adminfunc.domain.SctlSvcTicket;

@Repository ("sctlSvcTicketRepository.eservice2")
public interface SctlSvcTicketRepository extends JpaRepository<SctlSvcTicket,SctlSvcTicketId>{
}
