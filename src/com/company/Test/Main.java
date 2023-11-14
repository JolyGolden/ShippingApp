package com.company.Test;

import com.company.UI.Gui;
import com.company.containers.Container;
import com.company.methods.Calculation;
import items.*;
import items.Desktop;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //open thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui gui = new Gui();
                gui.setVisible(true);
            }
        });
    }
    //Nazar Zhanabergenov
}