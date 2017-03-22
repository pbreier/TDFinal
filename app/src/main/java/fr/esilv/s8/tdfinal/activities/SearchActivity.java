package fr.esilv.s8.tdfinal.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.esilv.s8.tdfinal.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bSearch;
    private EditText mrecherche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        bSearch = (Button) findViewById(R.id.bSearch);
        mrecherche = (EditText) findViewById(R.id.editText);
        bSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final String request = mrecherche.getText().toString();
        VideoActivity.start(this, request);


    }
}
