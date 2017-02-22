package co.edu.udea.compumovil.gr02_20171.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class ContactInfo extends AppCompatActivity {

    private EditText telefono, direccion, email;
    private AutoCompleteTextView pais;
    private AutoCompleteTextView ciudad;
    private String stringIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        telefono = (EditText) findViewById(R.id.telefono);
        direccion = (EditText) findViewById(R.id.direccion);
        email = (EditText) findViewById(R.id.email);
        pais = (AutoCompleteTextView) findViewById(R.id.pais);
        ciudad = (AutoCompleteTextView) findViewById(R.id.ciudad);

        // Esto es para el autocomplete de paises
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.pais);
        String countries[] = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        textView.setAdapter(adapter);

        // Esto es para el autocomplete de ciudades
        AutoCompleteTextView textView2 = (AutoCompleteTextView) findViewById(R.id.ciudad);
        String cities[] = getResources().getStringArray(R.array.cities_array);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        textView2.setAdapter(adapter2);

        Intent intent= getIntent(); // gets the previously created intent
        stringIntent = intent.getStringExtra("KEY");
    }

    public String i18nString(int source_string) {
        return getResources().getString(source_string);
    }

    public void siguienteAct(View view) {

        stringIntent = stringIntent + i18nString(R.string.phone) + ": " + telefono.getText() + "\n" +
                i18nString(R.string.address) + ": " + direccion.getText() + "\n" +
                i18nString(R.string.email) + ": " + email.getText() + "\n" +
                i18nString(R.string.country) + ": " + pais.getText() + "\n" +
                i18nString(R.string.city) + ": " + ciudad.getText() + "\n";


        Intent intent = new Intent(ContactInfo.this, OtherInfo.class);
        intent.putExtra("KEY", stringIntent);
        startActivity(intent);
    }
}
