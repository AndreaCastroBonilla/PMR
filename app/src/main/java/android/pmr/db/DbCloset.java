package android.pmr.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.sql.Blob;

public class DbCloset extends DbHelper{

    // ---------> ATTRIBUTES & CONSTANS <---------
    private Context context;

    // ---------> DEVELOPMENT <---------
    public DbCloset(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertClothing(Blob image, String shop, String name){
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("image", String.valueOf(image));
            contentValues.put("shop", shop);
            contentValues.put("name", name);

            db.insert(TABLE_CLOSET, null, contentValues);
        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }
}
