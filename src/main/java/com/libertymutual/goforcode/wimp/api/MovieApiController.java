package com.libertymutual.goforcode.wimp.api;

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

import com.libertymutual.goforcode.wimp.StuffNotFoundException;
import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/movies")
@Api(description = "Use this to get and create movies and add")
public class MovieApiController {

	private MovieRepository movieRepo;
	private ActorRepository actorRepo;

	public MovieApiController(MovieRepository movieRepo, ActorRepository actorRepo) {
		this.movieRepo = movieRepo;
		this.actorRepo = actorRepo; 

//		movieRepo.save(new Movie("Jaws", "AAA", 999999l));
//		movieRepo.save(new Movie("Halloween", "BBB", 999999L));
//		movieRepo.save(new Movie("Midnight Run", "CCC", 8888888l));
//		movieRepo.save(new Movie("Final Countdown", "DDDD", 777777l));

	}

	@ApiOperation(value = "${api.movie.associateActor}", notes = "You only need to POST the \"id\" of the actor, not the whole actor resource.")
	@PostMapping("{movieId}/actors")
	public Movie associateAnActor(@PathVariable long movieId, @RequestBody Actor actor) {
		Movie movie = movieRepo.findOne(movieId);
		actor = actorRepo.findOne(actor.getId());  
  
		movie.addActor(actor);
		movieRepo.save(movie);

		
		return movie; 
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
		
		return movieRepo.save(movie);
	}

	@PutMapping("{id}")
	public Movie update(@RequestBody Movie movie, @PathVariable long id) {
		movie.setId(id);
		return movieRepo.save(movie);
	}

}