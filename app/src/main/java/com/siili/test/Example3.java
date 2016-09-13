package com.siili.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Example3 extends AppCompatActivity {

    @BindView(R.id.incoming_result)
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.outgoing)
    void outgoingClicked() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));
    }

    @OnClick(R.id.incoming)
    void incomingClicked() {
        pickContact();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_CONTACT_REQUEST && resultCode == RESULT_OK) {
            result.setText(data.getData().toString());
        }
    }

    static final int PICK_CONTACT_REQUEST = 1;  // The request code

    private void pickContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

}
