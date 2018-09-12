package nimbus.zipzap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CartActivity extends AppCompatActivity {
    String[] itemList;
    ListView listView;
    protected Cursor cursor;
    DBHelper dbData;
    public static CartActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ma = this;
        dbData = new DBHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbData.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM goods WHERE stats = 1",null);
        itemList = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            itemList[cc] = cursor.getString(1).toString();
        }
        listView = findViewById(R.id.listBar);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList));
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dbx = itemList[position];
                SQLiteDatabase db = dbData.getWritableDatabase();
                db.execSQL("UPDATE goods SET stats = 0 WHERE name = '"+ dbx +"'");
                RefreshList();
            }
        });

    }
}
