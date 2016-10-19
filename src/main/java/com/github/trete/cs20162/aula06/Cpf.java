
package com.github.trete.cs20162.aula06;
/**
 * Implementação de verificação de validade de cpf.
 *
 */
public abstract class Cpf {
    /**
     * número que representa o comprimento de um array de cpf válido.
     */
    private static final int TAMANHO_CPF = 11;

    /**
     * número pelo qual se toma o resto da divisão inteira quando se quer
     * extrair o valor da unidade de um inteiro de dois ou mais dígitos.
     */
    private static final int EXTRATOR_DE_UNIDADE = 10;

    /**
     * número usado para referenciar o º dígito de um array que representa um
     * cpf.
     */
    private static final int PRIMEIRO_DIGITO = 0;

    /**
     * número usado para referenciar o 2º dígito de um array que representa um
     * cpf.
     */
    private static final int SEGUNDO_DIGITO = 1;


    /**
     * número usado para referenciar o 3º dígito de um array que representa um
     * cpf.
     */
    private static final int TERCEIRO_DIGITO = 2;

    /**
     * número usado para referenciar o 4º dígito de um array que representa um
     * cpf.
     */
    private static final int QUARTO_DIGITO = 3;

    /**
     * número usado para referenciar o 5º dígito de um array que representa um
     * cpf.
     */
    private static final int QUINTO_DIGITO = 4;

    /**
     * número usado para referenciar o 6º dígito de um array que representa um
     * cpf.
     */
    private static final int SEXTO_DIGITO = 5;

    /**
     * número usado para referenciar o 7º dígito de um array que representa um
     * cpf.
     */
    private static final int SETIMO_DIGITO = 6;

    /**
     * número usado para referenciar o 8º dígito de um array que representa um
     * cpf.
     */
    private static final int OITAVO_DIGITO = 7;

    /**
     * número usado para referenciar o 9º dígito de um array que representa um
     * cpf.
     */
    private static final int NONO_DIGITO = 8;

    /**
     * número usado para referenciar o 10º dígito de um array que representa um
     * cpf.
     */
    private static final int DECIMO_DIGITO = 9;

    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada.
     *
     * @return o valor lógico da validade do cpf.
     *
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11.
     */
    public static boolean cpf(final int[] cpf)throws RuntimeException {
        if (cpf.length != TAMANHO_CPF) {
            throw new RuntimeException(
                "número de dígitos inválido para um cpf");
        }

        int verificadorA = cpf[PRIMEIRO_DIGITO] + TERCEIRO_DIGITO
                * cpf[SEGUNDO_DIGITO] + QUARTO_DIGITO * cpf[TERCEIRO_DIGITO]
                + QUINTO_DIGITO * cpf[QUARTO_DIGITO] + SEXTO_DIGITO
                * cpf[QUINTO_DIGITO] + SETIMO_DIGITO * cpf[SEXTO_DIGITO]
                + OITAVO_DIGITO * cpf[SETIMO_DIGITO] + NONO_DIGITO
                * cpf[OITAVO_DIGITO] + DECIMO_DIGITO * cpf[NONO_DIGITO];

        int verificadorB = cpf[SEGUNDO_DIGITO] + TERCEIRO_DIGITO
                * cpf[TERCEIRO_DIGITO] + QUARTO_DIGITO * cpf[QUARTO_DIGITO]
                + QUINTO_DIGITO * cpf[QUINTO_DIGITO] + SEXTO_DIGITO
                * cpf[SEXTO_DIGITO] + SETIMO_DIGITO * cpf[SETIMO_DIGITO]
                + OITAVO_DIGITO * cpf[OITAVO_DIGITO] + NONO_DIGITO
                * cpf[NONO_DIGITO] + DECIMO_DIGITO * cpf[DECIMO_DIGITO];

        int verificadorC = (verificadorA % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;

        int verificadorD = (verificadorB % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;

        return verificadorC == cpf[DECIMO_DIGITO]
                && verificadorD == cpf[EXTRATOR_DE_UNIDADE];

    }

    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada.
     *
     * @return o valor lógico da validade do cpf.
     *
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11.
     */
    public static boolean cpf2(final int[] cpf)throws RuntimeException {
        if (cpf.length != TAMANHO_CPF) {
            throw new RuntimeException(
                "número de dígitos inválido para um cpf");
        }

        int contador = NONO_DIGITO, primeiroTermo = cpf[NONO_DIGITO],
                segundoTermo = cpf[NONO_DIGITO];

        while (contador >= SEGUNDO_DIGITO) {
            primeiroTermo += cpf[contador - SEGUNDO_DIGITO];

            segundoTermo += primeiroTermo;

            contador--;
        }

        int verificadorA = (segundoTermo % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;

        int verificadorB = ((segundoTermo - primeiroTermo + DECIMO_DIGITO
                * verificadorA) % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;

        return verificadorA == cpf[DECIMO_DIGITO]
                && verificadorB == cpf[EXTRATOR_DE_UNIDADE];

    }

    /**
     *
     * @param cpf vetor de dígitos que configuram o cpf cuja validade será
     * verificada.
     *
     * @return o valor lógico da validade do cpf.
     *
     * @throws RuntimeException se o número de elementos no vetor cpf for
     * diferente de 11.
     */
    public static boolean cpf2Variante(final int[] cpf)throws RuntimeException {
        if (cpf.length != TAMANHO_CPF) {
            throw new RuntimeException(
                "número de dígitos inválido para um cpf. Deve ser 11");
        }

        int primeiroTermo = cpf[NONO_DIGITO], segundoTermo = cpf[NONO_DIGITO],
                verificadorA = PRIMEIRO_DIGITO, verificadorB = PRIMEIRO_DIGITO;

        for (int contador = NONO_DIGITO;
                contador >= SEGUNDO_DIGITO; contador--) {
            primeiroTermo += cpf[contador - SEGUNDO_DIGITO];

            segundoTermo += primeiroTermo;

            verificadorA = (segundoTermo % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;

            verificadorB = ((segundoTermo - primeiroTermo + DECIMO_DIGITO
                    * verificadorA) % TAMANHO_CPF) % EXTRATOR_DE_UNIDADE;
        }
        return verificadorA == cpf[DECIMO_DIGITO]
                && verificadorB == cpf[EXTRATOR_DE_UNIDADE];
    }
}
