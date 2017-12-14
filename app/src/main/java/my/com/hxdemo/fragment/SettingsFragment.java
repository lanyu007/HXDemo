package my.com.hxdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import my.com.hxdemo.LoginActivity;
import my.com.hxdemo.R;

/**
 * Created by lanyu on 2017/12/12.
 */

public class SettingsFragment extends Fragment {

    int num = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button logoutButton = (Button) getView().findViewById(R.id.btn_logout);
        Button add = (Button) getView().findViewById(R.id.btn_add);
        Button sub = (Button) getView().findViewById(R.id.btn_sub);
        final EditText et_test = (EditText) getView().findViewById(R.id.et_test);
        et_test.setText(num+"");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(et_test.getText().toString());
                i++;
                et_test.setText(i+"");
                et_test.setSelection((i+"").length());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(et_test.getText().toString());
                i--;
                et_test.setText(i+"");
                et_test.setSelection((i+"").length());
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EMClient.getInstance().logout(false, new EMCallBack() {

                    @Override
                    public void onSuccess() {
                        getActivity().finish();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }

                    @Override
                    public void onProgress(int progress, String status) {

                    }

                    @Override
                    public void onError(int code, String error) {

                    }
                });
            }
        });
    }
}
