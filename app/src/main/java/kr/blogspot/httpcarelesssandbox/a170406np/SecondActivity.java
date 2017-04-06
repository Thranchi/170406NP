package kr.blogspot.httpcarelesssandbox.a170406np;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
EditText et;
    final int _REQUEST_CODE=10;
    final int PICK_CONTACT_REQUEST=0;
    final int _RESULT_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et=(EditText)findViewById(R.id.et1);


        Intent intent=getIntent();
        String name = intent.getStringExtra("msg");
        et.setText(name);
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.putExtra("remakemsg", et.getText().toString());
        setResult(_RESULT_CODE,intent);

        finish();
    }
}
