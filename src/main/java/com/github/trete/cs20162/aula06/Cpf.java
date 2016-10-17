
package com.github.trete.cs20162.aula06;

public class Cpf {

    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada
     * 
     * @return o valor lógico da validade do cpf
     * 
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11
     */
    public static boolean cpf(int cpf[])throws RuntimeException{
        if(cpf.length != 11){
            throw new RuntimeException
                ("número de dígitos inválido para um cpf");
        }
        
        int verificadorA = cpf[0] + 2 * cpf[1] + 3 * cpf[2] + 4 * cpf[3] +
                5 * cpf[4] + 6 * cpf[5] + 7 * cpf[6] + 8 * cpf[7] + 9 * cpf[8];
        
        int verificadorB = cpf[1] + 2 * cpf[2] + 3 * cpf[3] + 4 * cpf[4] +
                5 * cpf[5] + 6 * cpf[6] + 7 * cpf[7] + 8 * cpf[8] + 9 * cpf[9];
        
        int verificadorC = (verificadorA % 11) % 10;
        
        int verificadorD = (verificadorB % 11) % 10;
        
        return verificadorC == cpf[9] && verificadorD == cpf[10];
    }
   
    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada
     * 
     * @return o valor lógico da validade do cpf
     * 
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11
     */
    public static boolean cpf2(int cpf[])throws RuntimeException{
        if(cpf.length != 11){
            throw new RuntimeException
                ("número de dígitos inválido para um cpf");
        }

        int contador = 8, primeiroTermo = cpf[8], segundoTermo = cpf[8];

        while(contador >= 1){
            primeiroTermo += cpf[contador - 1];

            segundoTermo += primeiroTermo;

            contador--;
        }

        int verificadorA = (segundoTermo % 11) % 10;

        int verificadorB = ((segundoTermo - primeiroTermo + 9 * verificadorA)
                % 11) % 10;

        return verificadorA == cpf[9] && verificadorB == cpf[10];
    }
    
    
    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada
     * 
     * @return o valor lógico da validade do cpf
     * 
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11
     */
    public static boolean cpf2Variante(int cpf[])throws RuntimeException{
        if(cpf.length != 11){
            throw new RuntimeException
                ("número de dígitos inválido para um cpf. Deve ser 11");
        }
        
        int primeiroTermo = cpf[8], segundoTermo = cpf[8], verificadorA = 0,
                verificadorB = 0;

        for (int contador = 8; contador >= 1; contador--) {
            primeiroTermo += cpf[contador - 1];

            segundoTermo += primeiroTermo;

            verificadorA = (segundoTermo % 11) % 10;

            verificadorB = ((segundoTermo - primeiroTermo + 9 * verificadorA)
                    % 11) % 10;
        }
        return verificadorA == cpf[9] && verificadorB == cpf[10];
    }
}
