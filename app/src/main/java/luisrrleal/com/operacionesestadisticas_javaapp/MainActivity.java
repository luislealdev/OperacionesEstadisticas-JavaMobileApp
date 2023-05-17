package luisrrleal.com.operacionesestadisticas_javaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText userText;
    private Button calculate_button;

    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = findViewById(R.id.user_input);
        calculate_button = findViewById(R.id.button);

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String[] data_array = userText.getText().toString().split(",");

        if (data_array.length < 5) {
            Toast.makeText(this, "Insert more than 4 inputs", Toast.LENGTH_SHORT);
        } else {
            //Ordenar arreglo
            Arrays.sort(data_array);

            //Sacar media
            double media = 0;
            for (int i = 0; i < data_array.length; i++) {
                media = media + Integer.parseInt(data_array[i]);
            }
            media = media / data_array.length;

            //Sacar mediana
            double mediana;
            int mitad = data_array.length / 2;
            // Si la longitud es par, se deben promediar los del centro
            if (data_array.length % 2 == 0) {
                mediana = (Integer.parseInt(data_array[mitad - 1]) + Integer.parseInt(data_array[mitad])) / 2;
            } else {
                mediana = Double.parseDouble(data_array[mitad]);
            }

            //Sacar moda
            double moda = 0;
            int aux = 0;
            for (int i = 0; i < data_array.length; i++) {
                int vecesQueSeRepite = 0;
                for (int j = 0; j < data_array.length; j++) {
                    if (data_array[i] == data_array[j])
                        vecesQueSeRepite++;
                    else {
                        break;
                    }
                }
                if (vecesQueSeRepite > aux) {
                    moda = Double.parseDouble(data_array[i]);
                    aux = vecesQueSeRepite;
                }
            }


            //Sacar varianza

            double varianza = 0;
            double suma_diferencias = 0;

            for (String num : data_array) {
                double diferencias = Double.parseDouble(num) - media;
                double squaredDifference = diferencias * diferencias;
                suma_diferencias += squaredDifference;
            }

            varianza = suma_diferencias / data_array.length;


            //Sacar desviación estándar
            double desviacion_estandar = 0;
            desviacion_estandar = Math.sqrt(varianza);


            //Sacar rando
            double rango;
            rango = Double.parseDouble(data_array[data_array.length - 1]) - Double.parseDouble(data_array[0]);


            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("media", df.format(media));
            intent.putExtra("mediana",  df.format(mediana));
            intent.putExtra("moda",  df.format(moda));
            intent.putExtra("varianza",  df.format(varianza));
            intent.putExtra("desviacion_estandar",  df.format(desviacion_estandar));
            intent.putExtra("rango",  df.format(rango));
            startActivity(intent);
        }
    }
}