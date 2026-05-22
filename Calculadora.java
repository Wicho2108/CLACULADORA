/// LUIS RICARDO VEGA HERNANDEZ

package com.example.miapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculadora extends Activity implements View.OnClickListener {

    Button[] btnDigitos = new Button[10];
    boolean pintarPunto = true;

    EditText pantalla;

    double op1, op2, res;

    Button btnSuma, btnResta, btnMulti, btnDiv;
    Button btnPunto, btnIgual, btnClear;

    String operacion = "";

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout panelPrincipal = new LinearLayout(this);
        panelPrincipal.setBackgroundColor(Color.BLACK);
        panelPrincipal.setOrientation(LinearLayout.VERTICAL);

        LinearLayout panelPantalla = new LinearLayout(this);
        panelPantalla.setOrientation(LinearLayout.VERTICAL);
        panelPantalla.setBackgroundColor(Color.GRAY);
        panelPantalla.setMinimumHeight(200);

        TextView cuadro = new TextView(this);
        cuadro.setBackgroundColor(Color.BLUE);
        cuadro.setText(" ");
        cuadro.setMinimumHeight(50);

        pantalla = new EditText(this);
        pantalla.setTextColor(Color.WHITE);
        pantalla.setTextSize(40);
        pantalla.setMaxLines(1);
        pantalla.setTextAlignment(EditText.TEXT_ALIGNMENT_TEXT_END);

        panelPantalla.addView(cuadro);
        panelPantalla.addView(pantalla);

        LinearLayout panelControles = new LinearLayout(this);
        panelControles.setBackgroundColor(Color.RED);

        LinearLayout panelBotones1 = new LinearLayout(this);
        panelBotones1.setBackgroundColor(Color.WHITE);
        panelBotones1.setOrientation(LinearLayout.VERTICAL);

        LinearLayout panelBotones2 = new LinearLayout(this);
        panelBotones2.setOrientation(LinearLayout.VERTICAL);
        panelBotones2.setBackgroundColor(Color.GREEN);

        LinearLayout li1 = new LinearLayout(this);
        LinearLayout li2 = new LinearLayout(this);
        LinearLayout li3 = new LinearLayout(this);
        LinearLayout li4 = new LinearLayout(this);

        for(int i=0;i<=9;i++){

            btnDigitos[i]=new Button(this);
            btnDigitos[i].setText(String.valueOf(i));
            btnDigitos[i].setOnClickListener(this);

            switch(i){
                case 0: li4.addView(btnDigitos[i]); break;
                case 1:
                case 2:
                case 3: li3.addView(btnDigitos[i]); break;
                case 4:
                case 5:
                case 6: li2.addView(btnDigitos[i]); break;
                case 7:
                case 8:
                case 9: li1.addView(btnDigitos[i]); break;
            }
        }

        btnPunto=new Button(this);
        btnPunto.setText(".");
        btnPunto.setOnClickListener(this);

        btnIgual=new Button(this);
        btnIgual.setText("=");
        btnIgual.setOnClickListener(this);

        btnClear=new Button(this);
        btnClear.setText("C");
        btnClear.setOnClickListener(this);

        btnSuma=new Button(this);
        btnSuma.setText("+");
        btnSuma.setOnClickListener(this);

        btnResta=new Button(this);
        btnResta.setText("-");
        btnResta.setOnClickListener(this);

        btnMulti=new Button(this);
        btnMulti.setText("*");
        btnMulti.setOnClickListener(this);

        btnDiv=new Button(this);
        btnDiv.setText("/");
        btnDiv.setOnClickListener(this);

        li4.addView(btnPunto);
        li4.addView(btnIgual);
        li4.addView(btnClear);

        panelBotones1.addView(li1);
        panelBotones1.addView(li2);
        panelBotones1.addView(li3);
        panelBotones1.addView(li4);

        panelBotones2.addView(btnSuma);
        panelBotones2.addView(btnResta);
        panelBotones2.addView(btnMulti);
        panelBotones2.addView(btnDiv);

        panelControles.addView(panelBotones1);
        panelControles.addView(panelBotones2);
        panelPrincipal.addView(panelPantalla);
        panelPrincipal.addView(panelControles);

        setContentView(panelPrincipal);
    }

    public void onClick(View v){

        for(int i=0;i<=9;i++){
            if(v.equals(btnDigitos[i])){
                pantalla.setText(String.valueOf(pantalla.getText()) + i);
            }
        }

        if(v.equals(btnPunto)){
            if(pintarPunto){
                pantalla.setText(String.valueOf(pantalla.getText()) + ".");
                pintarPunto=false;
            }
        }
///LUIS RICARDO VEGA HERNANDEZ
        if(v.equals(btnClear)){
            pantalla.setText("");
            op1=0;
            op2=0;
            res=0;
            operacion="";
            pintarPunto=true;
        }

        if(v.equals(btnSuma)||v.equals(btnResta)||v.equals(btnMulti)||v.equals(btnDiv)){

            if(!pantalla.getText().toString().equals("")){

                op1=Double.parseDouble(pantalla.getText().toString());

                if(v.equals(btnSuma)) operacion="+";
                if(v.equals(btnResta)) operacion="-";
                if(v.equals(btnMulti)) operacion="*";
                if(v.equals(btnDiv)) operacion="/";

                pantalla.setText("");
                pintarPunto=true;
            }
        }

        if(v.equals(btnIgual)){

            if(!pantalla.getText().toString().equals("")){

                op2=Double.parseDouble(pantalla.getText().toString());

                if(operacion.equals("+")) res=op1+op2;
                if(operacion.equals("-")) res=op1-op2;
                if(operacion.equals("*")) res=op1*op2;

                if(operacion.equals("/")){
                    if(op2!=0) res=op1/op2;
                    else{
                        pantalla.setText("Error");
                        return;
                    }
                }

                pantalla.setText(String.valueOf(res));
            }
        }
    }
}

/// LUIS RICARDO VEGA HERNANDEZ