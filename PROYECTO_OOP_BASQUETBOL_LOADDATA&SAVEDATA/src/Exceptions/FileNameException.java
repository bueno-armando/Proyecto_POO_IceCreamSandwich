/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

import java.io.IOException;

/**
 *
 * @author Cesar
 */
public class FileNameException extends IOException {
    public FileNameException(){
     super("Nombre se archivo Incorreto!! no se encuentral algún archivo con este nombre");
    }
}
