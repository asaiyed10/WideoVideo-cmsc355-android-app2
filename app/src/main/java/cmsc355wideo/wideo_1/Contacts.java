package cmsc355wideo.wideo_1;
import android.content.ContentResolver;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.widget.FrameLayout;
import android.database.Cursor;
import android.util.Log;


/**
 * Created by Ahson and Ahmed on 10/7/16.
 */

public class Contacts extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_list);

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "= ? ", new String[]{id}, null);
            Log.i("Friends", id + "=" + name);
            while (phoneCursor.moveToNext()) {
                String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.i("Friends", phoneNumber);
            }
        }
    }
}