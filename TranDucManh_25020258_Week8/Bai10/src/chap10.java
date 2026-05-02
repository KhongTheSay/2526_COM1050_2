package TranDucManh_25020258_Week8.Bai10.src;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            System.err.println("Số dư ban đầu không hợp lệ. Gán mặc định là 0.");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0.");
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0.");
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}



class Testing {

    private BankAccount account;

    @BeforeAll
    static void start() {
        System.out.println("=== Bắt đầu test ===");
    }

    @AfterAll
    static void end() {
        System.out.println("=== Kết thúc test ===");
    }

    @BeforeEach
    void setUp() {
        account = new BankAccount("123456789", "User", 500.0);
    }

    @Test
    void test1() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void test2() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }

    @Test
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-1.0));
    }

    @Test
    void test4() {
        assertTrue(account.withdraw(200.0));
        assertEquals(300.0, account.getBalance());
    }

    @Test
    void test5() {
        assertTrue(account.withdraw(500.0));
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void test6() {
        assertFalse(account.withdraw(501.0));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void test7() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }

    @Test
    void test8() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    void test9() {
        BankAccount ltest = new BankAccount("987654321", "User2", 0.0);
        ltest.deposit(500.0);
        assertTrue(ltest.withdraw(200.0));
        assertFalse(ltest.withdraw(400.0));
        assertEquals(300.0,ltest.getBalance());
    }
}

public class chap10 {
    public static void main(String[] args) {
    }
}
