/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hceetu
 */
public class KassapaateTest {
    Kassapaate kassa;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void tilanneKonstruktionJalkeen() {
        assertEquals(100000, kassa.kassassaRahaa());
        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void ostettaessaKassanRahaEdullinen() {
        assertEquals(60, kassa.syoEdullisesti(300));
        
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void ostettaessaKassanRahaMaukas() {
        assertEquals(200, kassa.syoMaukkaasti(600));
        
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void ostettaessaKassanOstosMaaraEdullinen() {
        kassa.syoEdullisesti(300);
        
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void ostettaessaKassanOstosMaaraMaukas() {
        kassa.syoMaukkaasti(600);
        
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenEiTarpeeksiRahaaPalautusJaEiKassaanLisaa() {
        assertEquals(100, kassa.syoEdullisesti(100));
        
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukasEiTarpeeksiRahaaPalautusJaEiKassaanLisaa() {
        assertEquals(300, kassa.syoMaukkaasti(300));
        
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void eiLisaaMyyntejaKunEiRiitaEdullinen() {
        kassa.syoEdullisesti(100);
        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void eiLisaaMyyntejaKunEiRiitaMaukas() {
        kassa.syoEdullisesti(300);
        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortillaMaksussaVeloitetaanEdullinenJaTrue() {
        Maksukortti kortti = new Maksukortti(300);
        assertTrue(kassa.syoEdullisesti(kortti));
        
        assertEquals(60, kortti.saldo());
    }
    
    @Test
    public void kortillaMaksussaVeloitetaanMaukasJaTrue() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(kassa.syoMaukkaasti(kortti));
        
        assertEquals(100, kortti.saldo());
    }
    
    @Test
    public void myydytEdullisetKasvaaKortti() {
        Maksukortti kortti = new Maksukortti(300);
        kassa.syoEdullisesti(kortti);
        
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myydytMaukkaatKasvaaKortti() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josEiRahaaEiVahennyKortillaEikaMyydytLisaannyEdullinen() {
        Maksukortti kortti = new Maksukortti(100);
        assertTrue(!kassa.syoEdullisesti(kortti));
        
        assertEquals(100, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josEiRahaaEiVahennyKortillaEikaMyydytLisaannyMaukas() {
        Maksukortti kortti = new Maksukortti(350);
        assertTrue(!kassa.syoMaukkaasti(kortti));
        
        assertEquals(350, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahaEiMuutuKortillaEdullinen() {
        Maksukortti kortti = new Maksukortti(400);
        
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassanRahaEiMuutuKortillaMaukas() {
        Maksukortti kortti = new Maksukortti(500);
        
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahaLatautuuKortilleJaKassaanLisaaRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, 234);
        
        assertEquals(734, kortti.saldo());
        
        assertEquals(100234, kassa.kassassaRahaa());
    }
    
    @Test
    public void negatiivisiaLukujaEiVoiLisata() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.lataaRahaaKortille(kortti, -234);
        
        assertEquals(500, kortti.saldo());
        
        assertEquals(100000, kassa.kassassaRahaa());
    }
}
