/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.bll.util;

import movierecsys.be.Movie;
import movierecsys.be.Rating;
import movierecsys.be.User;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pgn
 */
public class MovieRecommenderTest
{

    /**
     * Test of highAverageRecommendations method, of class MovieRecommender.
     */
    @Test
    public void testHighAverageRecommender()
    {
        MovieRecommender instance = new MovieRecommender();
        Movie mov1 = new Movie(1, 1998, "The Big Lebowski");
        Movie mov2 = new Movie(2, 1999, "Pirates of silicon valley");
        Movie mov3 = new Movie(3, 1994, "Shawshank redemption");
        Movie mov4 = new Movie(4, 2003, "The Room");
        Movie mov5 = new Movie(5, 1994, "Pulp Fiction");
        Movie mov6 = new Movie(6, 2015, "Steve Jobs");
        
        User userA = new User(1, "Stegger");
        User userB = new User(1, "Jeppe");
        User userC = new User(1, "Stig");
        
        Rating rOne = new Rating(mov1.getId(), userA.getId(), 5);
        Rating rTwo = new Rating(mov2.getId(), userA.getId(), 5);
        Rating rThree = new Rating(mov3.getId(), userA.getId(), 5);
        Rating rFour = new Rating(mov4.getId(), userA.getId(), -5);
        Rating rFive = new Rating(mov5.getId(), userA.getId(), 5);
        Rating rSix = new Rating(mov6.getId(), userA.getId(), -5);
        
        Rating r2One = new Rating(mov1.getId(), userB.getId(), 5); 
        Rating r2Two = new Rating(mov2.getId(), userB.getId(), 1); 
        Rating r2Three = new Rating(mov3.getId(), userB.getId(), 3); 
        Rating r2Four = new Rating(mov4.getId(), userB.getId(), 5); 
        Rating r2Five = new Rating(mov5.getId(), userB.getId(), -3); 
        Rating r2Six = new Rating(mov6.getId(), userB.getId(), -3); 
        
        Rating r3One = new Rating(mov1.getId(), userC.getId(), 5); 
        Rating r3Two = new Rating(mov2.getId(), userC.getId(), 1); 
        Rating r3Three = new Rating(mov3.getId(), userC.getId(), 3); 
        Rating r3Five = new Rating(mov5.getId(), userC.getId(), -3); 
        
        List<Rating> allRatings = new ArrayList<>();
        allRatings.add(rOne);
        allRatings.add(rTwo);
        allRatings.add(rThree);
        allRatings.add(rFour);
        allRatings.add(rFive);
        allRatings.add(rSix);
        allRatings.add(r2One);
        allRatings.add(r2Two);
        allRatings.add(r2Three);
        allRatings.add(r2Four);
        allRatings.add(r2Five);
        allRatings.add(r2Six);
        allRatings.add(r3One);
        allRatings.add(r3Two);
        allRatings.add(r3Three);
        allRatings.add(r3Five);
        
        List<Rating> currentUsersRatings = new ArrayList<>();
        currentUsersRatings.add(r3One);
        currentUsersRatings.add(r3Two);
        currentUsersRatings.add(r3Three);
        currentUsersRatings.add(r3Five);

        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(mov1);
        allMovies.add(mov2);
        allMovies.add(mov3);
        allMovies.add(mov4);
        allMovies.add(mov5);
        allMovies.add(mov6);

        Movie[] expected = { mov4, mov6 };
        List<Movie> results = instance.highAverageRecommendations(allMovies, allRatings, currentUsersRatings);
        
        Assertions.assertNotNull(results);
        Assertions.assertArrayEquals(expected, results.toArray());
    }

}