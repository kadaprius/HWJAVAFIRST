package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Film;
import ge.ibsu.demo.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Film> getAllFilms(String title, String description, Integer releaseYear, Integer languageId, Pageable pageable) {
        Page<Film> films = filmService.searchFilms(title, description, releaseYear, languageId, pageable);
        return films.getContent();
    }

}

