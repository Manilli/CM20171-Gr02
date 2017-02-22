package co.edu.udea.compumovil.gr02_20171.lab1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class OtherInfo extends AppCompatActivity {


    private CheckBox leer, vertv, bailar, cantar, nadar;
    private TextView results;
    private String leerS, vertvS, bailarS, cantarS, nadarS;
    private String stringIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        leer = (CheckBox) findViewById(R.id.leer);
        vertv = (CheckBox) findViewById(R.id.vertv);
        bailar = (CheckBox) findViewById(R.id.bailar);
        cantar = (CheckBox) findViewById(R.id.cantar);
        nadar = (CheckBox) findViewById(R.id.nadar);
        results = (TextView) findViewById(R.id.results);

        leer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) leerS = i18nString(R.string.yes_word);
                else leerS = i18nString(R.string.no_word);
            }
        });

        vertv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) vertvS = i18nString(R.string.yes_word);
                else vertvS = i18nString(R.string.no_word);
            }
        });

        bailar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) bailarS = i18nString(R.string.yes_word);
                else bailarS = i18nString(R.string.no_word);
            }
        });

        cantar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) cantarS = i18nString(R.string.yes_word);
                else cantarS = i18nString(R.string.no_word);
            }
        });

        nadar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) nadarS = i18nString(R.string.yes_word);
                else nadarS = i18nString(R.string.no_word);
            }
        });

        Intent intent= getIntent(); // gets the previously created intent
        stringIntent = intent.getStringExtra("KEY");
    }

    public void mostrarContacto(View view) {
        stringIntent = stringIntent + i18nString(R.string.read) + ": " + leerS + "\n" +
                i18nString(R.string.watchtv) + ": " + vertvS + "\n" +
                i18nString(R.string.dance) + ": " + bailarS + "\n" +
                i18nString(R.string.sing) + ": " + cantarS + "\n" +
                i18nString(R.string.swim) + ": " + nadarS;
        results.setText(stringIntent);
    }
        /*if (nombres.getText().toString().isEmpty() || pais.getText().toString().isEmpty() ||
                telefono.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
            results.setText(i18nString(R.string.invalid_form_fields));
        } else {
            results.setText(i18nString(R.string.names) + ": " + nombres.getText() + "\n" +
                    i18nString(R.string.last_names) + ": " + apellidos.getText() + "\n" +
                    i18nString(R.string.sex) + ": " + sexoS + "\n" +
                    i18nString(R.string.birthdate) + ": " + fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonth() + "/" + fechaNacimiento.getYear() + "\n" +
                    i18nString(R.string.country) + ": " + pais.getText() + "\n" +
                    i18nString(R.string.phone) + ": " + telefono.getText() + "\n" +
                    i18nString(R.string.address) + ": " + direccion.getText() + "\n" +
                    i18nString(R.string.email) + ": " + email.getText() + "\n" +
                    i18nString(R.string.school_grade) + ": " + gradoEscolaridad.getSelectedItem() + "\n" +
                    i18nString(R.string.is_favorite) + ": " + favoritoS
            );
        }
    }*/

    private String i18nString(int source_string) {
        return getResources().getString(source_string);
    }
}
