import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void emptyManager() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void addOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void addSeveralMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 1","Film 2","Film 3","Film 4","Film 5","Film 6"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test

    public void shouldFindLast(){
        MovieManager manager = new MovieManager(1);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 6"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

@Test
    public void shouldFindLastWithLimit(){
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 6","Film 5"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindLastNotLimit(){
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 6","Film 5","Film 4","Film 3","Film 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindLastAboveLimit() {
        MovieManager manager = new MovieManager(7);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
