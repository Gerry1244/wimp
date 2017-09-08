package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

import com.libertymutual.goforcode.wimp.StuffNotFoundException;
import com.libertymutual.goforcode.wimp.api.MovieApiController;
import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;





public class MovieApiControllerTest {

	private MovieRepository movieRepo;
	private ActorRepository actorRepo;
	private MovieApiController controller;

	@Before
	public void setUp() {
		movieRepo = mock(MovieRepository.class);
		actorRepo = mock(ActorRepository.class);
		controller = new MovieApiController(movieRepo, actorRepo);

	}

	@Test
	public void test_getAll_returns_all_Movies_returned_by_the_repo() {
		// arrange
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie());
		movies.add(new Movie());

		when(movieRepo.findAll()).thenReturn(movies);

		// Act
		List<Movie> actual = controller.getAll();

		// Assert
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.get(0)).isSameAs(movies.get(0));
		verify(movieRepo).findAll();

	}

	@Test
	public void test_getOne_returns_Movie_returned_from_repo() throws StuffNotFoundException {
		// arrange
		Movie OneFlewOverTheCuckoosNest = new Movie();
		when(movieRepo.findOne(26366325L)).thenReturn(OneFlewOverTheCuckoosNest);

		// Act
		Movie actual = controller.getOne(26366325L);

		// Assert
		assertThat(actual).isSameAs(OneFlewOverTheCuckoosNest);
		verify(movieRepo).findOne(26366325L);

	}

	@Test
	public void test_getOne_throws_stuffNotFound_when_no_movie_returned_from_movieRepo() {
		try {

			controller.getOne(1); 

			// This line of code SHOULD NOT run
			fail("The controller did not throw the StuffNotFOundException");
		} catch (StuffNotFoundException snfe) {
			
		}
	}

	@Test
	public void test_delete_returns_moviedeleted_when_found() {
		// arrange
		Movie movie = new Movie(); 
		when(movieRepo.findOne(3l)).thenReturn(movie);

		// Act
		Movie actual = controller.delete(3l);

		// assert
		assertThat(movie).isSameAs(actual);
		verify(movieRepo).delete(3l);
		verify(movieRepo).findOne(3l);
		
	} 
	
	@Test
	 public void test_create_returns_movie_created() {
	
	 //Arrange
	 Movie movie = new Movie();
	 when(movieRepo.save(movie)).thenReturn(movie); 
	
	 //Act
	 Movie actual = controller.create(movie); 
	
	 //assert
	 assertThat(movie).isSameAs(actual);
	 verify(movieRepo).save(movie);

	}

	@Test
	public void test_update_returns_movie_that_has_been_updated() {
	
		//Arrange
		Movie movie = new Movie();
		when(movieRepo.save(movie)).thenReturn(movie);
		
		//Act
		Movie actual = controller.update(movie, 54454L);
		
		//Assert
		assertThat(movie).isSameAs(actual);
		verify(movieRepo).save(movie);
		
	}

}
