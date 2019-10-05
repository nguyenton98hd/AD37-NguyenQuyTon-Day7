package com.example.ad37_nguyenquyton_day07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    String mName;
    EditText etName;
    Button btnAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etName = findViewById(R.id.edtName);
        btnAction = findViewById(R.id.save);
        final Intent intent = getIntent();

        mName = intent.getStringExtra("name");

        if (mName.equals("")) btnAction.setText("Add");
        else {
            btnAction.setText("Update");
            etName.setText(mName);
        }

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("nameAdd", etName.getText().toString());

                //trả về kết quả Result cho mainActivity
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}
