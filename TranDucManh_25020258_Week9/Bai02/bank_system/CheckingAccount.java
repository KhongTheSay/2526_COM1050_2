/**
 * Represents a checking account.
 */
public class CheckingAccount extends Account {

  /**
   * Creates a checking account.
   *
   * @param accountNumber account number
   * @param balance initial balance
   */
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction transaction = new Transaction(
          Transaction.TYPE_DEPOSIT_CHECKING,
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
      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction transaction = new Transaction(
          Transaction.TYPE_WITHDRAW_CHECKING,
          amount,
          initialBalance,
          finalBalance);
      addTransaction(transaction);
    } catch (BankException exception) {
      throw new IllegalArgumentException(exception);
    }
  }
}
