package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    private int [] skaiciai;


    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;

    public static void main(String[] args) {
	// write your code

        Main obj = new Main();

        obj.skaitymasIsFailo();
        obj.rezultatas();
    }

    public void failoAtidrymas(){
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        }catch (Exception kalida){

        }
    }
    public void skaitymasIsFailo(){
        int i = 0;
        skaiciai = new int[eiluciuKiekis()];

        failoAtidrymas();
        try{
            String imamaEilute;
            do{
                imamaEilute = _bufferis.readLine();
                skaiciai[i] = Integer.parseInt(imamaEilute);
                i++;
            }while(imamaEilute != null);
            _bufferis.close();
            _in.close();
        }catch (Exception klaida){
            System.out.println("Skaitymo klaida");
        }
    }
    public int eiluciuKiekis(){
        failoAtidrymas();

        int kiek = 0;
        String eilute;

        try {
            do {
                eilute = _bufferis.readLine();
                kiek++;
            }while(eilute != null);
            _bufferis.close();
            _in.close();
        }catch (Exception klaida){

        }
        kiek--;
        return kiek;
    }

    public void rikiavimasDidejimo(int [] masyvas){
        int tmp;
        for(int i = 0; i < masyvas.length - 1 ; i++){
            for (int j = i+1; j < masyvas.length; j++){
                if (masyvas[i] > masyvas[j]){
                    tmp = masyvas[i];
                    masyvas[i] = masyvas[j];
                    masyvas[j] = tmp;
                }
            }
        }
    }
    public void rezultatas (){
        rikiavimasDidejimo(skaiciai);

        System.out.println("Faile esantys skaiciai didejimo tvarka");
        for (int i = 0; i < skaiciai.length; i++){
            System.out.print(skaiciai[i]+ " ");
        }
        System.out.println();
    }

}
