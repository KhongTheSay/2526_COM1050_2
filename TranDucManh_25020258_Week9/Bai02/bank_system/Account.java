import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account.
 */
public abstract class Account {
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  protected List<Transaction> transactionList;

  /**
   * Creates an account with an account number and balance.
   *
   * @param accountNumber account number
   * @param balance initial balance
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactionList = new ArrayList<Transaction>();
  }

  /**
   * Returns the account number.
   *
   * @return account number
   */
  public long getAccountNumber() {
    return accountNumber;
  }

  /**
   * Sets the account number.
   *
   * @param accountNumber account number
   */
  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * Returns the current balance.
   *
   * @return current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Sets the current balance.
   *
   * @param balance current balance
   */
  protected void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Returns all transactions.
   *
   * @return transaction list
   */
  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  /**
   * Sets the transaction list.
   *
   * @param transactionList transaction list
   */
  public void setTransactionList(List<Transaction> transactionList) {
    if (transactionList == null) {
      this.transactionList = new ArrayList<Transaction>();
    } else {
      this.transactionList = transactionList;
    }
  }

  /**
   * Deposits money into the account.
   *
   * @param amount amount to deposit
   */
  public abstract void deposit(double amount);

  /**
   * Withdraws money from the account.
   *
   * @param amount amount to withdraw
   */
  public abstract void withdraw(double amount);

  /**
   * Performs a validated deposit.
   *
   * @param amount amount to deposit
   * @throws InvalidFundingAmountException when the amount is invalid
   */
  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  /**
   * Performs a validated withdrawal.
   *
   * @param amount amount to withdraw
   * @throws BankException when the transaction is invalid
   */
  protected void doWithdrawing(double amount) throws BankException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  /**
   * Adds a transaction to the account.
   *
   * @param transaction transaction to add
   */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactionList.add(transaction);
    }
  }

  /**
   * Returns transaction history text.
   *
   * @return transaction history
   */
  public String getTransactionHistory() {
    StringBuilder builder = new StringBuilder();
    builder.append("Lich su giao dich cua tai khoan ").append(accountNumber).append(":\n");
    for (int i = 0; i < transactionList.size(); i++) {
      builder.append(transactionList.get(i).getTransactionSummary());
      if (i < transactionList.size() - 1) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Account)) {
      return false;
    }
    Account other = (Account) obj;
    return accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    return (int) (accountNumber ^ (accountNumber >>> 32));
  }
}
