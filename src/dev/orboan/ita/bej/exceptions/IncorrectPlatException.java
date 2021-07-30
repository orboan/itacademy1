/**
 * @author Oriol Boix Anfosso <orboan@gmail.com>
 *
 */
package dev.orboan.ita.bej.exceptions;

public class IncorrectPlatException extends Exception {
    public IncorrectPlatException(String errorMessage) {
        super("Plat incorrecte. " + errorMessage);
    }
}
