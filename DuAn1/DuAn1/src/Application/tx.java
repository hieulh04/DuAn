/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;


import View.LonginUi;
import View.MeNuUi;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;


/**
 *
 * @author hung duong
 */
public class tx {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
        }
        new LonginUi().setVisible(true);
    }
}
