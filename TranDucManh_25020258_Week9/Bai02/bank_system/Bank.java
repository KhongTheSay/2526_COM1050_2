import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages customers and their bank accounts.
 */
public class Bank {
  private static final String CUSTOMER_ID_PATTERN = "\\d{9}";

  private List<Customer> customerList;

  /**
   * Creates an empty bank.
   */
  public Bank() {
    this.customerList = new ArrayList<Customer>();
  }

  /**
   * Returns the customer list.
   *
   * @return customer list
   */
  public List<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * Sets the customer list.
   *
   * @param customerList customer list
   */
  public void setCustomerList(List<Customer> customerList) {
    if (customerList == null) {
      this.customerList = new ArrayList<Customer>();
    } else {
      this.customerList = customerList;
    }
  }

  /**
   * Reads customers and accounts from an input stream.
   *
   * @param inputStream input stream
   */
  public void readCustomerList(InputStream inputStream) {
    if (inputStream == null) {
      return;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    Customer currentCustomer = null;
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        currentCustomer = readCustomerLine(line.trim(), currentCustomer);
      }
    } catch (IOException | NumberFormatException exception) {
      throw new IllegalArgumentException("Cannot read customer list", exception);
    }
  }

  private Customer readCustomerLine(String line, Customer currentCustomer) {
    if (line.isEmpty()) {
      return currentCustomer;
    }

    int lastSpace = line.lastIndexOf(' ');
    if (lastSpace <= 0) {
      return currentCustomer;
    }

    String token = line.substring(lastSpace + 1).trim();
    if (token.matches(CUSTOMER_ID_PATTERN)) {
      String name = line.substring(0, lastSpace).trim();
      Customer customer = new Customer(Long.parseLong(token), name);
      customerList.add(customer);
      return customer;
    }

    if (currentCustomer != null) {
      addAccountFromLine(currentCustomer, line);
    }
    return currentCustomer;
  }

  private void addAccountFromLine(Customer customer, String line) {
    String[] parts = line.split("\\s+");
    if (parts.length < 3) {
      return;
    }

    long accountNumber = Long.parseLong(parts[0]);
    double balance = Double.parseDouble(parts[2]);
    if (Account.CHECKING_TYPE.equals(parts[1])) {
      customer.addAccount(new CheckingAccount(accountNumber, balance));
    } else if (Account.SAVINGS_TYPE.equals(parts[1])) {
      customer.addAccount(new SavingsAccount(accountNumber, balance));
    }
  }

  /**
   * Returns customer information sorted by id number.
   *
   * @return sorted customer information
   */
  public String getCustomersInfoByIdOrder() {
    Collections.sort(customerList, new Comparator<Customer>() {
      @Override
      public int compare(Customer firstCustomer, Customer secondCustomer) {
        return Long.compare(firstCustomer.getIdNumber(), secondCustomer.getIdNumber());
      }
    });
    return buildCustomerInfo(customerList);
  }

  /**
   * Returns customer information sorted by full name.
   *
   * @return sorted customer information
   */
  public String getCustomersInfoByNameOrder() {
    List<Customer> copy = new ArrayList<Customer>(customerList);
    Collections.sort(copy, new Comparator<Customer>() {
      @Override
      public int compare(Customer firstCustomer, Customer secondCustomer) {
        int result = firstCustomer.getFullName().compareTo(secondCustomer.getFullName());
        if (result != 0) {
          return result;
        }
        return Long.compare(firstCustomer.getIdNumber(), secondCustomer.getIdNumber());
      }
    });
    return buildCustomerInfo(copy);
  }

  private String buildCustomerInfo(List<Customer> customers) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < customers.size(); i++) {
      builder.append(customers.get(i).getCustomerInfo());
      if (i < customers.size() - 1) {
        builder.append("\n");
      }
    }
    return builder.toString();
  }
}
