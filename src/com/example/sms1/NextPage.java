package com.example.sms1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class NextPage extends Activity {
TextView jtv;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    jtv=(TextView)findViewById(R.id.textView1);
   Intent i=getIntent();
   Bundle b=i.getExtras();
   String m=b.getString("Phone");
   String ms=b.getString("Msg");
   jtv.setText(m+""+ms);
}
}
