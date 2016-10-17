
package com.github.trete.cs20162.aula06;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Cpf2varianteTest {
    @Test (expected = RuntimeException.class)
    public void cpfDeDozeDigitosInvalido(){
        int cpf[] = new int[12];
        Cpf.cpf2Variante(cpf);
    }
    
    @Test
    public void valorArbitrarioDeTeste(){
        int cpf[] = new int[]{2,7,3,6,2,6,2,9,1,3,3};
        assertEquals(true, Cpf.cpf2Variante(cpf));
    }
     @Test
    public void valorArbitrarioDeTesteFalso(){
        int cpf[] = new int[]{2,7,3,6,2,6,2,9,1,3,9};
        assertEquals(false, Cpf.cpf2Variante(cpf));
    }
}
