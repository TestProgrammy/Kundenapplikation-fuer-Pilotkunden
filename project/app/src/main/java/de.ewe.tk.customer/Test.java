public class Test {
    public static void Test() {
        while (true) {
            int value = Validator.validateCustomerNumber("Kundennummer: ");
            System.out.println(String.format("Value ist %d", value));
        }
    }
}
