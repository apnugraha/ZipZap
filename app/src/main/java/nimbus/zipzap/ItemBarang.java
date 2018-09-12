package nimbus.zipzap;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemBarang extends AppCompatActivity {

    public ListBarang adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_barang);

        ArrayList<Barang> arrayOfUsers = new ArrayList<>();
        this.adapter = new ListBarang(this, arrayOfUsers);

//        initItems();

        ListView listView = findViewById(R.id.listBar);
        listView.setAdapter(adapter);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                "goods",   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
            String category = cursor.getString(cursor.getColumnIndexOrThrow("category"));
            String seller = cursor.getString(cursor.getColumnIndexOrThrow("seller"));
            int stats = cursor.getInt(cursor.getColumnIndexOrThrow("stats"));
            int image = cursor.getInt(cursor.getColumnIndexOrThrow("image"));

            adapter.add(new Barang(id, name, price, category, seller, stats, image));
        }
    }

//    public void goToNextActivity(View v) {
//        EditText inputText = findViewById(R.id.inputText);
//        Intent intent = new Intent(getApplicationContext(), NextActivity.class);
//        intent.putExtra("parse_data", inputText.getText() + "");
//        startActivity(intent);
//    }

//    public void clearList(View v) {
//        this.adapter.clear();
//    }

    public void initItems() {

        this.adapter.addAll(
                new Barang(1, "ACRNM Shoes", "5 Juta", "Wearable", "PT. BB", 0, R.drawable.acrnm_shoes),
                new Barang(2, "Alumunium Panniers", "3 Juta", "Bike", "PT. BB", 0, R.drawable.alu_panniers),
                new Barang(3, "ASUS X550 IU", "10 Juta", "Electronics", "PT. BB", 0, R.drawable.asusx550iu),
                new Barang(4, "Evo Noir Boots", "5 Juta", "Bike", "PT. BB", 0, R.drawable.evo_noir_boots),
                new Barang(5, "Gopro Hero 6", "4 Juta", "Electronics", "PT. BB", 0, R.drawable.gopro_hero_6),
                new Barang(6, "Respiro Gloves", "1 Juta", "Bike", "PT. BB", 0, R.drawable.respiro_gloves),
                new Barang(7, "Shoei Hornet X2", "8 Juta", "Bike", "PT. BB", 0, R.drawable.shoei_hornet_x2),
                new Barang(8, "Supreme Techwear", "11 Juta", "Wearable", "PT. BB", 0, R.drawable.supreme_techwear),
                new Barang(9, "Thermaltake Verto", "1 Juta", "Electronics", "PT. BB", 0, R.drawable.tt_verto),
                new Barang(10, "Versys 250", "70 Juta", "Bike", "PT. BB", 0, R.drawable.versys_250));

    }

}
