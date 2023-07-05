import javax.swing.JFrame;
import javax.swing.JTable;

class CreateTable {
    public static void main(String args[], List<Customer> CustomerList) {
        JFrame frame = new JFrame();

        String[] tableColumn = { "customer_number", "salutation", "title", "name", "last_name", "birth_date", "street",
                "street_number", "postcode", "town", "phone_number", "mobile_number", "fax", "e_mail",
                "newsletter" };

        JTable table = new JTable(CustomerList, tableColumn);

        frame.add(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}