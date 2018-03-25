package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaOikeanArvon() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKasvattaaRahaaOikein() {
        kortti.lataaRahaa(20);
        
        assertEquals("saldo: 0.30", kortti.toString());
    }
    
    @Test
    public void rahanOttaminenVahentaaOikein() {
        kortti.otaRahaa(5);
        
        assertEquals(5, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenEiMeneNegatiiviseksi() {
        kortti.otaRahaa(20);
        
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenPalauttaaOikeanTotuusArvon() {
        assertTrue(kortti.otaRahaa(5));
        
        assertTrue(!kortti.otaRahaa(20));
    }
    
    @Test
    public void pelkanSaldonPalauttaminen() {
        assertEquals(10, kortti.saldo());
    }
}
