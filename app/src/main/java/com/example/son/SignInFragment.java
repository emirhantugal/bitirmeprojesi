package com.example.son;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import static com.example.son.RegisterActivity.onResetPasswordFragment;

public class SignInFragment extends Fragment {
    public SignInFragment() {

    }

    private TextView yanoluyoramk;
    private FrameLayout parentFrameLayout;

    private EditText email;
    private EditText password;

    private TextView forgotPassword;

    private ProgressBar progressBar;

    private ImageButton closeBtn;
    private Button signInBtn;

    private FirebaseAuth firabaseAuth;
    private String emailPattern = "[a-zA-z0-9._-]+@[a-z]+.[a-z]+";


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sign_in_fragment, container, false);
        parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

        yanoluyoramk = view.findViewById(R.id.dont_have_an_account);

        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_in_password);

        forgotPassword = view.findViewById(R.id.sign_in_forgot_password);

        progressBar = view.findViewById(R.id.sign_in_progressbar);

        closeBtn = view.findViewById(R.id.sign_in_close_btn);
        signInBtn = view.findViewById(R.id.sign_in_btn);

        firabaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        yanoluyoramk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetPasswordFragment = true;
                setFragment(new ResetPasswordFragment());
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(mainIntent);
                getActivity().finish();
            }
        });
        
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               checkInputs();
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });
    }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText())){
            if(!TextUtils.isEmpty(password.getText())){
                signInBtn.setEnabled(true);
                signInBtn.setTextColor(Color.rgb(255,255,255));
            }else{
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signInBtn.setEnabled(false);
            signInBtn.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void checkEmailAndPassword(){
       if(email.getText().toString().matches(emailPattern)){
          if(password.length() >= 8){

              progressBar.setVisibility(View.VISIBLE);
              signInBtn.setEnabled(false);
              signInBtn.setTextColor(Color.argb(50,255,255,255));

              firabaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful()){

                                  mainIntent();
                              }else{
                                  progressBar.setVisibility(View.INVISIBLE);
                                  signInBtn.setEnabled(true);
                                  signInBtn.setTextColor(Color.rgb(255,255,255));
                                  String error = task.getException().getMessage();
                                  Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                              }
                          }
                      });

          }else{
              Toast.makeText(getActivity(), "Email ya da şifre yanlış!", Toast.LENGTH_SHORT).show();

          }
       }else{
           Toast.makeText(getActivity(), "Email ya da şifre yanlış!", Toast.LENGTH_SHORT).show();

       }
    }

    private  void mainIntent(){
        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}

