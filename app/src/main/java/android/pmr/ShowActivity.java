package android.pmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.pmr.db.DbCloset;
import android.pmr.entities.Clothes;
import android.text.InputType;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String URL1 = "https://www.pullandbear.com/";
    public static final String URL2 = "https://www.bershka.com/ic/es/bershka/bershka/new-c706526.html#all:true,page:0,cat:0,price:3.99:39.99,special,size,color";
    public static final String URL3 = "https://www.hsnstore.com/";

    private Button btn1, btn2, btn3;
    private EditText txtShopName, txtDesc, txtPrice;
    private Clothes clothes;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        switch (v.getId()) {
            case R.id.btn1:
                intent.setData(Uri.parse(URL1));
                startActivity(intent);
                break;
            case R.id.btn2:
                intent.setData(Uri.parse(URL2));
                startActivity(intent);
                break;
            case R.id.btn3:
                intent.setData(Uri.parse(URL3));
                startActivity(intent);
                break;

        }

    }
}