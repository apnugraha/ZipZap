package nimbus.zipzap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailBarang  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_barang);

        initAct();
    }

    public void initAct() {
        String parsedString = "";
        int parsedNum = 0;
        TextView listNo = findViewById(R.id.txtNo);
        TextView listName = findViewById(R.id.txtName);
        TextView listPrice = findViewById(R.id.txtPrice);
        TextView listCategory = findViewById(R.id.txtCategory);
        TextView listSeller = findViewById(R.id.txtSeller);
        ImageView imageView = findViewById(R.id.imageView);

        parsedNum = getIntent().getExtras().getInt("id");
        listNo.setText(parsedNum + "");
        parsedString = getIntent().getExtras().getString("name");
        listName.setText(parsedString);
        parsedString = getIntent().getExtras().getString("price");
        listPrice.setText(parsedString);
        parsedString = getIntent().getExtras().getString("category");
        listCategory.setText(parsedString);
        parsedString = getIntent().getExtras().getString("seller");
        listSeller.setText(parsedString);
        parsedNum = getIntent().getExtras().getInt("image");
        imageView.setImageResource(parsedNum);
    }
}
