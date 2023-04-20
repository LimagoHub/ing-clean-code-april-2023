package de.limago;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame  {

    public Main() {
        setSize(300, 300);
        addWindowListener(new MyWindowListener());
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        add(button);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }


    private void ausgabe() {
        System.out.println("Button wurde gedrückt");
    }

    private void beenden(){
        dispose();
    }

    class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(final WindowEvent e) {
            beenden();
        }
    }

}
