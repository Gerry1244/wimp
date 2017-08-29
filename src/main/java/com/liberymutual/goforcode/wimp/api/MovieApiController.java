package com.liberymutual.goforcode.wimp.api;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.liberymutual.goforcode.wimp.models.Movie;
import com.liberymutual.goforcode.wimp.repositories.MovieRepository;

@RestController
@RequestMapping("/api/movies")

public class MovieApiController {

	private MovieRepository movieRepo;

	public MovieApiController(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;

		movieRepo.save(new Movie("Jaws", "AAA", 999999l));
		movieRepo.save(new Movie("Halloween", "BBB", 999999L));
		movieRepo.save(new Movie("Midnight Run", "CCC", 8888888l));
		movieRepo.save(new Movie("Final Countdown", "DDDD", 777777l));

	}

	@GetMapping("")
	public List<Movie> getAll() {
		return movieRepo.findAll();
	}

	@GetMapping("{id}")
	public Movie getOne(@PathVariable long id) throws StuffNotFoundException {
		Movie movie = movieRepo.findOne(id);
		if (movie == null) {
			throw new StuffNotFoundException();
		}
		return movie;
	}

	@DeleteMapping("{id}")
	public Movie delete(@PathVariable long id) {
		try {
			Movie movie = movieRepo.findOne(id);
			movieRepo.delete(id);
			return movie;
		} catch (EmptyResultDataAccessException erd) {
			return null;

		}

	}

	@PostMapping("")
	public Movie create(@RequestBody Movie movie) {
		movieRepo.save(movie);
		return movieRepo.save(movie);
	}

	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable long id) {
		movie.setId(id);
		return movieRepo.save(movie);
	}
	
	

}