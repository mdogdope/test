package to.us.ekimhest.guessinggame;

import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Global Variables
    String inputFieldView = "";
    int inputField;
    int randomNumber;
    int meter = 1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        meterNumberDisplay("Guess#: " + meter);

        Random rand = new Random();
        randomNumber = rand.nextInt(101);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //Actions==========

    public void keyPad1(View view) {
        inputFieldView = inputFieldView + "1";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad2(View view) {
        inputFieldView = inputFieldView + "2";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad3(View view) {
        inputFieldView = inputFieldView + "3";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad4(View view) {
        inputFieldView = inputFieldView + "4";
        inputTextViewString(inputFieldView);
        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad5(View view) {
        inputFieldView = inputFieldView + "5";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad6(View view) {
        inputFieldView = inputFieldView + "6";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad7(View view) {
        inputFieldView = inputFieldView + "7";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad8(View view) {
        inputFieldView = inputFieldView + "8";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad9(View view) {
        inputFieldView = inputFieldView + "9";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    public void keyPad0(View view) {
        inputFieldView = inputFieldView + "0";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(true);
    }

    //Test for correct number

    public void keyPadEnter(View view) {
        inputField = Integer.parseInt(inputFieldView);
        if (inputField == randomNumber) {
            winnerDisplay("It took you " + meter + " guess(s)");
        } else if (inputField > randomNumber) {
            winnerDisplay("Too High");
            ++meter;
            meterNumberDisplay("Guess#: " + meter);
        } else if (inputField < randomNumber) {
            winnerDisplay("Too Low");
            ++meter;
            meterNumberDisplay("Guess#: " + meter);
        }
        inputField = 0;
        inputFieldView = "";
        inputTextViewString(inputFieldView);
    }

    //Clear

    public void keyPadClear(View view){
        inputField = 0;
        inputFieldView = "";
        inputTextViewString(inputFieldView);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);
    }

    //Restart

    public void restart(View view){
        inputField = 0;
        inputFieldView = "";
        inputTextViewString(inputFieldView);

        winnerDisplay("");

        meter = 1;
        meterNumberDisplay("Guess#: " + meter);

        Random rand = new Random();
        randomNumber = rand.nextInt(101);

        ImageButton btnSubmit = (ImageButton) findViewById(R.id.key_pad_enter);
        btnSubmit.setEnabled(false);
    }

    //Methods==========

    private void inputTextViewString(String inputTextFieldView) {
        TextView inputTextDisplay = (TextView) findViewById(R.id.input_text_view);
        inputTextDisplay.setText(inputTextFieldView);
    }

    private void winnerDisplay(String winnerTextString) {
        TextView winnerTextDisplay = (TextView) findViewById(R.id.guess_number_text_view);
        winnerTextDisplay.setText(winnerTextString);
    }

    private void meterNumberDisplay(String message){
        TextView meterTextDisplay = (TextView) findViewById(R.id.meter_text_view);
        meterTextDisplay.setText("" + message);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://to.us.ekimhest.guessinggame/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://to.us.ekimhest.guessinggame/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
