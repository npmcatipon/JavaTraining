package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	 // Start server on port 4567 (default)
        port(4567);
        
        EntityTransaction tx = em.getTransaction();
        
        // add routes here

        // Get Profile List
        get("/movies", (req,res) -> {
        	res.type("application/json");
        	
        	List<Movie> response = movieRepository.findAll();
        	
        	return JsonUtil.toJson(response);
        });
        
        // Create Profile List
        post("/movies", "application/json", (req,res) -> {
        	res.type("application/json");
        	
        	tx.begin();
        	
        	Movie movie = JsonUtil.fromJson(req.body(), Movie.class);
        	System.out.println(movie.toString());
        	movieRepository.save(movie);
        	tx.commit();
        	return JsonUtil.toJson(movie);
        });
        
        em.clear();
        em.refresh(tx);
    }
    
    

}
