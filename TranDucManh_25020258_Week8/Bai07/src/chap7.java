package TranDucManh_25020258_Week8.Bai07.src;



public class chap7 {
    public static void main(String[] args) {
        System.out.println("Hello from chap7");
    }
}



//1

// 1. EQUivalence Classes (EP)

// EC1: price < 0           -> Invalid (throw exception)
// EC2: 0 <= price < 100    -> Valid (low discount)
// EC3: price >= 100        -> Valid (high discount)


// 2

/*
TC1: price = -10, memberType = "GUEST"
→ Expected: IllegalArgumentException

TC2: price = 50, memberType = "GUEST"
→ Expected: 0%

TC3: price = 50, memberType = "MEMBER"
→ Expected: 5%

TC4: price = 150, memberType = "MEMBER"
→ Expected: 10%

TC5: price = 50, memberType = "VIP"
→ Expected: 15%

TC6: price = 150, memberType = "VIP"
→ Expected: 20%

TC7: price = 50, memberType = "UNKNOWN"
→ Expected: IllegalArgumentException
*/


// 3

// At boundary price = 0:
// min- = -0.1
// min  = 0
// min+ = 0.1

// At boundary price = 100:
// max- = 99.9
// max  = 100
// max+ = 100.1

/*
Boundary values to test:
-0.1, 0, 0.1, 99.9, 100, 100.1
*/


//4

// Input sets:
// price: {LOW (<100), HIGH (>=100)}
// memberType: {GUEST, MEMBER, VIP}

/*
TC1: LOW  + GUEST
TC2: LOW  + MEMBER
TC3: LOW  + VIP
TC4: HIGH + GUEST
TC5: HIGH + MEMBER
TC6: HIGH + VIP


*/