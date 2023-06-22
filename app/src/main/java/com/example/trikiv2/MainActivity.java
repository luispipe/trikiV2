package com.example.trikiv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView victoria;
    private Integer [] botones;

    private int [] tablero= new int[]{
            0,0,0,
            0,0,0,
            0,0,0
    };

    private int flagJugadas;
    private int turno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        victoria= findViewById(R.id.textViewVictoria);
        victoria.setVisibility(View.INVISIBLE);

        botones= new Integer[]{R.id.b1,R.id.b2,R.id.b3,
                               R.id.b4, R.id.b5,R.id.b6,
                               R.id.b7,R.id.b8,R.id.b9};
        if (ganador()) {
            victoria.setVisibility(View.VISIBLE);
        } else {
            if(finJuego()) {
                int numBoton = Arrays.asList(botones).indexOf(v.getId());
                turno = 1;
                if (tablero[numBoton] == 0) {
                    v.setBackgroundResource(R.drawable.xblack_background);
                    tablero[numBoton] = turno;
                    flagJugadas += 1;

                    if (finJuego()) {
                        maquina();
                        flagJugadas += 1;
                    } else {
                        //añadir mensaje
                    }
                }
            }
        }

    }



    public void maquina(){
        turno=-1;
        Random ran= new Random();
        int pos= ran.nextInt(tablero.length);
        while (tablero[pos]!=0){
            pos= ran.nextInt(tablero.length);
        }
        Button boton = findViewById(botones[pos]);
        boton.setBackgroundResource(R.drawable.oblack_background);
        tablero[pos]=turno;


    }

    public boolean finJuego(){
        if(flagJugadas<9){
            return true;
        }else{
            return false;
        }
    }

    public boolean ganador(){
        if(tablero[0]==turno && tablero[1]==turno && tablero[2]==turno){
            if (turno==1){
                Button boton1= findViewById(botones[0]);
                boton1.setBackgroundResource(R.drawable.ogreen_background);
            }else {

            }

            return true;
        } else if (tablero[3]==turno && tablero[4]==turno && tablero[5]==turno) {
            return true;
        }else if (tablero[6]==turno && tablero[7]==turno && tablero[8]==turno) {
            return true;
        }else if (tablero[0]==turno && tablero[3]==turno && tablero[6]==turno) {
            return true;
        }else if (tablero[1]==turno && tablero[4]==turno && tablero[7]==turno) {
            return true;
        }else if (tablero[2]==turno && tablero[5]==turno && tablero[8]==turno) {
            return true;
        }else if (tablero[0]==turno && tablero[4]==turno && tablero[8]==turno) {
            return true;
        }else if (tablero[2]==turno && tablero[4]==turno && tablero[6]==turno) {
            return true;
        }else {
            return false;
        }
    }




}
