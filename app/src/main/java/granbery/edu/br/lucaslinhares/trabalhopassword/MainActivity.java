package granbery.edu.br.lucaslinhares.trabalhopassword;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private PasswordGenerator generator = new PasswordGenerator();
    private Button gerar;
    private EditText tamanho;
    private TextView senhaGerada;
    private AlertDialog alerta;
    private CheckBox simbolos;
    private CheckBox numeros;
    private CheckBox maiusculas;
    private CheckBox minusculas;
    private ImageView fmg_png;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tamanho = findViewById(R.id.tamanho);
        senhaGerada = findViewById(R.id.senhaGerada);
        gerar = findViewById(R.id.gerar);
        simbolos = findViewById(R.id.simbolos);
        numeros = findViewById(R.id.numeros);
        maiusculas = findViewById(R.id.maiusculas);
        minusculas = findViewById(R.id.minusculas);
        fmg_png = findViewById(R.id.fmg_png);

        senhaGerada.setText("-");

        gerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (simbolos.isChecked() || numeros.isChecked() || maiusculas.isChecked() || minusculas.isChecked()) {
                    generator.setIncludeSymbols(simbolos.isChecked());
                    generator.setIncludeNumbers(numeros.isChecked());
                    generator.setIncludeUpperCase(maiusculas.isChecked());
                    generator.setIncludeLowerCase(minusculas.isChecked());
                    try {
                        generator.setSize(Integer.parseInt(tamanho.getText().toString()));
                        senhaGerada.setText(generator.generate());
                    } catch (Exception e) {
                        alert_error("Ops...","Insira um valor para o tamanho!");
                    }
                } else {
                    alert_error("Ops...","Selecione os conteúdos da senha!");
                }
            }
        });

        fmg_png.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_error("Feito por:","Lucas Linhares\n8SI1\nProfessor: Welington Veiga\nFaculdade Metodista Granbery");
            }
        });
    }

    private void alert_error(String titulo, String mensagem) {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle(titulo);
        //define a mensagem
        builder.setMessage(mensagem);
        //cria o AlertDialog
        alerta = builder.create();
        alerta.setCancelable(true);
        //Exibe
        alerta.show();
    }
}