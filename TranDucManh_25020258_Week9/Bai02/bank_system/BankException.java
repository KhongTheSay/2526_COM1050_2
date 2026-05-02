/**
 * Base exception for banking operations.
 */
public class BankException extends Exception {

  /**
   * Creates a bank exception.
   *
   * @param message error message
   */
  public BankException(String message) {
    super(message);
  }
}
