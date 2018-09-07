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
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edtNgaythu1, edtNgaythu2;
    Button btnTinhtoan;
    TextView txtKetqua;
    Calendar calendarNgaythu1, calendarNgaythu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNgaythu1 = findViewById(R.id.edittextNgaythu1);
        edtNgaythu2 = findViewById(R.id.edittextNgaythu2);
        btnTinhtoan = findViewById(R.id.buttonTinhngay);
        txtKetqua = findViewById(R.id.textviewKetqua);

        calendarNgaythu1 = Calendar.getInstance();
        calendarNgaythu2 = Calendar.getInstance();

        //Khi sử dụng calendar : tháng sẽ bị trừ đi 1

        edtNgaythu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDate(calendarNgaythu1,edtNgaythu1);

            }
        });
        edtNgaythu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetDate(calendarNgaythu2,edtNgaythu2);
            }
        });
        btnTinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int songay = (int) ((calendarNgaythu2.getTimeInMillis() - calendarNgaythu1.getTimeInMillis()) / (1000*60*60*24));
               if (songay > 0){
                   txtKetqua.setText(songay + " ngay");
               }
            }
        });
        //nội dung :
//            + ngày 2 : không được chọn ngày nhỏ hơn ngày số 1
//            + tính số ngày giữ 2 edittext
    }

    private <T extends Calendar> void GetDate(final T calendar, final EditText editText) {
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // su dung simpledateformat cho viec format lai gia tri cua ngay
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/y");
                calendar.set(year, month, dayOfMonth);
                editText.setText(simpleDateFormat.format(calendar.getTimeInMillis()));

            }
        }, nam, thang, ngay);
        if (calendar == calendarNgaythu2){
            datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis() + (1000 * 60 * 60 *24));
        }
        datePickerDialog.show();
    }
}
