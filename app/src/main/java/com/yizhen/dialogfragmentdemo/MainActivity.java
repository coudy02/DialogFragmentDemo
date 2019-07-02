package com.yizhen.dialogfragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener   {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_show_dailog_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog(v);
            }
        });

        findViewById(R.id.btn_show_dailog_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoginDialog(v);
            }
        });


    }

//    public void showDialogInDifferentScreen(View view)
//    {
//        FragmentManager fragmentManager = getFragmentManager();
//        EditNameDialogFragment newFragment = new EditNameDialogFragment();
//
//        boolean mIsLargeLayout = getResources().getBoolean(R.bool.large_layout) ;
//        Log.e("TAG", mIsLargeLayout+"");
//        if (mIsLargeLayout )
//        {
//            // The device is using a large layout, so show the fragment as a
//            // dialog
//            newFragment.show(fragmentManager, "dialog");
//        } else
//        {
//            // The device is smaller, so show the fragment fullscreen
//            FragmentTransaction transaction = fragmentManager
//                    .beginTransaction();
//            // For a little polish, specify a transition animation
//            transaction
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//            // To make it fullscreen, use the 'content' root view as the
//            // container
//            // for the fragment, which is always the root view for the activity
//            transaction.replace(R.id.id_ly, newFragment).commit();
//        }
//    }


    public void showLoginDialog(View view) {
        LoginDialogFragment dialog = new LoginDialogFragment();
        dialog.show(getFragmentManager(), "loginDialog");
    }


    public void showEditDialog(View view) {
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }

    @Override
    public void onLoginInputComplete(String username, String password) {

        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();

    }
}
