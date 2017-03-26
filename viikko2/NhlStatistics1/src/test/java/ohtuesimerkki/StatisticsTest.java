/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author merviaho
 */
public class StatisticsTest {
    
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
 
    Statistics stats;
    List<Player> players;

    @Before
    public void setUp(){
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
        players = readerStub.getPlayers();
        
    } 
    //****************testiSearch**************************************
    @Test
    public void testiSearch1(){
        assertEquals(null, stats.search("buu"));
    }
    @Test
    public void testiSearch2(){  
        Player kurri = players.get(2);
        assertEquals(kurri.getGoals(), stats.search("Kurri").getGoals());
    }
    @Test
    public void testiSearch3(){
        assertEquals("Kurri", stats.search("Kurri").getName());
    }
    
    @Test
    public void testiSearch4(){
        int a = players.get(0).getAssists();
        assertEquals(a, stats.search(players.get(0).getName()).getAssists());
    }
    @Test
    public void testiSearch5(){
        int a = players.get(0).getGoals();
        assertEquals(a, stats.search(players.get(0).getName()).getGoals());
    }
    @Test
    public void testiSearch6(){
        int a = players.get(0).getPoints();
        assertEquals(a, stats.search(players.get(0).getName()).getPoints());
    }
    @Test
    public void testiSearch7(){
        String a = players.get(0).getTeam();
        assertEquals(a, stats.search(players.get(0).getName()).getTeam());
    }
    @Test
    public void testiSearch8(){
        String a = players.get(0).getName();
        assertEquals(a, stats.search(players.get(0).getName()).getName());
    }
    @Test
    public void testiSearch9(){
        String a = players.get(0).toString();
        assertEquals(a, stats.search(players.get(0).getName()).toString());
    }
    //*********testTeam**************************************'
    @Test
    public void testTeam1(){
        assertEquals(1, stats.team("PIT").size());
    }
    @Test
    public void testTeam2(){
        String a = players.get(1).getName();
        assertEquals(a, stats.team("PIT").get(0).getName());
    }
    @Test
    public void testTeam3(){    
        assertEquals(0, stats.team("PT").size());
    }
    
    
    //*****testiTop**********************************************
    @Test
    public void testiTop1(){
        assertEquals(1, stats.topScorers(1).size());
    }
    
    @Test
    public void testiTop2(){
        
        assertEquals(players.size(), stats.topScorers(players.size()).size());
    }
    
    
    
    
    
    //*************************************************************
    
}
