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
        }else {
            tvOutput.setText(String.valueOf(countVnCharater(strInput)));
        }
    }

    private int countVnCharater(String strInput) {
        Set<String> stringSet = new HashSet<>();

        int count = 0;

        // Duyệt qua mảng các chuỗi
        for (String str : myArray) {
            // Nếu chuỗi con đã xuất hiện, không cần kiểm tra lại tiếp tục vòng for
            if (stringSet.contains(str)) {
                continue;
            }

            // Tìm vị trí xuất hiện đầu tiên của chuỗi con trong chuỗi đầu vào
            int index = strInput.indexOf(str);

            if (index != -1) {
                // Tăng biến đếm và thêm chuỗi con vào Set nếu tìm thấy
                count++;
                stringSet.add(str);
            }
        }
        return count;
    }

    private void initView() {
        tvOutput = findViewById(R.id.tv_output);
        edInput = findViewById(R.id.ed_input);
        btnCount = findViewById(R.id.btn_count);
    }
}