/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palmartec.listastarwars;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER-PC
 */
public class ListRegex {
    
    String test = "(?!Rebel\\sAlliance)";

    public static void main(String[] args) {
        
        System.out.println("Listar todos los personajes que no sean hombres");
        leerContenido("lista.txt", "\"(?!male)([a-zA-Z\\s0-9-/',]+)\"(\\s|;)");
        System.out.println("");
        
        System.out.println("Listar todos los personajes que midan 2 metros o más");
        leerContenido("lista.txt", "\"2[0-9]{0,}\"");
        System.out.println("");
        
        System.out.println("Listar todos los personajes que midan menos del metro.");
        leerContenido("lista.txt", "\"[0-9]{2}\"");
    }
    
    

    public static void leerContenido(String archivo, String regex) {

        try {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                boolean find = regexChecker(regex, cadena);
                if(find){
                   System.out.println(cadena);
                }
            }

            b.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex);
        }
    }
    
    public static boolean regexChecker(String theRegex, String text){
        boolean find = false;
        Pattern checkRegex = Pattern.compile(theRegex);
        
        Matcher regexMatcher = checkRegex.matcher(text);
        
        while(regexMatcher.find()){
            if(regexMatcher.group().length() != 0){
//                System.out.println(regexMatcher.group().trim());
                find = !find;
            }
        }
        
        return find;
    }
}
