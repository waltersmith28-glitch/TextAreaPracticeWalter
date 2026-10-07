import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;
import javax.swing.*;

public class textAreaPractice implements ActionListener, KeyListener{
    private JFrame mainFrame;
    private JTextArea textArea;
    private JTextField show;
    private int WIDTH=800;
    private int HEIGHT=700;
    private JButton enterButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JScrollPane scrollTextarea;



    public textAreaPractice() {
        prepareGUI();
    }

    public static void main(String[] args) {
        textAreaPractice swingControlDemo = new textAreaPractice();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("simple application");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Input Text: ");
        show = new JTextField(50);
        inputPanel.add(inputLabel);
        inputPanel.add(show);

        JPanel buttonPanel = new JPanel();
        enterButton = new JButton("Enter");
        deleteButton = new JButton("Delete Text Area");
        clearButton = new JButton("Clear Input");

        enterButton.setActionCommand("Enter");
        deleteButton.setActionCommand("Delete Text Area");
        clearButton.setActionCommand("ClearInput");

        enterButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(enterButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);
        mainFrame.setVisible(true);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.addKeyListener(this);
        scrollTextarea = new JScrollPane(textArea);

        // Add components to main frame
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(scrollTextarea, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Enter")) {
            String text = show.getText();
            textArea.append(text + "\n");
        } else if (command.equals("Delete Text Area")) {
            show.setText("");
            textArea.setText("");
        } else if (command.equals("ClearInput")) {
            show.setText("");
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode()==10){
            System.out.println(";eg");
            String text = show.getText();
            textArea.append(text + "\n");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}