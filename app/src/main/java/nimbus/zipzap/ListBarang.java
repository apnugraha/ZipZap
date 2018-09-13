package nimbus.zipzap;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class ListBarang extends ArrayAdapter<Barang>{
    DBHelper dbHelper;

    public ListBarang(Context context, ArrayList<Barang> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Barang barang = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_barang, parent,false);
            Button btnTog = convertView.findViewById(R.id.btnTog);
            if(barang.stats == 0){
                btnTog.setText("Get");
            }else {
                btnTog.setText("Yours");
            }
        } else {
            Button btnTog = convertView.findViewById(R.id.btnTog);
            if(barang.stats == 0){
                btnTog.setText("Get");
            }else {
                btnTog.setText("Yours");
            }
        }

        final Button btnTog = convertView.findViewById(R.id.btnTog);
        btnTog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(v.getContext());
                if (barang.stats == 1) {
                    barang.stats = 0;
                    btnTog.setText("Get");
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE goods SET stats = 0 WHERE id = '"+barang.id+"'");
                    db.close();
//                    CartActivity.ma.RefreshList();
                } else {
                    barang.stats = 1;
                    btnTog.setText("Yours");
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE goods SET stats = 1 WHERE id = '"+barang.id+"'");
                    db.close();
//                    CartActivity.ma.RefreshList();
                }
                dbHelper.close();
            }
        });

        /*final Button button = convertView.findViewById(R.id.detailList);
        final ToggleButton toggle = convertView.findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (barang.stats) {
                    // The toggle is enabled
                    barang.stats = false;
                    button.setText("1");
                } else {
                    // The toggle is disabled
                    barang.stats = true;
                    button.setText("2");
                }
            }
        });*/

        ImageView imageView = convertView.findViewById(R.id.imageView2);
        Button dtButton = convertView.findViewById(R.id.detailList);

        dtButton.setTag(position);
        dtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                Barang barang = getItem(position);

                Intent intent = new Intent(view.getContext(), DetailBarang.class);
                intent.putExtra("id", barang.id);
                intent.putExtra("name", barang.name);
                intent.putExtra("price", barang.price);
                intent.putExtra("category", barang.category);
                intent.putExtra("seller", barang.seller);
                intent.putExtra("image", barang.image);

                view.getContext().startActivity(intent);
            }
        });

        TextView listNo = convertView.findViewById(R.id.listNo);
        TextView listName = convertView.findViewById(R.id.listName);

        listNo.setText(barang.id + "");
        listName.setText(barang.name);
        imageView.setImageResource(barang.image);

        return convertView;
    }
}
