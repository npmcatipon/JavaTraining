package ph.com.bpi.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ph.com.bpi.training.dto.MovieDTO;
import ph.com.bpi.training.model.Movie;
import ph.com.bpi.training.repository.MovieRepository;

public class MovieService {
	
	private MovieRepository movieRepository;
	
	private final EntityManager em;
	
	private final List<Movie> movieList = new ArrayList<>();
	
	public MovieService (EntityManager em) {
		this.em = em;
		this.movieRepository = new MovieRepository(em);
	}
	
	public List<Movie> getAllMovies() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		List<Movie> movies = movieRepository.findAll();
		
		tx.commit();
		
		return movies;
	}
	
	public List<MovieDTO> listMovie() {
		return movieList.stream()
				.map(x -> new MovieDTO(x))
				.collect(Collectors.toList());
	}
	
	public MovieDTO getMovieById(Long id) {
		return movieList.stream()
				.filter(movie -> movie.getId().equals(id))
				.findFirst()
				.map(x -> new MovieDTO(x))
				.orElse(null);
	}
	
	public List<MovieDTO> addMovie(MovieDTO movieDTO) {
		EntityTransaction tx = em.getTransaction();
		try {
			
			movieList.add(movieDTO.toEntity());
			
			tx.begin();
			
			movieList.forEach(movie -> {
				movieRepository.save(movie);
			});
			
			tx.commit();
			
			// TODO: sysout
			movieList.forEach(movie -> System.out.println(movie));
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			if (tx.isActive()) {
				throw e;
			} 
		} finally {
			em.clear();
		}
		
		return movieList.stream().
				map(x -> new MovieDTO(x))
				.collect(Collectors.toList());
		
			
	}
	
}
