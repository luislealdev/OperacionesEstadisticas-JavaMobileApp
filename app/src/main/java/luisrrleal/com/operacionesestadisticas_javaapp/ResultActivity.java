package luisrrleal.com.operacionesestadisticas_javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get elements
        TextView media_text = findViewById(R.id.media_text);
        TextView mediana_text = findViewById(R.id.mediana_text);
        TextView moda_text = findViewById(R.id.moda_text);

        TextView varianza_text = findViewById(R.id.varianza_text);
        TextView desviacion_text = findViewById(R.id.desviacion_text);
        TextView rango_text = findViewById(R.id.rango_text);


        Bundle bundle = getIntent().getExtras();

        //Set results
        media_text.setText("Media: " + String.valueOf(bundle.getString("media")));
        mediana_text.setText("Mediana: " + String.valueOf(bundle.getString("mediana")));
        moda_text.setText("Moda: " + String.valueOf(bundle.getString("moda")));
        varianza_text.setText("Varianza: " + String.valueOf(bundle.getString("varianza")));
        desviacion_text.setText("Desviación: "+ String.valueOf(bundle.getString("desviacion_estandar")));
        rango_text.setText("Rango: " + String.valueOf(bundle.getString("rango")));
    }
}