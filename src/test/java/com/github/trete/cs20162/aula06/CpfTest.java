/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.trete.cs20162.aula06;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class CpfTest {
    @Test (expected = RuntimeException.class)
    public void cpfDeDozeDigitosInvalido(){
        int cpf[] = new int[12];
        Cpf.cpf(cpf);
    }
    
    @Test
    public void valorArbitrarioDeTeste(){
        int cpf[] = new int[]{2,7,3,6,2,6,2,9,1,3,3};
        assertEquals(true, Cpf.cpf(cpf));
    }
     @Test
    public void valorArbitrarioDeTesteFalso(){
        int cpf[] = new int[]{2,7,3,6,2,6,2,9,1,3,9};
        assertEquals(false, Cpf.cpf(cpf));
    }
}
