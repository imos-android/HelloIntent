package com.dev_training.imos.a4x.helloexplicitintent.app2;

import android.content.Intent;
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
import android.widget.Toast;

import com.dev_training.imos.a4x.helloexplicitintent.app2.R;

public class SubActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        // 取得したメッセージを表示
        String msg = getIntent().getStringExtra("msg_from_main");

        Toast.makeText(this, "from main = "+msg, Toast.LENGTH_LONG).show();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sub, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_sub, container, false);

            rootView.findViewById(R.id.button).setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            EditText editText = (EditText)getActivity().findViewById(R.id.editText);
            //入力文字列をStringに変換
            String msg = editText.getText().toString();
            // パラメータを格納
            intent.putExtra("msg_from_sub", msg);

            // 結果を格納
            getActivity().setResult(RESULT_OK, intent);
            // Activityを終了し戻る
            getActivity().finish();
        }
    }
}
