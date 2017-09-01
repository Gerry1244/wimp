package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;
import com.libertymutual.goforcode.wimp.repositories.ActorRepository;
import com.libertymutual.goforcode.wimp.repositories.MovieRepository;

public class ActorControllerTest {

	private ActorRepository actorRepo;
	private ActorApiController controller;

	@Before
	public void setUp() {
		actorRepo = mock(ActorRepository.class);
		controller = new ActorApiController(actorRepo);

	}

	@Test
	public void test_getAll_returns_all_Actors_returned_by_the_repo() {
		// arrange
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(new Actor());
		actors.add(new Actor());

		when(actorRepo.findAll()).thenReturn(actors);

		// Act
		List<Actor> actual = controller.getAll();

		// Assert
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.get(0)).isSameAs(actors.get(0));
		verify(actorRepo).findAll();

	}

	@Test
	public void test_getOne_returns_an_actor_from_Actor_repo() throws StuffNotFoundException {

		// arrange
		Actor TomCruise = new Actor();
		when(actorRepo.findOne(23233L)).thenReturn(TomCruise);

		// Act
		Actor actual = controller.getOne(23233L);

		// Assert
		assertThat(actual).isSameAs(TomCruise);
		verify(actorRepo).findOne(23233L);

	}

	@Test
	public void test_delete_returns_movie_deleted_when_found() {
		// arrange
		Actor actor = new Actor();
		when(actorRepo.findOne(4L)).thenReturn(actor);

		// Act
		Actor actual = controller.delete(4L);

		// assert
		assertThat(actor).isSameAs(actual);
		verify(actorRepo).delete(4L);
		verify(actorRepo).findOne(4L);

	}

	 @Test
	 public void test_create_returns_actor_created() {
	
	 //Arrange
	 Actor actor = new Actor();
	 when(actorRepo.save(actor)).thenReturn(actor);
	
	 //Act
	 Actor actual = controller.create(actor); 
	
	 //assert
	 assertThat(actor).isSameAs(actual); 
	 verify(actorRepo).save(actor); 
	
	} 

	@Test
	public void test_update_returns_actor_that_has_been_updated() {
	
		//Arrange
		Actor actor = new Actor();
		when(actorRepo.save(actor)).thenReturn(actor);
		
		//Act
		Actor actual = controller.update(actor, 62236L);
		
		//Assert
		assertThat(actor).isSameAs(actual);
		verify(actorRepo).save(actor);
		
	}
		
}
