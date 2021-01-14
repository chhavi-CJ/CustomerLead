package org.codejudge.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.codejudge.sb.entity.Communication;
import org.codejudge.sb.entity.Lead;
import org.codejudge.sb.enums.Status;
import org.codejudge.sb.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLeadService {
	@Autowired
	private LeadRepository leadRepository;

	public Lead fetchLeads(Integer lead_id) {
		//List<Lead> leads = new ArrayList<>();
		
		try {
			System.out.println(leadRepository.findOne(lead_id));
			return leadRepository.findOne(lead_id);
		}catch(Exception e){
			System.out.println(leadRepository.findOne(lead_id));
			return leadRepository.findOne(lead_id);
		}
		
	}
	
	public String addLead(Lead lead) {
		lead.setStatus(Status.created);
		System.out.println("adding");
		try {
		leadRepository.save(lead);	
		return "valid";
		}
		catch(Exception e) {
			System.out.print("Unable to insert data in db: " + e.getMessage());
		   // e.printStackTrace();
		    return e.getMessage();
		}
		
	}

	public Boolean deleteLead(Integer lead_id) {
		try {
			leadRepository.delete(lead_id);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public Boolean updateLead(Integer lead_id, Lead lead) {
		//System.out.println("hi i am hereee-->" +lead);
		 // System.out.println("hi i am here-->" +leadRepository.findEmailById(lead_id));
		  if(leadRepository.exists(lead_id)) {
			  lead.setId(lead_id);
			  lead.setStatus(Status.created);
			 // leadRepository.updateLead(lead_id,lead.getFirst_name(),lead.getLast_name(),lead.getMobile(),lead.getEmail(),lead.getLocation_type(),lead.getLocation_string());
			 // lead.setFirst_name(lead.getFirst_name());
			  leadRepository.save(lead);
			  return true; 
		  } else
			  return false;
	}

	public Boolean markLead(Integer lead_id, Communication communication) {
		
		return null;
	}
	

}
