package com.picc.kata.potter;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PotterTest {
	@Test
	public void shouldReturn100(){
		int[] bookCart = {1,0,0,0,0};
		assertThat(Potter.calPrice(bookCart),is(100.0));
	}
	
	@Test
	public void shouldReturn190(){
		int[] bookCart = {1,1,0,0,0};
		assertThat(Potter.calPrice(bookCart),is(190.0));
	}
	
	@Test
	public void shouldReturn290(){
		int[] bookCart = {1,2,0,0,0};
		assertThat(Potter.calPrice(bookCart),is(290.0));
	}
}