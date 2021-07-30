/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.exceptions;

public class platIdOutOfMenuException extends IncorrectPlatException{
    public platIdOutOfMenuException(String errorMessage) {
        super("Error: l'Id de plat introduit no es troba al menú. \n" + errorMessage);
    }
}