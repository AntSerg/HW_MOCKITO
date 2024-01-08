package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FilmManagerTest {
    @Test
    public void add3FilmsInManagerAndFindAll() {
        FilmManager manager = new FilmManager();

        Film film1 = new Film("name1", "type1");
        Film film2 = new Film("name2", "type2");
        Film film3 = new Film("name3", "type3");

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);

        Film[] expected = new Film[]{film1, film2, film3};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "5, 5",
            "5, -10",
            "3, 3"
    })
    public void constructorWithParameterTest(int expected, int count) {

        FilmManager manager = new FilmManager(count);
        int actual = manager.getOutputLastFilms();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findLastFilmsPosterOverOutput() {
        FilmManager manager = new FilmManager(4);

        Film film0 = new Film("name0", "type0");
        Film film1 = new Film("name1", "type1");
        Film film2 = new Film("name2", "type2");
        Film film3 = new Film("name3", "type3");
        Film film4 = new Film("name4", "type4");
        Film film5 = new Film("name5", "type5");
        Film film6 = new Film("name6", "type6");
        Film film7 = new Film("name7", "type7");
        Film film8 = new Film("name8", "type8");
        Film film9 = new Film("name9", "type9");

        manager.add(film0);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);

        Film[] actual = manager.findLast();
        Film[] expected = {film9, film8, film7, film6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsPosterUnderOutput() {
        FilmManager manager = new FilmManager(9);

        Film film0 = new Film("name0", "type0");
        Film film1 = new Film("name1", "type1");
        Film film2 = new Film("name2", "type2");
        Film film3 = new Film("name3", "type3");
        Film film4 = new Film("name4", "type4");
        Film film5 = new Film("name5", "type5");

        manager.add(film0);
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        Film[] actual = manager.findLast();
        Film[] expected = {film5, film4, film3, film2, film1, film0};

        Assertions.assertArrayEquals(expected, actual);
    }
}
