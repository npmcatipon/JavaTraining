package ph.com.bpi.training.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

import ph.com.bpi.training.dto.MovieDTO;
import ph.com.bpi.training.dto.ResponseDTO;
import ph.com.bpi.training.service.MovieService;
import ph.com.bpi.training.util.JsonUtil;
import ph.com.bpi.training.util.ResponseStatus;

public class MovieController {
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	public void registerRoutes() {
		
		get("/check-connection", (req,res) -> {
			res.type("application/json");
			
			Map<String, String> response = new HashMap<>();
			
			response.put("status", "Server is running");
			
			return JsonUtil.toJson(response);
		});
		
		get("/movies", (req, res) -> {
			
			ResponseDTO<List <MovieDTO>> response = new ResponseDTO<>();
			res.type("application/json");
			
			response.setStatus(ResponseStatus.SUCCESS);
			response.setMessage("Retrieving list of movies");
			response.setData(this.movieService.listMovie());
			
			return JsonUtil.toJson(response);
		});
		
		post("/movies", (req,res) -> {
			
			ResponseDTO<MovieDTO> response = new ResponseDTO<>();
			
			if(req.body() == null || req.body().isBlank()) {
				response.setStatus(ResponseStatus.ERROR);
				response.setMessage("Payload cannot be blank");
				
				return JsonUtil.toJson(response);
			}
			MovieDTO movieDTO = new MovieDTO();
			
			movieDTO = JsonUtil.fromJson(req.body(), MovieDTO.class);
			List<MovieDTO> movie = this.movieService.addMovie(movieDTO);
			
			response.setStatus(ResponseStatus.SUCCESS);
			response.setMessage("Successfully added a new movie");
			response.setData(this.movieService.getMovieById(Long.valueOf(movie.size())));
			return JsonUtil.toJson(response);
		});
		
		
	}
}
