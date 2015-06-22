package com.laboratorio2.marcelo.laboratorio7_2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/***
 * @author Marcelo Vieira
 */
public class Principal_Activity extends ActionBarActivity {

    private TextView operacaoTextView;
    private TextView motoTextView;
    private Button btnBuscar;
    private SeekBar seekMaximo;
    private SeekBar seekrMinimo;

    private Object operacao;
    private String moto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_);

        operacaoTextView = (TextView) findViewById(R.id.operacaoTextView);
        motoTextView = (TextView) findViewById(R.id.motoTextView);
        seekMaximo = (SeekBar) findViewById(R.id.seekBar);
        seekrMinimo = (SeekBar) findViewById(R.id.seekBar2);

        operacaoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });

        motoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(2);
            }
        });

       /* btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (seekrMinimo.getProgress() >= seekMaximo.getProgress()) {
                    showDialog(3);
           //     }
            }
        });*/

    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        AlertDialog.Builder mont = new AlertDialog.Builder(this);
        if (id == 1)
        {
            mont
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setTitle("Operação")
                    .setSingleChoiceItems(new CharSequence[]
                            {"Comprar", "Vender", "Alugar"}, 0,
                            new DialogInterface.OnClickListener(){
                                public void onClick (DialogInterface dialog, int qual){
                                    operacao = qual;
                                }
                            })
                    .setPositiveButton("Confirmar",null);
        }
        else if (id ==2)
        {
            mont
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setTitle("Escolha as motos")
                    .setMultiChoiceItems(new CharSequence[]
                                    {"Zelda", "Donkey Kong", "Mario", "StarFox", "Metroid"},
                            new boolean[]{true, false, false, false, false},
                            new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                }
                            })
                    .setPositiveButton("Confirmar", null);
        }
        else if (id ==3)
        {
            mont
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Valor mínimo deve ser menor que o Valor máximo")
                    .setPositiveButton("OK", null);
        }
        return mont.create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
