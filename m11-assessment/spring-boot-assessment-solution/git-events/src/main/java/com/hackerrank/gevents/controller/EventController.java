package com.hackerrank.gevents.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;

@RestController
public class EventController {
	private EventRepository eventRepository;
	
	public EventController(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	@PostMapping("/events")
	public ResponseEntity<Event> createEvent(@RequestBody Event evt) {
		Event e=eventRepository.saveAndFlush(evt);
		return new ResponseEntity<Event>(e,HttpStatus.CREATED);
	}
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvent() {
		List<Event> events=eventRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		return new ResponseEntity<List<Event>>(events,HttpStatus.OK);
	}
	@GetMapping("/repos/{repoId}/events")
	public ResponseEntity<List<Event>> getByRepoId(@PathVariable Integer repoId) {
		List<Event> evts=eventRepository.findByRepoId(repoId);
		Collections.sort(evts,(e1,e2)->e1.getId().compareTo(e2.getId()));
		if(evts.isEmpty()) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Event>>(evts,HttpStatus.OK);
	}
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<Event> getEventById(@PathVariable Integer eventId) {
		Optional<Event> op=eventRepository.findById(eventId);
		if(op.isPresent())
			return new ResponseEntity<Event>(op.get(),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}









