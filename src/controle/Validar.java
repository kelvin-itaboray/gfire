/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author kelvin
 */
public class Validar {

    public boolean validaNome(String texto) {
        String validacao = "!@#$%¨&*()_+¹²³£¢¬§/*-+./;,~][´;`{}ºª'|?:><}^`{}1234567890";
        boolean verifica = true;
        if (texto.equals("")) {
            verifica = false;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    verifica = false;
                }
            }
        }
        return verifica;
    }

    public boolean validaNumero(String texto) {
        String validacao = "!@#$%¨&*()_+¹²³£¢¬§/*-+./;,~][´;`{}ºª'|?:><}^`{}abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (texto.equals("")) {
            return false;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        if (Integer.parseInt(texto) <= 0) {
            return false;
        }
        return true;
    }

    public boolean validaEmail(String texto) {
        String validacao = "!#$%¨&*()_+¹²³£¢¬§/*-+/;,~][´;`{}ºª'|?:><}^`{}";
        if (texto.contains(".com") && texto.contains("@")) {
            return true;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean validaSemSimbolo(String texto) {
        String validacao = "!#$%¨&*()_+¹²³£¢¬§/*-+/;,.~][´;`{}ºª'|?:><}^`{}";
        boolean verifica = true;
        if (texto.equals("")) {
            verifica = false;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    verifica = false;
                }
            }
        }
        return verifica;
    }

    public boolean validaCampoFormatado(String texto) {
        boolean verifica = true;
        for (int j = 0; j < texto.length(); j++) {
            if (texto.substring(j, j + 1).equals(" ")) {
                verifica = false;
            }
        }
        return verifica;
    }

    public boolean validaData(String texto) {
        boolean verifica = true;
        for (int j = 0; j < texto.length(); j++) {
            if (texto.substring(j, j + 1).equals(" ")) {
                verifica = false;
                return verifica;
            }
        }
        if (Integer.parseInt(texto.substring(0, 2)) > 31 || Integer.parseInt(texto.substring(0, 2)) < 1) {
            verifica = false;
            return verifica;
        }
        if (Integer.parseInt(texto.substring(3, 5)) > 12 || Integer.parseInt(texto.substring(3, 5)) < 1) {
            verifica = false;
            return verifica;
        }
        if (Integer.parseInt(texto.substring(6)) < 1960) {
            verifica = false;
            return verifica;
        }
        return verifica;
    }

    public boolean validaDataNasc(String texto) {
        for (int j = 0; j < texto.length(); j++) {
            if (texto.substring(j, j + 1).equals(" ")) {
                return false;
            }
        }
        Date d = new Date();
        if (Integer.parseInt(texto.substring(0, 2)) > 31 || Integer.parseInt(texto.substring(0, 2)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(3, 5)) > 12 || Integer.parseInt(texto.substring(3, 5)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) < 1960 || Integer.parseInt(texto.substring(6)) > (d.getYear() + 1882)) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) == d.getYear() + 1882) {
            if (Integer.parseInt(texto.substring(3, 5)) > d.getMonth() + 1) {
                return false;
            } else if (Integer.parseInt(texto.substring(3, 5)) == d.getMonth() + 1 && Integer.parseInt(texto.substring(0, 2)) > d.getDate()) {
                return false;
            }
        }
        return true;
    }

    public boolean validaDataAntesHoje(String texto) {
        for (int j = 0; j < texto.length(); j++) {
            if (texto.substring(j, j + 1).equals(" ")) {
                return false;
            }
        }

        Date d = new Date();
        if (Integer.parseInt(texto.substring(0, 2)) > 31 || Integer.parseInt(texto.substring(0, 2)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(3, 5)) > 12 || Integer.parseInt(texto.substring(3, 5)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) < 1960 || Integer.parseInt(texto.substring(6)) > (d.getYear() + 1900)) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) == d.getYear() + 1900) {
            if (Integer.parseInt(texto.substring(3, 5)) > d.getMonth() + 1) {
                return false;
            } else if (Integer.parseInt(texto.substring(3, 5)) == d.getMonth() + 1 && Integer.parseInt(texto.substring(0, 2)) > d.getDate()) {
                return false;
            }
        }
        return true;
    }

    public boolean validaDataDepoisHoje(String texto) {
        if (texto.equals("")) {
            return false;
        }
        for (int j = 0; j < texto.length(); j++) {
            if (texto.substring(j, j + 1).equals(" ")) {
                return false;
            }
        }

        Date d = new Date();
        if (Integer.parseInt(texto.substring(0, 2)) > 31 || Integer.parseInt(texto.substring(0, 2)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(3, 5)) > 12 || Integer.parseInt(texto.substring(3, 5)) < 1) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) < (d.getYear() + 1900)) {
            return false;
        }
        if (Integer.parseInt(texto.substring(6)) == d.getYear() + 1900) {
            if (Integer.parseInt(texto.substring(3, 5)) < d.getMonth() + 1) {
                return false;
            } else if (Integer.parseInt(texto.substring(3, 5)) == d.getMonth() + 1 && Integer.parseInt(texto.substring(0, 2)) < (d.getDate())) {
                return false;
            }
        }
        return true;
    }

    public boolean validaDocumento(String texto) {
        String validacao = "!@#$%¨&*()_+¹²³£¢¬§/*+/;,~][´;`{}ºª'|?:><}^`{}abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        if (texto.equals("")) {
            return false;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validaQuantia(String texto) {
        String validacao = "!@#$%¨&*()_+¹²³£¢¬§/*-+/;~][´;`{}ºª'|?:><}^`{}abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (texto.equals("")) {
            return false;
        }
        for (int j = 0; j < texto.length(); j++) {
            for (int i = 0; i < validacao.length(); i++) {
                if (texto.substring(j, j + 1).equals(validacao.substring(i, i + 1))) {
                    return false;
                }
            }
        }
        if (Double.parseDouble(texto.replace(",", ".")) < 0.01) {
            return false;
        }
        return true;
    }

    public boolean validaCPF(String CPF) {
// considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
// converte o i-esimo caractere do CPF em um numero:
// por exemplo, transforma o caractere '0' no inteiro 0        
// (48 eh a posicao de '0' na tabela ASCII)        
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }
// Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean validaCNPJ(String strCNPJ) {
        int iSoma = 0, iDigito;
        char[] chCaracteresCNPJ;
        String strCNPJ_Calculado;

        if (!strCNPJ.substring(0, 1).equals("")) {
            try {
                strCNPJ = strCNPJ.replace('.', ' ');
                strCNPJ = strCNPJ.replace('/', ' ');
                strCNPJ = strCNPJ.replace('-', ' ');
                strCNPJ = strCNPJ.replaceAll(" ", "");
                strCNPJ_Calculado = strCNPJ.substring(0, 12);
                if (strCNPJ.length() != 14) {
                    return false;
                }
                chCaracteresCNPJ = strCNPJ.toCharArray();
                for (int i = 0; i < 4; i++) {
                    if ((chCaracteresCNPJ[i] - 48 >= 0) && (chCaracteresCNPJ[i] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if ((chCaracteresCNPJ[i + 4] - 48 >= 0) && (chCaracteresCNPJ[i + 4] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                iDigito = 11 - (iSoma % 11);
                strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
                iSoma = 0;
                for (int i = 0; i < 5; i++) {
                    if ((chCaracteresCNPJ[i] - 48 >= 0) && (chCaracteresCNPJ[i] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if ((chCaracteresCNPJ[i + 5] - 48 >= 0) && (chCaracteresCNPJ[i + 5] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                iDigito = 11 - (iSoma % 11);
                strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
                return strCNPJ.equals(strCNPJ_Calculado);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
