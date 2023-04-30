package com.klinnovations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.klinnovations.request.Passenger;
import com.klinnovations.response.Ticket;
import com.klinnovations.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	
	@GetMapping("/get-ticket")
	public String getTicketForm(@RequestParam  Integer ticketNum, Model model) {
		
	    Ticket ticketByNum = service.getTicketByNum(ticketNum);
		model.addAttribute("ticket",  ticketByNum);
	
		return "ticket-form";
	
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		
		return "ticket-form";
		
	}
	 
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger")  Passenger passenger, Model model) {
		model.addAttribute("passenger", new Passenger());
		Ticket ticket = service.bookTicket(passenger);
		//System.out.println(passenger);
		model.addAttribute("msg", "Your Ticket Booked With Id :"+ticket.getTicketNum());
		return "index";
		
		
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		
		
		return "index";
		
	}
 
	
}
