package pl.skrzypekjan.aopsample.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.skrzypekjan.aopsample.model.Film;

import java.util.ArrayList;
import java.util.List;


@Service
public class FilmServiceImpl implements FilmService{

    public static long count = 1;
    private List<Film> filmList;


    public FilmServiceImpl() {
        filmList = new ArrayList<>();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addFilms(){
        filmList.add(new Film("Blade","New Line Cinema", 1998));
        filmList.add(new Film("Matrix","Warner Bros. Pictures", 1999));
        filmList.add(new Film("Queen of the Damned","Warner Bros. Pictures", 2002));
        filmList.add(new Film("Star Wars","Lucasfilm, 20th Century Fox", 1977));
    }

    @Override
    public List<Film> findAllFilms() {
        return filmList;
    }

    @Override
    public boolean addFilm(Film film) {
        film.setId(count);
        count++;
        return filmList.add(film);
    }
}
