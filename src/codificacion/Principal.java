/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Francisco Genere
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ubicacion1 = "C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\Lexer.flex";
        String ubicacion2 = "C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\LexerCup.flex";
        String[] ubicaciones = {"-parser", "Sintax", "C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\Sintax.cup"};
        generar(ubicacion1, ubicacion2, ubicaciones);
    }
    public static void generar(String ruta1, String ruta2, String[] ubicaciones) throws IOException, Exception{
        File cadena;
        cadena = new File(ruta1);
        JFlex.Main.generate(cadena);
        cadena = new File(ruta2);
        JFlex.Main.generate(cadena);
        java_cup.Main.main(ubicaciones);
        
        Path rutaSym = Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\sym.java"), 
                Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\sym.java")
        );
        Path rutaSin = Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\src\\codigo\\Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\Sintax.java"), 
                Paths.get("C:\\Users\\Desktop1\\Desktop\\AnalizadorSintactico\\AQUI\\AnalizadorLexico\\Sintax.java")
        );
    }
}
