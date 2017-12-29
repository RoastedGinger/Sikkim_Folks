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

public class Fragment1 extends Fragment{
    EditText write;
    TextView y, x;
    Button ok, signout, comments, repo, bookmark;
    String message;
    int comment_counter, user_like;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("Users");
    DatabaseReference reference1 = reference.child("Names");
    DatabaseReference reference2 = reference1.child("Posts");
    DatabaseReference reference3 = reference2.child("FirstPost");
    DatabaseReference reference4 = reference3.child("Like");
    final DatabaseReference reference5 = reference3.child("Comments");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.post, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        write = getActivity().findViewById(R.id.write);
        ok = getActivity().findViewById(R.id.ok);
        y = getActivity().findViewById(R.id.commentbox);
        x = getActivity().findViewById(R.id.likebox);
        comments = getActivity().findViewById(R.id.comments);
        repo = getActivity().findViewById(R.id.repo);
        bookmark = getActivity().findViewById(R.id.bookmark);
        write.setVisibility(View.GONE);
        ok.setVisibility(View.GONE);
           comments.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (write.isShown() && ok.isShown()) {
                       write.setVisibility(View.GONE);
                       ok.setVisibility(View.GONE);
                   } else {
                       write.setVisibility(View.VISIBLE);
                       ok.setVisibility(View.VISIBLE);
                   }
                   ok.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           message = write.getText().toString();
                           reference5.push().setValue(message); //
                           //textView.append(store[i]+"\n");
                           comment_counter++;
                           y.setText(message);
                           write.setText("");

                       }

                   });

               }
           });

        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                Fragment1 fragment1 = (Fragment1) fragmentManager.findFragmentByTag("post");
                Fragment2 fragment2 = new Fragment2();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(fragment1);
                fragmentTransaction.addToBackStack("fragment 1");
                fragmentTransaction.add(R.id.main_activity, fragment2, "comments");
                fragmentTransaction.commit();
            }
        });
/*        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mauth;
                mauth = FirebaseAuth.getInstance();
                mauth.signOut();
                startActivity(new Intent(getActivity(), Main2Activity.class));
            }
        });  */
    }

}





