package ge.ibsu.demo.services;

import ge.ibsu.demo.entities.Film;
import ge.ibsu.demo.repositories.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    private final FilmRepository filmRepo;
    public FilmService(FilmRepository filmRepository) {

        this.filmRepo = filmRepository;
    }
    public Page<Film> searchFilms(String title, String description, Integer releaseYear, Integer languageId, Pageable pageable) {
        return filmRepo.findAllFilms(title, description, releaseYear, languageId, pageable);
    }
}
