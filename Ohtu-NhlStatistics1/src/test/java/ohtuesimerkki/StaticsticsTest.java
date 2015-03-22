package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class StaticsticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void testValidSearch() {
        assertNotNull(stats.search("Semenko"));
    }

    @Test
    public void testInvalidSearch() {
        assertNull(stats.search("Semenka"));
    }

    @Test
    public void testValidTeam() {
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
    }

    @Test
    public void testInvalidTeam() {
        List<Player> players = stats.team("ADM");
        assertEquals(0, players.size());
    }

    @Test
    public void testValidTopScorers() {
        List<Player> players = stats.topScorers(stats.team("EDM").size());
        assertEquals(players.size(), players.size());
        players = stats.topScorers(-1);
        assertEquals(0, players.size());
    }
}
