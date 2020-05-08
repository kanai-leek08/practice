import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    public void testInsert() {
        VendingMachine vm = new VendingMachine();
        vm.insertMoney(100);
        assertEquals(1, 1);
    }

    public void testTotalCoin(){
        VendingMachine vm = new VendingMachine();
        assertEquals(1, 1);
    }

    class VendingMachine {


        public void insertMoney(int money){
            
        }

    }
    
}