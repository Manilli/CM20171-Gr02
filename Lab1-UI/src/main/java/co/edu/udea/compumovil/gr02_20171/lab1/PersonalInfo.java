package co.edu.udea.compumovil.gr02_20171.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class PersonalInfo extends AppCompatActivity {

    private EditText nombres, apellidos;
    private DatePicker fechaNacimiento;
    private Spinner gradoEscolaridad;
    private RadioGroup sexo;
    private String sexoS, stringIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        sexo = (RadioGroup) findViewById(R.id.sexo);
        sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.sexMas) sexoS = i18nString(R.string.male);
                else sexoS = i18nString(R.string.female);
            }
        });
        fechaNacimiento = (DatePicker) findViewById(R.id.fechaNac);
        gradoEscolaridad = (Spinner) findViewById(R.id.gradoEscolaridad);

        // Esto es para el spinner
        Spinner spinner = (Spinner) findViewById(R.id.gradoEscolaridad);
        ArrayAdapter<CharSequence> hobbieAdapter = ArrayAdapter.createFromResource(this,
                R.array.gradoEscolaridad_array, android.R.layout.simple_spinner_dropdown_item);
        hobbieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(hobbieAdapter);

        // set variables


    }
    public String i18nString(int source_string) {
        return getResources().getString(source_string);
    }


    public void siguienteAct(View view) {
        stringIntent = i18nString(R.string.names) + ": " + nombres.getText() + "\n" +
                i18nString(R.string.last_names) + ": " + apellidos.getText() + "\n" +
                i18nString(R.string.sex) + ": " + sexoS + "\n" +
                i18nString(R.string.birthdate) + ": " + fechaNacimiento.getDayOfMonth() + "/" +
                fechaNacimiento.getMonth() + "/" + fechaNacimiento.getYear() + "\n" +
                i18nString(R.string.school_grade) + ": " + gradoEscolaridad.getSelectedItem() + "\n";
        Intent intent = new Intent(PersonalInfo.this, ContactInfo.class);
        intent.putExtra("KEY",stringIntent);
        startActivity(intent);
    }
}
