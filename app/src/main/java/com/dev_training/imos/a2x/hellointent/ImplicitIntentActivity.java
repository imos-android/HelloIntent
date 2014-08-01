package com.dev_training.imos.a2x.hellointent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;


public class ImplicitIntentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.implicit_intent, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_implicit_intent, container, false);

            rootView.findViewById(R.id.searchButton).setOnClickListener(this);
            rootView.findViewById(R.id.dialButton).setOnClickListener(this);
            rootView.findViewById(R.id.settingsButton).setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View view) {
            EditText editText = (EditText)(getActivity().findViewById(R.id.editText));
            String text = editText.getText().toString();

            Intent intent;
            switch (view.getId()){
                case R.id.searchButton:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra("query", text);
                    startActivity(intent);

                    break;
                case R.id.dialButton:
                    intent = new Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel:"+text));
                    startActivity(intent);
                    break;
                case R.id.settingsButton:
                    intent = new Intent("android.settings.SETTINGS");
                    startActivity(intent);
                    break;
            }
        }
    }
}
