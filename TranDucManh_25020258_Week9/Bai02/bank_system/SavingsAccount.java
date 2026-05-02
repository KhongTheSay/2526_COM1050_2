/**
 * Represents a savings account.
 */
public class SavingsAccount extends Account {
  private static final double MAX_WITHDRAW = 1000.0;

  /**
   * Creates a savings account.
   *
   * @param accountNumber account number
   * @param balance initial balance
   */
  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction transaction = new Transaction(
          Transaction.TYPE_DEPOSIT_SAVINGS,
          amount,
          initialBalance,
          finalBalance);
      addTransaction(transaction);
    } catch (BankException exception) {
      throw new IllegalArgumentException(exception);
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      if (amount > MAX_WITHDRAW) {
        throw new InvalidFundingAmountException(amount);
      }

      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction transaction = new Transaction(
          Transaction.TYPE_WITHDRAW_SAVINGS,
          amount,
          initialBalance,
          finalBalance);
      addTransaction(transaction);
    } catch (BankException exception) {
      throw new IllegalArgumentException(exception);
    }
  }
}
