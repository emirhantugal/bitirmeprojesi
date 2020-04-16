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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpFragment extends Fragment {

   public SignUpFragment(){

   }

   private TextView alreadyHaveAnAccount;
   private FrameLayout parentFrameLayout;
   private EditText email;
   private EditText fullname;
   private EditText password;
   private EditText confirmPassword;
   private ImageButton closeBtn;
   private Button singUpBtn;

   private ProgressBar progressBar;
   private FirebaseFirestore firebaseFirestore;
   private FirebaseAuth firebaseAuth;
   private String emailPattern = "[a-zA-z0-9._-]+@[a-z]+.[a-z]+";



   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
       View view = inflater.inflate(R.layout.activity_sign_up_fragment, container, false);

       parentFrameLayout = getActivity().findViewById(R.id.register_framelayout);

       alreadyHaveAnAccount = view.findViewById(R.id.already_have_an_account);
       email = view.findViewById(R.id.sign_up_email);
       fullname = view.findViewById(R.id.sign_up_fullname);
       password = view.findViewById(R.id.sign_up_password);
       confirmPassword = view.findViewById(R.id.sign_up_confirm_password);

       progressBar = view.findViewById(R.id.progressBar);

       closeBtn = view.findViewById(R.id.sign_up_close_btn);
       singUpBtn = view.findViewById(R.id.sign_up_btn);

       firebaseAuth = FirebaseAuth.getInstance();
       firebaseFirestore = FirebaseFirestore.getInstance();
       return view;
   }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             setFragment(new SignInFragment());
         }
     });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
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
     fullname.addTextChangedListener(new TextWatcher() {
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
     confirmPassword.addTextChangedListener(new TextWatcher() {
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
     singUpBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           checkEmailAndPassword();
         }
     });
   }
    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
       if(!TextUtils.isEmpty(email.getText())){
           if(!TextUtils.isEmpty(fullname.getText())){
              if(!TextUtils.isEmpty(password.getText()) && password.length() >= 8){
                  if(!TextUtils.isEmpty(confirmPassword.getText())){
                       singUpBtn.setEnabled(true);
                      singUpBtn.setTextColor(Color.rgb(255,255,255));
                  }else{
                      singUpBtn.setEnabled(false);
                      singUpBtn.setTextColor(Color.argb(50f, 255,255,255));
                  }
              }else{
                  singUpBtn.setEnabled(false);
                  singUpBtn.setTextColor(Color.argb(50f, 255,255,255));
              }
           }else{
               singUpBtn.setEnabled(false);
               singUpBtn.setTextColor(Color.argb(50f, 255,255,255));
           }
       }else{
            singUpBtn.setEnabled(false);
            singUpBtn.setTextColor(Color.argb(50f, 255,255,255));
       }
    }
    private void checkEmailAndPassword(){

       if(email.getText().toString().matches(emailPattern)){
           if(password.getText().toString().equals(confirmPassword.getText().toString())){

               progressBar.setVisibility(View.VISIBLE);
               singUpBtn.setEnabled(false);
               singUpBtn.setTextColor(Color.argb(50, 255,255,255));

               firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isSuccessful()){

                                   Map<Object,String> userdata = new HashMap<>();
                                   userdata.put("fullname",fullname.getText().toString()) ;
                                   userdata.put("password", password.getText().toString());
                                   userdata.put("email", email.getText().toString());

                                   firebaseFirestore.collection("USERS")
                                           .add(userdata)
                                           .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                               @Override
                                               public void onComplete(@NonNull Task<DocumentReference> task) {
                                                   if(task.isSuccessful()){

                                                       mainIntent();

                                                   }else{
                                                       progressBar.setVisibility(View.INVISIBLE);
                                                       singUpBtn.setEnabled(true);
                                                       singUpBtn.setTextColor(Color.rgb(255,255,255));
                                                       String error = task.getException().getMessage();
                                                       Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                                                   }
                                               }
                                           });
                                 Intent mainIntent = new Intent(getActivity(),MainActivity.class);
                                 startActivity(mainIntent);
                                 getActivity().finish();

                               }else{
                                   progressBar.setVisibility(View.INVISIBLE);
                                   singUpBtn.setEnabled(true);
                                   singUpBtn.setTextColor(Color.rgb(255,255,255));
                                   String error = task.getException().getMessage();
                                   Toast.makeText(getActivity(),error, Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

           }else{
               confirmPassword.setError("Şifreler Uyuşmuyor. Lütfen Doğru Giriniz.");
           }
       }else{
         email.setError("Geçersiz Email");
       }
    }
    private void mainIntent(){
        Intent mainIntent = new Intent(getActivity(),MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}
