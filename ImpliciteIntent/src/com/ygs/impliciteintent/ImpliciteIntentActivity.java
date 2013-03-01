package com.ygs.impliciteintent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

/**
 * hitesh kamani
 * @author Hit
 *
 */
public class ImpliciteIntentActivity extends Activity implements OnClickListener {

	Button btncall,btndial,btnbrows,btnemail,btncontact,btnsms;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicite_intent);
        btncall=(Button)findViewById(R.id.btn_call);
        btndial=(Button)findViewById(R.id.btn_dial);
        btnbrows=(Button)findViewById(R.id.btn_browser);
        btnemail=(Button)findViewById(R.id.btn_email);
        btncontact=(Button)findViewById(R.id.btn_contact);
        btnsms=(Button)findViewById(R.id.btn_sms);
        
        btncall.setOnClickListener(this);
        btndial.setOnClickListener(this);
        btnbrows.setOnClickListener(this);
        btnemail.setOnClickListener(this);
        btncontact.setOnClickListener(this);
        btnsms.setOnClickListener(this);
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btncall)
		{
			Intent intent=new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:123456"));
			startActivity(intent);
		}
		else
		{
			if(v==btndial)
			{
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:123456"));
				startActivity(intent);
			}
			else
			{
				if(v==btnbrows)
				{
					Intent intent=new Intent(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("http://www.google.com"));
					startActivity(intent);
				}
				else
				{
					if(v==btnemail)
					{
						Intent intent=new Intent(Intent.ACTION_SEND);
						intent.setType("text/plain");
						startActivity(intent);
					}
					else
					{
						if(v==btncontact)
						{
							Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
									//ContactsContract.Contacts.CONTENT_URI option for using data for view contact
							startActivity(intent);
						}
						else
						{
							if(v==btnsms)
							{
								Intent intent=new Intent(Intent.ACTION_SENDTO);
								intent.setData(Uri.parse("sms:1234"));
								startActivity(intent);
							}
						}
					}
					
				}
			}
		}
	}



    
}
