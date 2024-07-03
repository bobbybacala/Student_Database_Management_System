package stud_manage_system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    // reference variable for thread class object.
    Thread t;

    Splash() {

        // to add an image to the frame, we use the func 'getSystemResource' to use an
        // img on the system
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons_vit/opening.jpg"));
        // since img gets cropped we scale the image accordingly
        Image i2 = i1.getImage().getScaledInstance(1820, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // thread class object created.
        t = new Thread(this);
        t.start();

        // set the frame to be visible
        setVisible(true);

        // dynamic open to the frame, we set parameters accordingly.
        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);

            // pauses the program for 10ms for each iteration, for smooth transition of
            // frame opening.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }
    }

    // asbtract method implemented.
    public void run() {

        // holds the first frame for 7 seconds and then onto next frame.
        try {
            Thread.sleep(7000);
            setVisible(false);

            // Next Frame
            new Login();
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
