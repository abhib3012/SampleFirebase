package com.hungservers.samplefirebase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.authentication.Constants;
import com.hungservers.samplefirebase.model.ShoppingList;


public class MainActivity extends Activity {

//    EditText editText;
//    TextView textView;
//    String childValue;

    String childValue = null;
    ShoppingList shoppingList1;
    public void dataEntry(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);




        //Firebase setup
        Firebase ref = new Firebase("https://instagram-android-feb05.firebaseio.com/");
        String data = editText.getText().toString();

        ShoppingList shoppingList = new ShoppingList(data, "Anonymous Owner");

        ref.child("activeList").setValue(shoppingList);
       //ref.child("listName").setValue(data);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");

        Firebase listNameRef = new Firebase("https://instagram-android-feb05.firebaseio.com").child("activeList");
        listNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("Data ", "Changed");
//
                shoppingList1 = dataSnapshot.getValue(ShoppingList.class);
             //   Log.i("Data is", childValue);

                textView.setText(shoppingList1.getListName());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Firebase.setAndroidContext(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    private void initializeScreen(View rootView) {
//
//        textView = (TextView) rootView.findViewById(R.id.textView);
//        editText = (EditText) rootView.findViewById(R.id.editText);
//    }
}
