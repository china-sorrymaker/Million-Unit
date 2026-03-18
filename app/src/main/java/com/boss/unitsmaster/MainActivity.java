package com.boss.unitsmaster;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etInput = findViewById(R.id.et_input);
        Button btnConvert = findViewById(R.id.btn_convert);
        TextView tvResult = findViewById(R.id.tv_result);

        btnConvert.setOnClickListener(v -> {
            String valStr = etInput.getText().toString();
            if (valStr.isEmpty()) return;

            try {
                double meters = Double.parseDouble(valStr);
                
                // 转换公式
                double km = meters / 1000.0;
                double miles = meters * 0.00062137;
                double feet = meters * 3.28084;

                String result = getString(R.string.res_km) + String.format(Locale.getDefault(), "%.4f", km) + "\n"
                              + getString(R.string.res_mile) + String.format(Locale.getDefault(), "%.4f", miles) + "\n"
                              + getString(R.string.res_feet) + String.format(Locale.getDefault(), "%.2f", feet);
                
                tvResult.setText(result);
            } catch (Exception e) {
                tvResult.setText("Error");
            }
        });
    }
}
