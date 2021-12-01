package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitIntent extends AppCompatActivity {

    Button maps, wa, telegram, ig, fb, email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        //Listener Camera
        findViewById(R.id.btnCamera).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(i);
        });

        //set click listener untuk gallery
        //perform Gallery open action
        findViewById(R.id.btnGallery).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://media/external/images/media"));
            startActivity(i);
        });

        //set click listener browser
        findViewById(R.id.btnBrowser).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.google.com/"));
            startActivity(Intent.createChooser(i, "title"));
        });

        //set click listener contact
        findViewById(R.id.btnContact).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://contacts/people/"));
            startActivity(i);
        });

        final EditText et = findViewById(R.id.etNo);
        //set click listener Dial
        findViewById(R.id.btnDial).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + et.getText()));
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" + et.getText()));
            startActivity(i);

            startActivity(new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" + et.getText())));
        });

        maps = findViewById(R.id.btnMaps);
        wa = findViewById(R.id.btnWA);
        telegram = findViewById(R.id.btnTelegram);
        ig = findViewById(R.id.btnIG);
        fb = findViewById(R.id.btnFB);
        email = findViewById(R.id.btnEmail);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(getString(R.string.Linkmaps));
            }
        });
        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://wa.me/6282132310801");
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://telegram.me/dewianisaist");
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/amikomjogja/");
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("fb://profile/"));
                startActivity(i);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"aqsaldpa28@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "judulnya ini");
                intent.putExtra(Intent.EXTRA_TEXT, "isinya ini");
                try {
                    startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ImplicitIntent.this, "Tidak Ada aplikasi mendukung", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //method baru
    private void gotoUrl(String string) {
        Uri uri = Uri.parse(string);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}