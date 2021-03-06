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
import com.libertymutual.goforcode.wimp.models.ActorsWithMovies;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;

@RestController
@RequestMapping("/api/actors")

public class ActorApiController {

	private ActorRepository actorRepo;

	public ActorApiController(ActorRepository actorRepo) {
		this.actorRepo = actorRepo; 

		actorRepo.save(new Actor("Robert", "Redford",1973L));
		actorRepo.save(new Actor("Tom", "Cruise",1977L));
		actorRepo.save(new Actor("Minnie", "Driver",1982L));
		actorRepo.save(new Actor("Gene", "Hackman",1999L)); 

	}
	
//	@PostMapping("{movieId}/actors")
//	public Movie associateAnActor(@PathVariable long movieId, @RequestBody Actor actor) {
//		Movie movie = movieRepo.findOne(movieId);
//		
//		return movie;
//		
//	}

	@GetMapping("")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}

	@GetMapping("{id}")
	public Actor getOne(@PathVariable long id) throws StuffNotFoundException {
		Actor actor = actorRepo.findOne(id);
		if (actor == null) {
			throw new StuffNotFoundException();
		}
	
//	ActorsWithMovies newActor = new ActorsWithMovies();
//	newActor.setActiveSinceYear(actor.getActiveSinceYear());
//	newActor.setBirthDate(actor.getBirthDate());
//	newActor.setMovies(actor.getMovies());
//	newActor.setFirstName(actor.getFirstName());
//	newActor.setLastName(actor.getLastName());
//	
//	return newActor;
	return actor;
}


	@DeleteMapping("{id}")
	public Actor delete(@PathVariable long id) {
		try {
			Actor actor = actorRepo.findOne(id); 
			actorRepo.delete(id);
			return actor;
		} catch (EmptyResultDataAccessException erd) {
			return null;  

		}

	}

	@PostMapping("")
	public Actor create(@RequestBody Actor actor) {
		return actorRepo.save(actor);
	}

	@PutMapping("{id}")
	public Actor update(@RequestBody Actor actor, @PathVariable long id) {
		actor.setId(id);
		return actorRepo.save(actor);
	}

}
