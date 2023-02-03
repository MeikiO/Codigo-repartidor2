
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class JListExample {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataAccess.getEmployees();
        JList<Employee> jList = new JList<>(employees.toArray(new Employee[employees.size()]));
        jList.setCellRenderer(createListRenderer());
        jList.addListSelectionListener(createListSelectionListener(jList));
        JScrollPane pane = new JScrollPane(jList);

        JFrame frame = createFrame();
        frame.add(pane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static ListSelectionListener createListSelectionListener(JList list) {
        return e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println(list.getSelectedValue());
            }
        };
    }

    private static ListCellRenderer<? super Employee> createListRenderer() {
        return new DefaultListCellRenderer() {
            private Color background = new Color(0, 100, 255, 15);
            private Color defaultBackground = (Color) UIManager.get("List.background");

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
            	
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (c instanceof JLabel) {
                    JLabel label = (JLabel) c;
                    Employee emp = (Employee) value;
                    label.setText(String.format("%s [%s]", emp.getName(), emp.getDept()));
                    if (!isSelected) {
                        label.setBackground(index % 2 == 0 ? background : defaultBackground);
                    }
                }
                return c;
            }
        };
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}