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


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        private static final int REQ_CODE = 123;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            rootView.findViewById(R.id.button).setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getActivity(), SubActivity.class);
            EditText editText = (EditText)getActivity().findViewById(R.id.editText);
            //入力文字列をStringに変換
            String msg = editText.getText().toString();
            // パラメータを格納
            intent.putExtra("msg_from_main", msg);

            // 結果を期待してActivityを開く
            startActivityForResult(intent, REQ_CODE);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == RESULT_OK){
                switch (requestCode){
                    case REQ_CODE:
                        // Subからのメッセージを表示
                        String msg = data.getStringExtra("msg_from_sub");
                        Toast.makeText(getActivity(), "msg from sub = "+msg, Toast.LENGTH_LONG).show();
                        break;
                }
            }

            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
