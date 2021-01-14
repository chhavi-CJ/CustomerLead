package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.codejudge.sb.entity.Communication;
import org.codejudge.sb.entity.Lead;
import org.codejudge.sb.enums.Location_type;
import org.codejudge.sb.enums.Status;
import org.codejudge.sb.reponse.ComStatusResp;
import org.codejudge.sb.reponse.CreatedResp;
import org.codejudge.sb.reponse.EmptyJsonResponse;
import org.codejudge.sb.reponse.FailureResponse;
import org.codejudge.sb.reponse.SuccessResp;
import org.codejudge.sb.repository.LeadRepository;
import org.codejudge.sb.service.CustomerLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class AppController {

	@Autowired
	private CustomerLeadService customerleadService;
	
	@Autowired
	LeadRepository leadRepository;
	

    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }
    
    @GetMapping("/api/leads/{lead_id}")
    public ResponseEntity getLead(@PathVariable Integer lead_id) {
    	FailureResponse failureResponse;
    	Lead response= customerleadService.fetchLeads(lead_id);
    	//if(lead_id==null)
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailureResponse());
    	if(response!=null) { 
			  Lead lead = new Lead(response.getId(),response.getFirst_name(),response.getLast_name(),response.getMobile(),response.getEmail(),response.getLocation_type(),response.getLocation_string(),response.getStatus(),response.getCommunication());
			  return ResponseEntity.status(HttpStatus.CREATED).body(lead); 
			  }
	      return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
		   
    }
    
    @PostMapping("/api/leads")
    public ResponseEntity addLead(@RequestBody Lead lead) {
        String response=customerleadService.addLead(lead);
        if(response == "valid") {
        	CreatedResp createdResp = new CreatedResp(lead.getId(),lead.getFirst_name(),lead.getLast_name(),lead.getMobile(),lead.getEmail(),lead.getLocation_type(),lead.getLocation_string(),lead.getStatus());
        	return ResponseEntity.status(HttpStatus.CREATED).body(createdResp);            
        }
        FailureResponse failureResponse = new FailureResponse("failure","Please enter a valid response");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse);
    }
    
    @DeleteMapping("/api/lead/{lead_id}")
    public ResponseEntity deleteLead(@PathVariable Integer lead_id) {
    	System.out.println(lead_id);
        Boolean response=customerleadService.deleteLead(lead_id);
        if(response) {
        	SuccessResp successResp = new SuccessResp("Success");
        	return ResponseEntity.status(HttpStatus.CREATED).body(successResp); 
        }
        FailureResponse failureResponse = new FailureResponse("failure","Please enter a valid Id to delete");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse);
    }
    
	/*
	 * @PutMapping("/api/lead/{lead_id}") public ResponseEntity
	 * updateLead(@PathVariable Integer lead_id, @RequestBody Lead lead) {
	 * System.out.println(lead_id); Boolean
	 * response=customerleadService.updateLead(lead_id, lead); if(response) {
	 * SuccessResp successResp = new SuccessResp("Success"); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(successResp); }
	 * FailureResponse failureResponse = new
	 * FailureResponse("failure","Please enter a valid Id to delete"); return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failureResponse); }
	 */
    @PutMapping("/api/lead/{lead_id}")
    public ResponseEntity updateLead(@PathVariable Integer lead_id, @RequestBody Lead leaddetails) {
    	System.out.println(lead_id);
    	 Lead lead = leadRepository.findById(lead_id);
    	 if(lead==null)
    		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailureResponse("failure","Please enter a valid Id to update"));

         lead.setFirst_name(leaddetails.getFirst_name());
         lead.setLast_name(leaddetails.getLast_name());
         lead.setMobile(leaddetails.getMobile());
         lead.setEmail(leaddetails.getEmail());
         lead.setLocation_type(leaddetails.getLocation_type());
         lead.setLocation_string(leaddetails.getLocation_string());

         Lead updatedLead = leadRepository.save(lead);
         return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResp("Success"));
    }
    @PutMapping("/api/mark_lead/{lead_id}")
    public ResponseEntity markLead(@PathVariable Integer lead_id, @RequestBody Communication communication) {
    	 System.out.println(lead_id);
		 Lead lead = leadRepository.findById(lead_id);
		 if(lead==null)
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FailureResponse("failure","Please enter a valid Id to update"));
		 
		 lead.setCommunication(communication.getCommunication());
		 
		 leadRepository.save(lead);
		 return ResponseEntity.status(HttpStatus.CREATED).body(new ComStatusResp("created",communication.getCommunication()));
    }
}
