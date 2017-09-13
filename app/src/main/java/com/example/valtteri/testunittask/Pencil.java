package com.example.valtteri.testunittask;


import android.graphics.Color;

import java.math.RoundingMode;

/**
 * Created by Valtteri on 13.9.2017.
 */

public class Pencil {
    private boolean PenCap;
    public static Color PenColor;
    private float RedInk = 100;
    private float BlackInk = 100;
    float divider = (float)0.01;
    int color;
    double usedInk;

    public Pencil() {
        PenCap = true;
        color = PenColor.BLACK;
    }
    public void PenCap(boolean c) {
        PenCap = c;
    }

    public boolean DrawLine(float linelength) {
         usedInk = linelength * divider ;
        usedInk = Math.round (usedInk * 10000.0) / 10000.0;
        if(PenCap == true) {
            return false;

        }
        else {
            if(color == PenColor.BLACK){
                if(BlackInk >= usedInk) {
                    BlackInk = BlackInk - (float)usedInk;
                    BlackInk = Math.round(BlackInk * (float)100.0) / (float)100.0;
                    return true;
                }
                else {
                    return false;
                }

            }
            else {
                if(RedInk >= usedInk) {
                    RedInk = RedInk - (float)usedInk;
                    RedInk = Math.round(RedInk * (float)100.0) / (float)100.0;
                    return true;
                }
                else {
                    return false;
                }

            }
        }
    }

    public boolean ChangeColor(int col) {
        color = col;
        return true;
    }
}
