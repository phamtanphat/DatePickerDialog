package com.example.admin.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtNgaythu1,edtNgaythu2;
    Button btnTinhtoan;
    TextView txtKetqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNgaythu1 = findViewById(R.id.edittextNgaythu1);
        edtNgaythu2 = findViewById(R.id.edittextNgaythu2);
        btnTinhtoan = findViewById(R.id.buttonTinhngay);
        txtKetqua = findViewById(R.id.textviewKetqua);


        //Khi sử dụng calendar : tháng sẽ bị trừ đi 1

        edtNgaythu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edtNgaythu1.setText(dayOfMonth + "/" + month + "/" + year);

                    }
                },Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH) + 1,Calendar.getInstance().get(Calendar.DATE));
                datePickerDialog.show();
            }
        });
        //nội dung :
//            + ngày 2 : không được chọn ngày nhỏ hơn ngày số 1
//            + tính số ngày giữ 2 edittext
    }
}
