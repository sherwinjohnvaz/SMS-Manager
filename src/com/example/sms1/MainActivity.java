package com.example.sms1;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText jetmobno,jetmsg;
	String smsg,smobno;
	SmsManager mgr;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jetmobno=(EditText)findViewById(R.id.etmobno);
        jetmsg=(EditText)findViewById(R.id.etmsg);
    }

    private boolean getData() {
        boolean flag = false;
        flag = getMsg();
        if(flag)
            flag = getMobno();
      return flag;
    }
        private boolean getMsg(){
        boolean flag=false;
        try
        {
        	if(flag)
        		
        	{
        	     smsg = jetmsg.getText().toString();
                 if(smsg.length() > 0)
                flag=true;
                 else
                     Toast.makeText(MainActivity.this,"Enter Msg",Toast.LENGTH_SHORT).show();       
             }
        }
             catch (Exception e) {
          Toast.makeText(MainActivity.this, "Enter Message Again!", Toast.LENGTH_SHORT).show();
             }
         return flag;
        	}
       private boolean getMobno()
       {
    	   boolean flag=false;
    	   try
    	   {
    		   if(flag)
    		   {
    			   smobno=jetmobno.getText().toString();
    			   if(smobno.length()>0)
    			   flag=true;
    			   else
    				   Toast.makeText(getApplicationContext(), "Error in Mobno",Toast.LENGTH_LONG).show();
    		   }
    	   }
    	   catch(Exception e)
    	   {
    		   Toast.makeText(getApplicationContext(), "Error In fetching Mobno!",Toast.LENGTH_LONG).show();
    	   }
    	   return flag;
       }
    


  
  public void dosendmsg(View v)
  {
	  try {
		  boolean flag=getData();
		  if(flag)
		  {
			  mgr=SmsManager.getDefault();
				mgr.sendTextMessage(smobno, null,smsg, null, null);
			   Toast.makeText(getApplicationContext(), "Message Has Been Sent",Toast.LENGTH_LONG).show();
		  }
	  }
	  catch(Exception e)
	  {
		  Toast.makeText(getApplicationContext(), "Error in msg"+e.toString(),Toast.LENGTH_LONG).show();
	  }
  }
  public void dosenddata(View v)
  {
	  try {
		  boolean flag=getData();
		  if(flag)
		  {
			Intent intent=new Intent(MainActivity.this,NextPage.class);
			intent.putExtra("Phone", smobno);
			intent.putExtra("Msg", smsg);
		    startActivity(intent);
		  }
	  }
	  catch(Exception e)
	  {
		  Toast.makeText(getApplicationContext(), "Error in Sending msg"+e.toString(),Toast.LENGTH_LONG).show();
	  }
  }
}
