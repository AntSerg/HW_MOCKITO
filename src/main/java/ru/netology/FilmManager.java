package ru.netology;

public class FilmManager {
    private Film[] poster = new Film[0];
    private int outputLastFilms = 5;

    public FilmManager() {
    }

    public FilmManager(int outputLastFilms) {
        if (outputLastFilms >= 0) {
            this.outputLastFilms = outputLastFilms;
        }
    }

    public Film[] findAll() {
        return poster;
    }

    public int getOutputLastFilms() {
        return outputLastFilms;
    }

    public void add(Film film) {
        Film[] newPoster = new Film[poster.length + 1];
        for (int i = 0; i < poster.length; i++) {
            newPoster[i] = poster[i];
        }
        newPoster[newPoster.length - 1] = film;
        poster = newPoster;
    }

    public Film[] findLast() {
        int count = outputLastFilms <= poster.length ? outputLastFilms : poster.length;
        Film[] tmp = new Film[count];
        int i = 0, j = poster.length - 1;
        while (i < count) {
            tmp[i] = poster[j];
            i++;
            j--;
        }
        return tmp;
    }


}
