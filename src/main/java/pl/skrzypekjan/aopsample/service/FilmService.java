package pl.skrzypekjan.aopsample.service;

import pl.skrzypekjan.aopsample.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> findAllFilms();

    boolean addFilm(Film film);

}
