package com.example.robin.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment1 extends Fragment
{
    EditText write;
    TextView
    Button ok;
    String message;
    int comment_counter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("Users");
        DatabaseReference reference1 = reference.child("Names");
        DatabaseReference reference2 = reference1.child("Posts");
        DatabaseReference reference3 = reference2.child("FirstPost");
        DatabaseReference reference4 = reference3.child("Like");
        final DatabaseReference reference5 =reference3.child("Comments");


        if(write.isShown() && ok.isShown())
        {
            write.setVisibility(View.GONE);
            ok.setVisibility(View.GONE);
        }
        else {
            write.setVisibility(View.VISIBLE);
            ok.setVisibility(View.VISIBLE);
        }
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)  {
                        write.setText("");
                        message = write.getText().toString();
                        // arrayList.add(message);
                        reference5.push().setValue(message);

                        //  TextView textView = (TextView)getActivity().findViewById(R.id.texts);
                        // for(int i =0;i<=comment_counter;i++)
                        //textView.append(store[i]+"\n");

                        comment_counter++;
                        y.setText(message);

                    }

                });
                    y.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            FragmentManager fragmentManager = getFragmentManager();
                            Fragment1 fragment1 = (Fragment1)fragmentManager.findFragmentByTag("post");
                            Fragment2 fragment2 = new Fragment2();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.remove(fragment1);
                            fragmentTransaction.addToBackStack("fragment 1");
                            fragmentTransaction.add(R.id.main_activity,fragment2,"comments");
                            fragmentTransaction.commit();
                        }
                    });
                    signout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mauth = FirebaseAuth.getInstance();
                            mauth.signOut();
                            startActivity(new Intent(getActivity(),Main2Activity.class));
                        }
                    });

                }


            }





