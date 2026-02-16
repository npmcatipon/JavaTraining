package ph.com.bpi.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import ph.com.bpi.training.controller.MovieController;
import ph.com.bpi.training.service.MovieService;
import ph.com.bpi.training.util.EntityManagerUtil;

import static spark.Spark.*;


public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	 
    public static void main(String[] args) {
    	// Initialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
        MovieService movieService = new MovieService(em);
    	
    	 // Start server on port 4567 (default)
        port(4567);
        
        // add routes here
        MovieController movieController = new MovieController(movieService);
        
        movieController.registerRoutes();
        
        logger.info("Server started at port {}.", port());
    }
    
    

}
