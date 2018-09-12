package nimbus.zipzap;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItems();
        goBarang();
        goCart();
    }

    public void goBarang() {
        Button move = findViewById(R.id.barang);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ItemBarang.class);
                startActivity(intent);
            }
        });
    }

    public void goCart() {
        Button move = findViewById(R.id.cart);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });
    }

    public void initItems() {

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Barang[] barang = new Barang[]{
            new Barang(1, "ACRNM Shoes", "5 Juta", "Wearable", "PT. BB", 0, R.drawable.acrnm_shoes),
            new Barang(2, "Alumunium Panniers", "3 Juta", "Bike", "PT. BB", 0, R.drawable.alu_panniers),
            new Barang(3, "ASUS X550 IU", "10 Juta", "Electronics", "PT. BB", 0, R.drawable.asusx550iu),
            new Barang(4, "Evo Noir Boots", "5 Juta", "Bike", "PT. BB", 0, R.drawable.evo_noir_boots),
            new Barang(5, "Gopro Hero 6", "4 Juta", "Electronics", "PT. BB", 0, R.drawable.gopro_hero_6),
            new Barang(6, "Respiro Gloves", "1 Juta", "Bike", "PT. BB", 0, R.drawable.respiro_gloves),
            new Barang(7, "Shoei Hornet X2", "8 Juta", "Bike", "PT. BB", 0, R.drawable.shoei_hornet_x2),
            new Barang(8, "Supreme Techwear", "11 Juta", "Wearable", "PT. BB", 0, R.drawable.supreme_techwear),
            new Barang(9, "Thermaltake Verto", "1 Juta", "Electronics", "PT. BB", 0, R.drawable.tt_verto),
            new Barang(10, "Versys 250", "70 Juta", "Bike", "PT. BB", 0, R.drawable.versys_250)
        };

        Cursor cursor = db.query(
                "goods",   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        for (Barang brg : barang){
            ContentValues values = putValue(brg.id, brg.name, brg.price, brg.category, brg.seller, brg.stats, brg.image);
            if (!cursor.moveToNext()){
                db.insert("goods", null, values);
            }
        }
    }

    public ContentValues putValue(int id, String name, String price, String category, String seller, int stats, int image) {
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("price", price);
        values.put("category", category);
        values.put("seller", seller);
        values.put("stats", stats);
        values.put("image", image);
        return values;
    }
}
