package com.hackerrank.weather.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {
	
	private WeatherRepository weatherRepository;
	
	
	public WeatherApiRestController(WeatherRepository weatherRepository) {
		super();
		this.weatherRepository = weatherRepository;
	}


	@PostMapping
	public ResponseEntity<Weather> createWeather(@RequestBody Weather w) {
		Weather weather=weatherRepository.saveAndFlush(w);
		return new ResponseEntity<Weather>(weather,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Weather>> getAllWeather(){
		List<Weather> all=weatherRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		return new ResponseEntity<List<Weather>>(all,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Weather> getWeather(@PathVariable Integer id) {
		Optional<Weather> op=weatherRepository.findById(id);
		if(op.isPresent())
			return new ResponseEntity<Weather>(op.get(),HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Weather> deleteWeather(@PathVariable Integer id) {
		Optional<Weather> op=weatherRepository.findById(id);
		if(op.isPresent()) {
			weatherRepository.delete(op.get());
			return new ResponseEntity<>(HttpStatusCode.valueOf(204));
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
















