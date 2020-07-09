package pl.skrzypekjan.aopsample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skrzypekjan.aopsample.aspect.SendEmail;
import pl.skrzypekjan.aopsample.model.Film;
import pl.skrzypekjan.aopsample.service.FilmService;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<Film>> getFilms(){
        return new ResponseEntity<>(filmService.findAllFilms(), HttpStatus.OK);
    }

    @PostMapping
    @SendEmail
    public ResponseEntity addFilm(@RequestBody Film film){
        boolean isAdded = filmService.addFilm(film);
        if (isAdded){
            return new ResponseEntity<>(film, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
