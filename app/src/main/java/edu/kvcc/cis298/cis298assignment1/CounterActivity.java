package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    private Button mAdd_one_button;         // REFERENCES THE BUTTON USED TO ADD ONE TO THE COUNTER
    private Button mSubtract_one_button;    // REFERENCES THE BUTTON USED TO SUBTRACT ONE TO THE COUNTER
    private Integer TotalPeopleInt = 0;     // HOLDS THE CURRENT NUMBER OF PEOPLE IN THE ROOM
    String TempString;                      // STRING TO HOLD CASTED INTEGER VALUE FROM TotalPeopleInt
    TextView mTextView;                     // REFERENCES THE TEXT VIEW FOR OUTPUT OF THE NUMBER OF PEOPLE IN ROOM

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

    mAdd_one_button = (Button) findViewById(R.id.add_one_button);   //CREATE AND INSTANCE OF BUTTON AND ESTABLISH REFFENCE USED TO ADD ONE TO TotalPeopleInt


    mAdd_one_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //                                                      CLICK EVENT WHEN mAdd_one_button CLICKED TO ADD 1 TO THE TotalPeopleInt
            //                                                      USED TO SHOW THE CURRENT NUMBER OF PEOPLE IN THE ROOM.  CHECKS TO SEE IF
            //                                                      TotalPeopleInt IS GREATER THAN 20 AND IF SO IT WILL GIVE A TOO MANY PEOPLE
            //                                                      MESSAGE AND WILL NOT ALLOW YOU TO ADD MORE.
            TotalPeopleInt++;
            if (TotalPeopleInt > 20) {
                Toast.makeText(CounterActivity.this, R.string.toast_message, Toast.LENGTH_SHORT).show();
                TotalPeopleInt--;
            }


            TempString = Integer.toString(TotalPeopleInt);          // CONVERTS TotalPeopleInt TO A TEMPORAY STRING TempString
            mTextView = (TextView) findViewById(R.id.Count_text);   // MAKE AN INSTANCE OF TextView AND REFENCE IT
            mTextView.setText(TempString);                          // OUTPUT THE VALUE FROM TempString WHICH HOLDS THE CURRENT TOTAL OR PEOPLE IN THE ROOM

        }
    });

    mSubtract_one_button = (Button) findViewById(R.id.subtract_one_button); //CREATE AND INSTANCE OF BUTTON AND ESTABLISH REFFENCE USED TO SUBTRACT ONE TO TotalPeopleInt


    mSubtract_one_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //                                                      CLICK EVENT WHEN mSubtract_one_button CLICKED TO SUBTRACT 1 TO THE TotalPeopleInt
            //                                                      USED TO SHOW THE CURRENT NUMBER OF PEOPLE IN THE ROOM.  CHECKS TO SEE IF
            //                                                      TotalPeopleInt IS LESS THAN 0 AND IF SO IT WILL GIVE A NO ONE IN THE ROOM
            //                                                      MESSAGE AND WILL NOT ALLOW YOU TO SUBTRACT PEOPLE FROM THE COUNT.

            TotalPeopleInt--;
            if (TotalPeopleInt <0) {
                Toast.makeText(CounterActivity.this, R.string.Negative_Toast_Message, Toast.LENGTH_SHORT).show();
                TotalPeopleInt ++;
            }


            TempString = Integer.toString(TotalPeopleInt);          // CONVERTS TotalPeopleInt TO A TEMPORAY STRING TempString
            mTextView = (TextView) findViewById(R.id.Count_text);   // MAKE AN INSTANCE OF TextView AND REFENCE IT
            mTextView.setText(TempString);                          // OUTPUT THE VALUE FROM TempString WHICH HOLDS THE CURRENT TOTAL OR PEOPLE IN THE ROOM
        }

    });

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
}
