package post_rian;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DatePicker //extends JFrame
{

    JButton[] btn = new JButton[49];
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    ;
  JLabel lbl = new JLabel("", JLabel.CENTER);
    String day = "";//added
    JDialog d;
    //public DatePickerSimple()

    public DatePicker(JFrame parent) {
        //buildGUI();
        //setDates();//moved
        //}
        //public void buildGUI()
        //public void buildGUI(JFrame parent)
        //{
        //setLocation(300,100);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        d = new JDialog();
        d.setModal(true);
        String[] header = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        JPanel midPanel = new JPanel(new GridLayout(7, 7));
        midPanel.setPreferredSize(new Dimension(400, 400));
        for (int x = 0; x < btn.length; x++) {
            final int selection = x;
            btn[x] = new JButton();
            btn[x].setFocusPainted(false);
            if (x > 6) {
                btn[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        //displayDatePicked(btn[selection].getActionCommand());}});
                        day = btn[selection].getActionCommand();
                        d.dispose();
                    }
                });
            }
            if (x < 7) {
                btn[x].setFont(new Font("Lucida", Font.PLAIN, 10));
                btn[x].setText(header[x]);
            }
            midPanel.add(btn[x]);
        }
        JPanel lowPanel = new JPanel(new GridLayout(1, 3));
        JButton prevBtn = new JButton("<< Previous");
        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                setDates();
            }
        });
        lowPanel.add(prevBtn);
        lowPanel.add(lbl);
        JButton nextBtn = new JButton("Next >>");
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                setDates();
            }
        });
        lowPanel.add(nextBtn);
        //getContentPane().add(midPanel,BorderLayout.CENTER);
        d.add(midPanel, BorderLayout.CENTER);
        //getContentPane().add(lowPanel,BorderLayout.SOUTH);
        d.add(lowPanel, BorderLayout.SOUTH);
        //pack();
        d.pack();
        d.setLocationRelativeTo(parent);
        setDates();//moved to here
        d.setVisible(true);

    }

    DatePicker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDates() {
        for (int x = 7; x < btn.length; x++) {
            btn[x].setText("");
        }
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
            btn[x].setText("" + day);
        }
        lbl.setText(sdf.format(cal.getTime()));
        //setTitle("Date Picker  - "+lbl.getText());
        d.setTitle("Date Picker  - " + lbl.getText());
    }
    //public void displayDatePicked(String day)

    public String displayDatePicked() {
        //if(day.equals("") == false)
        if (day.equals("")) {
            return day;
        }
        //{
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("EEEE d MMMM, yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        //JOptionPane.showMessageDialog(this,"You picked "+sdf.format(cal.getTime()));
        return sdf.format(cal.getTime());
        //}
    }
    //public static void main(String[] args){new DatePickerSimple().setVisible(true);}
}

//class Testing {
//
//    public void buildGUI() {
//        JLabel startLbl = new JLabel("Start Date:");
//        JLabel endLbl = new JLabel("End Date:");
//        final JLabel startDate = new JLabel("                                                                ", JLabel.CENTER);
//        final JLabel endDate = new JLabel("", JLabel.CENTER);
//        JButton startBtn = new JButton("...");
//        JButton endBtn = new JButton("...");
//        startBtn.setMargin(new Insets(0, 0, 0, 0));
//        endBtn.setMargin(new Insets(0, 0, 0, 0));
//        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
//        JPanel midPanel = new JPanel(new GridLayout(2, 1));
//        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
//        leftPanel.add(startLbl);
//        leftPanel.add(endLbl);
//        midPanel.add(startDate);
//        midPanel.add(endDate);
//        rightPanel.add(startBtn);
//        rightPanel.add(endBtn);
//        final JFrame f = new JFrame();
//        f.getContentPane().add(leftPanel, BorderLayout.WEST);
//        f.getContentPane().add(midPanel, BorderLayout.CENTER);
//        f.getContentPane().add(rightPanel, BorderLayout.EAST);
//        f.pack();
//        f.setLocationRelativeTo(null);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setVisible(true);
//        startBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae) {
//                startDate.setText(new DatePickerSimple(f).displayDatePicked());
//            }
//        });
//        endBtn.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent ae) {
//                endDate.setText(new DatePickerSimple(f).displayDatePicked());
//            }
//        });
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new Testing().buildGUI();
//            }
//        });
//    }
//}
