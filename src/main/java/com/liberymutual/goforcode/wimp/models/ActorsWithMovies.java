package com.liberymutual.goforcode.wimp.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorsWithMovies extends Actor {

	@JsonProperty
	public List<Movie> noReallyMovies() {
		return getMovies();
		
	}
}
