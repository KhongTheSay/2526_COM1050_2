import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank customer.
 */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /**
   * Creates an empty customer.
   */
  public Customer() {
    this(0L, "");
  }

  /**
   * Creates a customer with id number and full name.
   *
   * @param idNumber id number
   * @param fullName full name
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<Account>();
  }

  /**
   * Returns the id number.
   *
   * @return id number
   */
  public long getIdNumber() {
    return idNumber;
  }

  /**
   * Sets the id number.
   *
   * @param idNumber id number
   */
  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  /**
   * Returns the full name.
   *
   * @return full name
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Sets the full name.
   *
   * @param fullName full name
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Returns the account list.
   *
   * @return account list
   */
  public List<Account> getAccountList() {
    return accountList;
  }

  /**
   * Sets the account list.
   *
   * @param accountList account list
   */
  public void setAccountList(List<Account> accountList) {
    if (accountList == null) {
      this.accountList = new ArrayList<Account>();
    } else {
      this.accountList = accountList;
    }
  }

  /**
   * Adds an account.
   *
   * @param account account to add
   */
  public void addAccount(Account account) {
    if (account == null) {
      return;
    }
    if (!accountList.contains(account)) {
      accountList.add(account);
    }
  }

  /**
   * Removes an account.
   *
   * @param account account to remove
   */
  public void removeAccount(Account account) {
    if (account == null) {
      return;
    }
    accountList.remove(account);
  }

  /**
   * Returns customer information.
   *
   * @return customer information
   */
  public String getCustomerInfo() {
    return "So CMND: " + idNumber + ". Ho ten: " + fullName + ".";
  }
}
