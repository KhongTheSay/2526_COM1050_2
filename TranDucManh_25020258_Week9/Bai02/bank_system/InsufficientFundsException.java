import java.util.Locale;

/**
 * Exception thrown when an account has insufficient funds.
 */
public class InsufficientFundsException extends BankException {

  /**
   * Creates an insufficient funds exception.
   *
   * @param amount requested amount
   */
  public InsufficientFundsException(double amount) {
    super("So du tai khoan khong du $"
        + String.format(Locale.US, "%.2f", amount)
        + " de thuc hien giao dich");
  }
}
