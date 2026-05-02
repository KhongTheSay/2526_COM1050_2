import java.util.Locale;

/**
 * Exception thrown when a transaction amount is invalid.
 */
public class InvalidFundingAmountException extends BankException {

  /**
   * Creates an invalid funding amount exception.
   *
   * @param amount invalid amount
   */
  public InvalidFundingAmountException(double amount) {
    super("So tien khong hop le: $" + String.format(Locale.US, "%.2f", amount));
  }
}
