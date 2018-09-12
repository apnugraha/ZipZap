package nimbus.zipzap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    /*
        public static final String TABLE_NAME = "data_barang_cart";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_BRAND = "brand";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_SELLER = "seller";
    */
    private static final String DB_NAME = "inventory.db";
    private static final int DB_VERSION = 1;
    /*
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_BRAND+ " varchar(50) not null, "
            + COLUMN_PRICE+ " varchar(50) not null,"
            + COLUMN_CATEGORY+ " varchar(50) not null, "
            + COLUMN_SELLER+ " varchar(50) not null);";
    */

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // Auto generated
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table goods(" +
                "id integer primary key, " +
                "name text null, " +
                "price text null, " +
                "category text null, " +
                "seller text null, " +
                "stats integer null, " +
                "image integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

//        sql = "INSERT INTO goods (id, name, price, category, seller, stats, image)" +
//                "VALUES" +
//                "(1, 'ACRNM Shoes', '5 Juta', 'Wearable', 'PT. BB', 0, R.drawable.acrnm_shoes)," +
//                "(2, 'Alumunium Panniers', '3 Juta', 'Bike', 'PT. BB', 0, R.drawable.alu_panniers)," +
//                "(3, 'ASUS X550 IU', '10 Juta', 'Electronics', 'PT. BB', 0, R.drawable.asusx550iu)," +
//                "(4, 'Evo Noir Boots', '5 Juta', 'Bike', 'PT. BB', 0, R.drawable.evo_noir_boots)," +
//                "(5, 'Gopro Hero 6', '4 Juta', 'Electronics', 'PT. BB', 0, R.drawable.gopro_hero_6)," +
//                "(6, 'Respiro Gloves', '1 Juta', 'Bike', 'PT. BB', 0, R.drawable.respiro_gloves)," +
//                "(7, 'Shoei Hornet X2', '8 Juta', 'Bike', 'PT. BB', 0, R.drawable.shoei_hornet_x2)," +
//                "(8, 'Supreme Techwear', '11 Juta', 'Wearable', 'PT. BB', 0, R.drawable.supreme_techwear)," +
//                "(9, 'Thermaltake Verto', '1 Juta', 'Electronics', 'PT. BB', 0, R.drawable.tt_verto)," +
//                "(10, 'Versys 250', '70 Juta', 'Bike', 'PT. BB', 0, R.drawable.versys_250);";
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.w(DBHelper.class.getName(),"Upgrading database from version " + oldVersion + " to "
//                + newVersion + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + "goods");
//        onCreate(db);
    }
}
