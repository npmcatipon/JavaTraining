package ph.com.bpi.training.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import ph.com.bpi.training.model.Movie;

public class MovieRepository implements Repository<Movie, Long> {

    private final EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Movie save(Movie movie) {
        if (movie.getId() == null) {
            em.persist(movie);
        } else {
        	movie = em.merge(movie);
        }
        return movie;
    }
    
    public List<Movie> saveAll(List<Movie> movies) {
    	for (Movie m : movies) {
    		if(m.getId() == null) {
    			em.persist(m);
    		} else {
    			em.merge(m);
    		}
    		
    		em.flush();
    		em.clear();
    		
    	}
    	
    	em.flush();
    	em.clear();
    	
    	return movies;
    }

    @Override
    public void delete(Movie entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public void deleteById(Long id) {
    	Movie movie = findById(id);

        if (movie != null) {
            delete(movie);
        }
    }

    @Override
    public Movie findById(Long id) {
        return em.find(Movie.class, id);
    }

    @Override
    public List<Movie> findAll() {
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

}
