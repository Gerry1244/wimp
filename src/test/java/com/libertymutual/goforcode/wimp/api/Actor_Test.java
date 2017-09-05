package com.libertymutual.goforcode.wimp.api;


import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.libertymutual.goforcode.wimp.models.Actor;
import com.libertymutual.goforcode.wimp.models.Movie;

public class Actor_Test {
	private Actor actor;     

	@Before
	public void setUp() {
		actor = new Actor();
	}

	@Test
	public void test_getid_and_setid() {
		// arrange
		actor.setId(22L);

		// Act
		Long actual = actor.getId();

		// Assert
		assertThat(actor.getId()).isEqualTo(22L);
	}
	
	@Test
	public void test_getFirstName_and_setFirstName() {
		// arrange
		actor.setFirstName("Gene");

		// Act
		String actual = actor.getFirstName();

		// Assert
		assertThat(actor.getFirstName()).isEqualTo("Gene");
	}
	
	@Test
	public void test_getLastName_and_setLastName() {
		// arrange
		actor.setLastName("Hackman");

		// Act
		String actual = actor.getLastName();

		// Assert
		assertThat(actor.getLastName()).isEqualTo("Hackman");
	}
	@Test
	public void test_getMovies_and_setMovies() {
		// arrange
		List<Movie> movies = new ArrayList<Movie>();
		actor.setMovies(movies);
		
		// Act
		List<Movie> actual = actor.getMovies();

		// Assert
		assertThat(actual).isSameAs(movies);
	}
	
	@Test
	public void test_getActiveSinceYear_and_setActiveSinceYear() {
		// arrange
		actor.setActiveSinceYear(1972L);

		// Act
		Long actual = actor.getActiveSinceYear();

		// Assert
		assertThat(actor.getActiveSinceYear()).isEqualTo(1972L);
	}
	
//	@Test
//	public void test_getBirthDate_and_setBirthDate() {
//		// Arrange
//		actor.setBirthDate(new Date(Date.parse("04/23/1945")));
//		
//		// Act
//		Date birthDate = actor.getBirthDate();
//		
//		// Assert
//		assertThat(birthDate).isEqualTo(new Date(Date.parse("04/23/1945")));
//	}
	
	
}