package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;

public class Movie_Test {
	private Movie movie;

	@Before
	public void setUp() {
		movie = new Movie();
	}

	@Test
	public void test_getid_and_setid() {
		// arrange
		movie.setId(22L);

		// Act
		Long actual = movie.getId();

		// Assert
		assertThat(movie.getId()).isEqualTo(22L);
	}

	@Test
	public void test_getTitle_and_setTitle() {
		// Arrange
		movie.setTitle("Jaws");

		// Act
		String actual = movie.getTitle();

		// Assert
		assertThat(movie.getTitle()).isEqualTo("Jaws");

	}

	@Test
	public void test_getBudget_and_setBudget() {
		// Arrange
		movie.setBudget(36376L);

		// Act
		Long actual = movie.getBudget();

		// Assert
		assertThat(movie.getBudget()).isEqualTo(36376L);

	}

	@Test
	public void test_getDistributor_and_setDistributor() {
		// Arrange
		movie.setDistributor("Miramar");

		// Act
		String actual = movie.getDistributor();

		// Assert
		assertThat(movie.getDistributor()).isEqualTo("Miramar");

	}

	@Test
	public void test_getActor_and_setActor() {
		// Arrange
		List<Actor> actors = new ArrayList<Actor>();
		movie.setActors(actors);

		// Act
		List<Actor> actual = movie.getActors();

		// Assert
		assertThat(actual).isSameAs(actors);

	}

	 @Test
		 public void test_getReleaseDate_and_setReleaseDate() {
		 // Arrange
			 movie.setReleaseDate(new Date(Date.parse("01/01/1900")));
		 
		 // Act
		 Date releaseDate = movie.getReleaseDate();
		
		 // Assert
		 assertThat(releaseDate).isEqualTo(new Date(Date.parse("01/01/1900")));
		 }

}