package com.example.pierre.jeuxadeux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int scoreJoueur1 = 0;
    int scoreJoueur2 = 0;

    TextView textJoueur1;
    TextView textJoueur2;

    boolean jeuEnCours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pour Joueurs
        Button buttonJ1 = (Button)findViewById(R.id.button_joueur1);
        Button buttonJ2 = (Button)findViewById(R.id.button_joueur2);

        //Reset
        Button reset = (Button)findViewById(R.id.reset);

        //Jeu
        textJoueur1 = (TextView)findViewById(R.id.scorejoueur1);
        textJoueur2 = (TextView)findViewById(R.id.scorejoueur2);


        textJoueur1.setText("Le score est : " + scoreJoueur1);
        textJoueur2.setText("Le score est : " + scoreJoueur2);

        buttonJ1.setOnClickListener(this);
        buttonJ2.setOnClickListener(this);
        reset.setOnClickListener(this);

        reset();

    }

    public void reset(){
        jeuEnCours = true;
        scoreJoueur1 = 0;
        scoreJoueur2 = 0;
        textJoueur1.setText("Le score est : " + scoreJoueur1);
        textJoueur2.setText("Le score est : " + scoreJoueur2);
        Toast.makeText(MainActivity.this, "Commencez !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.button_joueur1:
                //j1 clique
                if (jeuEnCours) {
                    scoreJoueur1++;
                    textJoueur1.setText("Le score est : " + scoreJoueur1);
                    if (scoreJoueur1 == 10) {
                        Toast.makeText(MainActivity.this, "Joueur 1 à gagné", Toast.LENGTH_SHORT).show();
                        jeuEnCours = false;
                    }
                }
                break;
            case R.id.button_joueur2:
                //j2 clique
                if (jeuEnCours) {
                    scoreJoueur2++;
                    textJoueur2.setText("Le score est : " + scoreJoueur2);
                    if (scoreJoueur2 == 10) {
                        Toast.makeText(MainActivity.this, "Joueur 2 à gagné", Toast.LENGTH_SHORT).show();
                        jeuEnCours = false;
                    }
                }
                break;
            case R.id.reset:
                reset();
                break;
        }
    }

}
