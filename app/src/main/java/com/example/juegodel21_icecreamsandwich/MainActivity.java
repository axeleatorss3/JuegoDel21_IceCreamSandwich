package com.example.juegodel21_icecreamsandwich;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imagenes [][] ;
    private Button btnCarta, btnReiniciar;
    private TextView txtGanador;
    private int contador1, contador2, acum1, acum2,aleTemp;
    private int contSimbCompu, contSimbJugador;
    private int numerosDeCartas1 [][];
    private int numerosDeCartas2 [][];
    private int repetidoJugador, repetidoComputadora;

    public MainActivity(){
        numerosDeCartas1 = new int[2][5];
        numerosDeCartas2 = new int[2][5];
        imagenes = new ImageView[2][5];
        inicializarElPedo();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarImagesView();
        btnCarta = findViewById(R.id.btnCarta);
        btnReiniciar = findViewById(R.id.btnReiniciar);
        txtGanador = findViewById(R.id.ganadorTxtVw);
    }

    private void inicializarImagesView(){
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                int res = getResources().getIdentifier("imageView"+(i+1)+""+(j+1),"id",getPackageName());
                imagenes[i][j] = findViewById(res);
            }
        }
    }

    public void btnCartaPressed(View view){

        if(contador1 <= 5){

            contador1++;
            Drawable res;

            switch (contador1){
                case 1:
                    aleTemp = elegirCartaAleatoria();
                    res = getResources().getDrawable(aleTemp,null);
                    imagenes[0][0].setImageDrawable(res);
                    break;
                case 2:
                    aleTemp = elegirCartaAleatoria();
                    res = getResources().getDrawable(aleTemp,null);
                    imagenes[0][1].setImageDrawable(res);
                    break;
                case 3:
                    aleTemp = elegirCartaAleatoria();
                    res = getResources().getDrawable(aleTemp,null);
                    imagenes[0][2].setImageDrawable(res);
                    break;
                case 4:
                    aleTemp = elegirCartaAleatoria();
                    res = getResources().getDrawable(aleTemp,null);
                    imagenes[0][3].setImageDrawable(res);
                    break;
                case 5:

                    aleTemp = elegirCartaAleatoria();
                    res = getResources().getDrawable(aleTemp,null);
                    imagenes[0][4].setImageDrawable(res);
                    break;
            }
        }
        compuAccion();
        if(acum1 > 21){
            txtGanador.setText(txtGanador.getText()+" La computadora");
            btnCarta.setEnabled(false);
        }else if(acum1 == 21){
            txtGanador.setText(txtGanador.getText()+" El jugador");
            btnCarta.setEnabled(false);
        }else if(acum2 > 21){
            txtGanador.setText(txtGanador.getText()+ " El jugador");
            btnCarta.setEnabled(false);
        }else if(acum2 == 21){
            txtGanador.setText(txtGanador.getText()+" La computadora");
            btnCarta.setEnabled(false);

        }
    }

    public void compuAccion(){
        contador2++;
        if(contador2 <= 5){
            Drawable res;
            switch (contador2){
                case 1:
                    res = getResources().getDrawable(elegirCartaAleatoria2(),null);
                    imagenes[1][0].setImageDrawable(res);
                    break;
                case 2:
                    res = getResources().getDrawable(elegirCartaAleatoria2(),null);
                    imagenes[1][1].setImageDrawable(res);
                    break;
                case 3:
                    res = getResources().getDrawable(elegirCartaAleatoria2(),null);
                    imagenes[1][2].setImageDrawable(res);
                    break;
                case 4:
                    res = getResources().getDrawable(elegirCartaAleatoria2(),null);
                    imagenes[1][3].setImageDrawable(res);
                    break;
                case 5:
                    res = getResources().getDrawable(elegirCartaAleatoria2(),null);
                    imagenes[1][4].setImageDrawable(res);

                    if(acum1 < 21 && acum2 < 21){
                        if(21 - acum1 > 21 - acum2){
                            txtGanador.setText(txtGanador.getText()+" La computadora");
                            btnCarta.setEnabled(false);
                        }else{
                            txtGanador.setText(txtGanador.getText()+" El jugador");
                            btnCarta.setEnabled(false);
                        }
                    }
                    break;
            }
        }
    }

    private int aletaorioImagenes(){
        return  (int)(Math.random() * (13-1)) + 1;
    }

    private int aleatorioSimbolos(){
        //Trebol, diamante, corazon, espada
        return  (int)(Math.random() * (4-1)) + 1;
    }

    private int elegirCartaAleatoria(){
        //Trebol = 1, Diamante = 2, Corazon = 3, Espada = 4
        //As = 1, 2,3,4,5,6,7,8,9,10,Joto = 11,Queen = 12,King = 13
        int n = 0;
        int n2 = 0;
        int carta = 0;
        boolean correcto = true;


        n = aletaorioImagenes();
        acum1 = acum1 + n;


        //Si ya se repitio 4 veces el mismo numero entrara a un ciclo hasta que sea diferente el
        //quinto
        if(repetidoJugador == 4){
            do{
               n = aletaorioImagenes();
            }while(numerosDeCartas1[0][3] != numerosDeCartas1[0][2]);
        }else{
            if(contSimbJugador > 0){
                if(numerosDeCartas1[0][contSimbJugador] == numerosDeCartas1[0][contSimbJugador-1]){
                    repetidoJugador++;
                }
            }
        }

        switch (n){
            case 1:
                n2 = aleatorioSimbolos();
                switch (n2){
                    case 1:
                        carta = R.drawable.ac;
                        break;
                    case 2:
                        carta =   R.drawable.ad;
                        break;
                    case 3:
                        carta =   R.drawable.ah;
                        break;
                    case 4:

                        carta =  R.drawable.as;
                        break;
                }
                break;
            case 2:
                    do{
                        correcto = true;
                        n2 = aleatorioSimbolos();
                        for(int i = 0 ; i < contSimbJugador ; i ++){
                            if(numerosDeCartas1[0][i] == n){
                                if(numerosDeCartas1[1][i] == n2){
                                    correcto = false;
                                }
                            }
                        }
                    }while(correcto == false);
                    switch (n2){
                    case 1:
                        carta =  R.drawable.dosc;
                    break;
                    case 2:
                        carta =   R.drawable.dosd;
                    break;
                    case 3:
                        carta =   R.drawable.dosh;
                    break;
                    case 4:
                        carta =  R.drawable.doss;
                    break;
                }
                break;
            case 3:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.tresc;
                    break;
                    case 2:
                        carta =   R.drawable.tresd;
                    break;
                    case 3:
                        carta =   R.drawable.tresh;
                    break;
                    case 4:
                        carta =  R.drawable.tress;
                    break;
                }
                break;
            case 4:
                n2 = aleatorioSimbolos();
                switch (n2){
                    case 1:
                        carta =  R.drawable.cuatroc;
                    break;
                    case 2:
                        carta =   R.drawable.cuatrod;
                    break;
                    case 3:
                        carta =   R.drawable.cuatroh;
                    break;
                    case 4:
                        carta =  R.drawable.cuatros;
                    break;
                }
                break;
            case 5:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.cincoc;
                    break;
                    case 2:
                        carta =   R.drawable.cincod;
                    break;
                    case 3:
                        carta =   R.drawable.cincoh;
                    break;
                    case 4:
                        carta =  R.drawable.cincos;
                    break;
                }
                break;
            case 6:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.seisc;
                    break;
                    case 2:
                        carta =   R.drawable.seisd;
                    break;
                    case 3:
                        carta =   R.drawable.seish;
                    break;
                    case 4:
                        carta =  R.drawable.seiss;
                    break;
                }
                break;
            case 7:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.sietec;
                    break;
                    case 2:
                        carta =   R.drawable.sieted;
                    break;
                    case 3:
                        carta =   R.drawable.sieteh;
                    break;
                    case 4:
                        carta =  R.drawable.sietes;
                    break;
                }
                break;
            case 8:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.ochoc;
                    break;
                    case 2:
                        carta =   R.drawable.ochod;
                    break;
                    case 3:
                        carta =   R.drawable.ochoh;
                    break;
                    case 4:
                        carta =  R.drawable.ochos;
                    break;
                }
                break;
            case 9:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.nuevec;
                    break;
                    case 2:
                        carta =   R.drawable.nueved;
                    break;
                    case 3:
                        carta =   R.drawable.nueveh;
                    break;
                    case 4:
                        carta =  R.drawable.nueves;
                    break;
                }
                break;
            case 10:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.diezc;
                    break;
                    case 2:
                        carta =   R.drawable.diezd;
                    break;
                    case 3:
                        carta =   R.drawable.diezh;
                    break;
                    case 4:
                        carta =  R.drawable.diezs;
                    break;
                }
                break;
            case 11:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.jc;
                    break;
                    case 2:
                        carta =   R.drawable.jd;
                    break;
                    case 3:
                        carta =   R.drawable.jh;
                    break;
                    case 4:
                        carta =  R.drawable.js;
                    break;
                }
                break;
            case 12:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.qc;
                    break;
                    case 2:
                        carta =   R.drawable.qd;
                    break;
                    case 3:
                        carta =   R.drawable.qh;
                    break;
                    case 4:
                        carta =  R.drawable.qs;
                    break;
                }
                break;
            case 13:
                do{
                    correcto = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbJugador ; i ++){
                        if(numerosDeCartas1[0][i] == n){
                            if(numerosDeCartas1[1][i] == n2){
                                correcto = false;
                            }
                        }
                    }
                }while(correcto == false);
                switch (n2){
                    case 1:
                        carta =  R.drawable.kc;
                    break;
                    case 2:
                        carta =   R.drawable.kd;
                    break;
                    case 3:
                        carta =   R.drawable.kh;
                    break;
                    case 4:
                        carta =  R.drawable.ks;
                    break;
                }
                break;
        }
        //El subindice 0 sirve para alojar valores de numeros (1 a 13), el 1 para los simbolos (1 a  4)
        numerosDeCartas1[0][contSimbJugador] = n;
        numerosDeCartas1[1][contSimbJugador] = n2;
        //El iterador ira subiendo segun se vayan introduciendo datos
        contSimbJugador++;
        return  carta;
    }

    private int elegirCartaAleatoria2(){
        //Trebol = 1, Diamante = 2, Corazon = 3, Espada = 4
        //As = 1, 2,3,4,5,6,7,8,9,10,Joto = 11,Queen = 12,King = 13
        int n = 0;
        int n2 = 0;
        int carta = 0;
        n = aletaorioImagenes();
        acum2 = acum2 + n;
        boolean correcto2 = true;

        //Si ya se repitio 4 veces el mismo numero entrara a un ciclo hasta que sea diferente el
        //quinto
        if(repetidoComputadora == 4){
            do{
                n = aletaorioImagenes();
            }while(numerosDeCartas2[0][3] != numerosDeCartas2[0][2]);
        }else{
            if(contSimbCompu > 0){
                if(numerosDeCartas2[0][repetidoComputadora] == numerosDeCartas2[0][contSimbCompu-1]){
                    repetidoComputadora++;
                }
            }
        }

        switch (n){
            case 1:
                n2 = aleatorioSimbolos();
                switch (n2){
                    case 1:
                        carta = R.drawable.ac;
                        break;
                    case 2:
                        carta =   R.drawable.ad;
                        break;
                    case 3:
                        carta =   R.drawable.ah;
                        break;
                    case 4:
                        carta =  R.drawable.as;
                        break;
                }
                break;
            case 2:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);                switch (n2){
                    case 1:
                        carta =  R.drawable.dosc;
                        break;
                    case 2:
                        carta =   R.drawable.dosd;
                        break;
                    case 3:
                        carta =   R.drawable.dosh;
                        break;
                    case 4:
                        carta =  R.drawable.doss;
                        break;
                }
                break;
            case 3:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);                switch (n2){
                    case 1:
                        carta =  R.drawable.tresc;
                        break;
                    case 2:
                        carta =   R.drawable.tresd;
                        break;
                    case 3:
                        carta =   R.drawable.tresh;
                        break;
                    case 4:
                        carta =  R.drawable.tress;
                        break;
                }
                break;
            case 4:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);                switch (n2){
                    case 1:
                        carta =  R.drawable.cuatroc;
                        break;
                    case 2:
                        carta =   R.drawable.cuatrod;
                        break;
                    case 3:
                        carta =   R.drawable.cuatroh;
                        break;
                    case 4:
                        carta =  R.drawable.cuatros;
                        break;
                }
                break;
            case 5:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);                switch (n2){
                    case 1:
                        carta =  R.drawable.cincoc;
                        break;
                    case 2:
                        carta =   R.drawable.cincod;
                        break;
                    case 3:
                        carta =   R.drawable.cincoh;
                        break;
                    case 4:
                        carta =  R.drawable.cincos;
                        break;
                }
                break;
            case 6:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.seisc;
                        break;
                    case 2:
                        carta =   R.drawable.seisd;
                        break;
                    case 3:
                        carta =   R.drawable.seish;
                        break;
                    case 4:
                        carta =  R.drawable.seiss;
                        break;
                }
                break;
            case 7:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.sietec;
                        break;
                    case 2:
                        carta =   R.drawable.sieted;
                        break;
                    case 3:
                        carta =   R.drawable.sieteh;
                        break;
                    case 4:
                        carta =  R.drawable.sietes;
                        break;
                }
                break;
            case 8:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.ochoc;
                        break;
                    case 2:
                        carta =   R.drawable.ochod;
                        break;
                    case 3:
                        carta =   R.drawable.ochoh;
                        break;
                    case 4:
                        carta =  R.drawable.ochos;
                        break;
                }
                break;
            case 9:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.nuevec;
                        break;
                    case 2:
                        carta =   R.drawable.nueved;
                        break;
                    case 3:
                        carta =   R.drawable.nueveh;
                        break;
                    case 4:
                        carta =  R.drawable.nueves;
                        break;
                }
                break;
            case 10:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.diezc;
                        break;
                    case 2:
                        carta =   R.drawable.diezd;
                        break;
                    case 3:
                        carta =   R.drawable.diezh;
                        break;
                    case 4:
                        carta =  R.drawable.diezs;
                        break;
                }
                break;
            case 11:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.jc;
                        break;
                    case 2:
                        carta =   R.drawable.jd;
                        break;
                    case 3:
                        carta =   R.drawable.jh;
                        break;
                    case 4:
                        carta =  R.drawable.js;
                        break;
                }
                break;
            case 12:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.qc;
                        break;
                    case 2:
                        carta =   R.drawable.qd;
                        break;
                    case 3:
                        carta =   R.drawable.qh;
                        break;
                    case 4:
                        carta =  R.drawable.qs;
                        break;
                }
                break;
            case 13:
                do{
                    correcto2 = true;
                    n2 = aleatorioSimbolos();
                    for(int i = 0 ; i < contSimbCompu ; i ++){
                        if(numerosDeCartas2[0][i] == n){
                            if(numerosDeCartas2[1][i] == n2){
                                correcto2 = false;
                            }
                        }
                    }
                }while(!correcto2);
                switch (n2){
                    case 1:
                        carta =  R.drawable.kc;
                        break;
                    case 2:
                        carta =   R.drawable.kd;
                        break;
                    case 3:
                        carta =   R.drawable.kh;
                        break;
                    case 4:
                        carta =  R.drawable.ks;
                        break;
                }
                break;
        }
            numerosDeCartas2[0][contSimbCompu] = n;
            numerosDeCartas2[1][contSimbCompu] = n2;
            contSimbCompu++;

        return  carta;
    }

    public void reiniciar(View view){
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                imagenes[i][j].setImageResource(R.drawable.blue_back);
            }
        }
        inicializarElPedo();
        btnCarta.setEnabled(true);
        txtGanador.setText("El ganador es: ");
    }

    private void inicializarElPedo(){
        contador1 = 0;
        contador2 = 0;
        acum1 = 0;
        acum2 = 0;
        aleTemp = 0;


        contSimbCompu = 0 ;
        contSimbJugador = 0 ;
        repetidoJugador = 1;
        repetidoComputadora = 1;
        for(int i = 0 ; i < 2 ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                numerosDeCartas1[i][j] = 0;
                numerosDeCartas2[i][j] = 0;
            }
        }
    }
}
