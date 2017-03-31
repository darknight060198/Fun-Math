package com.ancovy.funmath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.ancovy.funmath.R;

/**
 * Created by DarKnight98 on 3/15/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    private ImageButton visibility;
    private EditText passInput, emailInput;
    private Button loginButton, forgotPassword, newAccount;
    private boolean isPasswordVisible;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        visibility = (ImageButton)view.findViewById(R.id.hide_or_show_password_login_input);
        visibility.setOnClickListener(this);

        passInput = (EditText)view.findViewById(R.id.login_password_input);
        emailInput = (EditText)view.findViewById(R.id.login_email_input);

        loginButton = (Button)view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);

        newAccount = (Button)view.findViewById(R.id.needANewAccount_button);
        newAccount.setOnClickListener(this);

        isPasswordVisible = false;

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hide_or_show_password_login_input :
                //cursor position
                int cursorPosition = passInput.getSelectionStart();

                //toogle variable
                isPasswordVisible = !isPasswordVisible;

                //change image
                visibility.setImageDrawable(getResources().getDrawable(isPasswordVisible ? R.drawable.visibility_off_icon : R.drawable.visibility_icon));

                //apply input type
                passInput.setInputType(isPasswordVisible ? InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                //returns cursor pos
                passInput.setSelection(cursorPosition);
                break;
//            case
        }
    }
}
