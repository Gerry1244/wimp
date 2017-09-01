package com.libertymutual.goforcode.wimp.api;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
		movie.setId(1L);

		// Act
	//	Movie actual = .getId();

		// Assert
		assertThat(movie.getId()).isEqualTo(1L);
	}
	
	@Test
	public void test_getTitle_and_SetTitle() {
		//arrange
		movie.getTitle();
		
		//Act
		
		
		
	}

}