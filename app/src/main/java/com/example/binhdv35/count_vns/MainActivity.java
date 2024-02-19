package com.example.binhdv35.count_vns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView tvOutput;
    private EditText edInput;
    private Button btnCount;

    private String[] myArray = {"aa", "aw", "ee", "oo", "dd", "w", "ow"}; //các kí tự cần đếm
    private CountVnCharaters countVnCharater = new CountVnCharaters();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        
        btnCount.setOnClickListener(v -> {
           countWork(); 
        });
    }

    private void countWork() {
        String strInput = edInput.getText().toString().trim();
        if (strInput.isEmpty()){
            Toast.makeText(this, "edit text is empty!", Toast.LENGTH_SHORT).show();
            tvOutput.setText("edit text is empty!");
        }else {
            tvOutput.setText(String.valueOf(countVnCharater.count(strInput,myArray)));
        }
    }

    private void initView() {
        tvOutput = findViewById(R.id.tv_output);
        edInput = findViewById(R.id.ed_input);
        btnCount = findViewById(R.id.btn_count);
    }
}