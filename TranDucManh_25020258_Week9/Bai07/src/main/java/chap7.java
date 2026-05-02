package TranDucManh_25020258_Week9.Bai07.src;

/**
 * Lớp chap7 thực hiện các phép tính toán cơ bản để minh họa CI/CD.
 */
        public class chap7 {

  /**
   * Hàm tính tổng hai số nguyên.
   *
   * @param a Số hạng thứ nhất.
   * @param b Số hạng thứ nhất.
   * @return Tổng của a và b.
   */
  public int add(int a, int b) {
    return a + b;
  }

  /**
   * Hàm kiểm tra số chẵn.
   *
   * @param number Số cần kiểm tra.
   * @return true nếu là số chẵn, ngược lại là false.
   */
  public boolean isEven(int number) {
    return number % 2 == 0;
  }
}