import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Project extends JFrame
{
    public static void run()
    {
        //Создадим окно и установим заголовок
        final JFrame window = new JFrame("Калькуляция уравнения");
        window.setPreferredSize(new Dimension(700,400));
        window.getContentPane().setLayout(new FlowLayout());

        //Создаем текст
        JLabel topLabel = new JLabel("Уравнение");
        topLabel.setVerticalAlignment(JLabel.TOP);
        topLabel.setLocation(600,400);
        topLabel.setForeground(Color.BLACK);




        //Событие "закрыть" при нажатии по крестику окна
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent event) {
            }
            public void windowClosed(WindowEvent event) {
            }
            public void windowClosing(WindowEvent event) {
                Object[] options = { "Да", "Нет" };
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            public void windowDeactivated(WindowEvent event) {
            }
            public void windowDeiconified(WindowEvent event) {
            }
            public void windowIconified(WindowEvent event) {
            }
            public void windowOpened(WindowEvent event) {
            }
        });

        //Текстовое поле
        JTextField textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setColumns(14);


        //Создадим панель
        JPanel panel = new JPanel();
        panel.setSize(200,10);

        //panel.setLayout(null);


        //Создадим кнопки
        JButton minButton = new JButton("Свернуть");
        JButton maxButton = new JButton("Растянуть");
        JButton normalButton = new JButton("Оригинал");
        JButton exitButton = new JButton("Выход");
        JButton helloButton = new JButton("Hello");


        //Событие для кнопки "Свернуть"
        minButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Действие
                window.setState(JFrame.ICONIFIED);
            }
        });

        //Событие для кнопки "Растянуть"
        maxButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Действие
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });


        //Событие для кнопки "Оригинал"
        normalButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Действие
                window.setExtendedState(JFrame.NORMAL);
            }
        });


        //Событие для кнопки "Выход"
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Действие
                window.setVisible(false);
                System.exit(0);
            }
        });

        //Событие для кнопки "Hello"
        helloButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Действие
                textField.setText("Hello World!");
            }
        });


        //Добавим кнопки и поля на панель
        panel.add(minButton);
        panel.add(maxButton);
        panel.add(normalButton);
        panel.add(exitButton);
        panel.add(textField);
        panel.add(helloButton);
        panel.add(topLabel);




        //Добавим панель в окно
        //window.getContentPane().add(panel);
//      window.getContentPane().add(panel1);


        JPanel panel2 = new JPanel();
        window.add(panel2);

        panel2.setLayout(new BorderLayout());
        //panel2.setSize(200,10);

        panel2.add(minButton, BorderLayout.NORTH);



        window.pack();

        //Разместим программу по центру
        //window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public Project() throws IOException
    {
        super("GridLayoutTest");
        setSize(320, 320);
        setLocation(100, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        // Вспомогательная панель
        JPanel grid = new JPanel();

        /*
         * Первые два параметра конструктора GridLayout определяют количество
         * строк и столбцов в таблице. Вторые 2 параметра - расстояние между
         * ячейками по горизонтали и вертикали
         */
        GridLayout layout = new GridLayout(5, 1, 5, 12);
        grid.setLayout(layout);
        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JComboBox<Integer> type = new JComboBox<Integer>(
                new Integer[] {1, 2, 3});
        JComboBox<String> dependency = new JComboBox<String>(
                new String[] {"4", "5", "6"});
        settingsPanel.add(type);
        settingsPanel.add(dependency);
        grid.add(settingsPanel);

        BufferedImage myPicture = ImageIO.read(new File("src\\img\\1.jpg"));
        ImageIcon imageIcon = new ImageIcon(myPicture);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        JLabel picLabel = new JLabel(imageIcon);
        grid.add(picLabel);


        JPanel calcPanel = new JPanel();
        calcPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel inputLabel = new JLabel("2 +");
        JTextField input = new JTextField("", 10);
        JButton calcButton = new JButton("Расчет");


         calcPanel.add(inputLabel);
         calcPanel.add(input);
         calcPanel.add(calcButton);
         grid.add(calcPanel);


        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(1, 2, 5, 10));

        DefaultListModel<String> result1Model = new DefaultListModel<String>();
        JList<String> result1 = new JList<String>(result1Model);
        resultPanel.add(new JScrollPane(result1));

        JPanel col2Grid = new JPanel();
        col2Grid.setLayout(new GridLayout(2, 1, 5, 10));
        JTextArea result2 = new JTextArea();
        JTextArea messageArea = new JTextArea();
        col2Grid.add(result2);
        col2Grid.add(messageArea);

        resultPanel.add(col2Grid);

        grid.add(resultPanel);


        JTextArea result3 = new JTextArea();
        grid.add(result3);

        // Размещаем нашу панель в панели содержимого
        getContentPane().add(grid);



        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String inputText = input.getText();
                int inputNumber = Integer.parseInt(inputText);

                Calculator calculator = new Calculator();
                int result = calculator.calc(2, inputNumber);

                result1Model.addElement("2");
                result1Model.addElement(Integer.toString(inputNumber));
                result1Model.addElement(Integer.toString(result));

            }
        });


        // Устанавливаем оптимальный размер окна
        pack();
        // Открываем окно
        setVisible(true);
    }

    //Запускаем
    public static void main(String[] args) throws IOException
    {
        new Project();
    }

}