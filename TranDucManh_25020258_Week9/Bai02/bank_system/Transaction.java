import java.util.Locale;

/**
 * Đại diện cho một giao dịch.
 */
public class Transaction {
  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Khởi tạo giao dịch.
   *
   * @param type loại giao dịch
   * @param amount số tiền giao dịch
   * @param initialBalance số dư ban đầu
   * @param finalBalance số dư cuối
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /**
   * Trả về loại giao dịch.
   *
   * @return loại giao dịch
   */
  public int getType() {
    return type;
  }

  /**
   * Cập nhật loại giao dịch.
   *
   * @param type loại giao dịch
   */
  public void setType(int type) {
    this.type = type;
  }

  /**
   * Trả về số tiền giao dịch.
   *
   * @return số tiền giao dịch
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Cập nhật số tiền giao dịch.
   *
   * @param amount số tiền giao dịch
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Trả về số dư ban đầu.
   *
   * @return số dư ban đầu
   */
  public double getInitialBalance() {
    return initialBalance;
  }

  /**
   * Cập nhật số dư ban đầu.
   *
   * @param initialBalance số dư ban đầu
   */
  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  /**
   * Trả về số dư cuối.
   *
   * @return số dư cuối
   */
  public double getFinalBalance() {
    return finalBalance;
  }

  /**
   * Cập nhật số dư cuối.
   *
   * @param finalBalance số dư cuối
   */
  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  /**
   * Trả về mô tả loại giao dịch.
   *
   * @param transactionType loại giao dịch
   * @return mô tả loại giao dịch
   */
  public static String getTypeString(int transactionType) {
    switch (transactionType) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /**
   * Trả về thông tin tóm tắt giao dịch.
   *
   * @return thông tin tóm tắt giao dịch
   */
  public String getTransactionSummary() {
    return String.format(
        Locale.US,
        "- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. Số tiền: $%.2f. Số dư cuối: $%.2f.",
        getTypeString(type),
        initialBalance,
        amount,
        finalBalance);
  }
}
