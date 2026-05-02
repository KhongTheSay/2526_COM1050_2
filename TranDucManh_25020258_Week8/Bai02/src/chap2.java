package TranDucManh_25020258_Week8.Bai02.src;


class PayrollSystem {
    public static final double taxpercent0 = 0.095; 
    public static final double taxlv0 = 11000000;
    public static final double taxpercent1 = 0.05;
    public static final double taxpercent2 = 0.10;
    public static final double taxlv1 = 5000000.0;
    public static final double taxlv2 = 10000000.0;

    public void printPayroll(String name, double baseSalary, int workDays, int totalDays, double taxRate, double bonus) {
        double actualSalary = calActualSalary(baseSalary, workDays, totalDays);
        double insurance = calInsurance(actualSalary);
        double taxableIncome = calTaxableIncome(actualSalary, insurance);
        double tax = calTax(taxableIncome, taxRate);
        double netSalary = calNetSalary(actualSalary, insurance, tax, bonus);

        System.out.println("Nhân viên: " + name);
        System.out.println("Lương cơ bản: " + baseSalary);
        System.out.println("Ngày công: " + workDays + "/" + totalDays);
        System.out.println("Lương thực tế: " + actualSalary);
        System.out.println("Bảo hiểm: " + insurance);
        System.out.println("Thuế TNCN: " + tax);
        System.out.println("Thưởng: " + bonus);
        System.out.println("Thực nhận: " + netSalary);
    }

    public double calActualSalary(double baseSalary, int workDays, int totalDays) {
        return baseSalary * (double)workDays / totalDays;
    }

    public double calInsurance(double actualSalary) {
        return actualSalary * taxpercent0; 
    }

    public double calTaxableIncome(double actualSalary, double insurance) {
        double income = actualSalary - insurance - taxlv0;
        return Math.max(0, income);
    }

    public double calTax(double taxableIncome, double taxRate) {
        double tax = 0;
        if (taxableIncome > 0) {
            if (taxableIncome <= taxlv1) tax = taxableIncome * taxpercent1;
            else if (taxableIncome <= taxlv2) tax = 250000 + (taxableIncome - taxlv1) * taxpercent2;
            else tax = 750000 + (taxableIncome - taxlv2) * taxRate;
        }
        return tax;
    }

    public double calNetSalary(double actualSalary, double insurance, double tax, double bonus) {
        return actualSalary - insurance - tax + bonus;
    }
}

public class chap2 {
    public static void main(String[] args) {
        PayrollSystem calculator = new PayrollSystem();
        String name = "Trần Đức Mạnh";
        double baseSalary = 300000.0;
        int workDays = 20;            
        int totalDays = 22;            
        double taxRate = 0.20;         
        double bonus = 20000.0;      
        calculator.printPayroll(name, baseSalary, workDays, totalDays, taxRate, bonus);
    }
}