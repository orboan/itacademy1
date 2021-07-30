/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.exceptions;

public class IncorrectPlatTypeException extends IncorrectPlatException{
    public IncorrectPlatTypeException(String errorMessage) {
        super("Error en el tipus de dada introduit. Ha de ser un enter corresponent a un plat del memú. \n" + errorMessage);
    }
}
