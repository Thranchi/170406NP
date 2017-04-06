package kr.blogspot.httpcarelesssandbox.a170406np;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    final int _REQUEST_CODE=10;
    final int PICK_CONTACT_REQUEST=0;
    final int _RESULT_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.tv1);
    }

    public void onClick(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("msg",tv.getText().toString());


        startActivityForResult(intent,_REQUEST_CODE);
    }

    public void onButtonClick(View v){
        if(v.getId()==R.id.b2){
            startActivityForResult(new Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI)
                    ,PICK_CONTACT_REQUEST);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==_REQUEST_CODE){
            if(resultCode==_RESULT_CODE){
                String msg=data.getStringExtra("remakemsg");
                tv.setText(msg);
            }
        }
        else if(requestCode==PICK_CONTACT_REQUEST){
            if(resultCode==_RESULT_CODE){
               startActivity(data);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
