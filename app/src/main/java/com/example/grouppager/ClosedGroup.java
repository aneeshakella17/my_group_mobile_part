package com.example.grouppager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClosedGroup.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClosedGroup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClosedGroup extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DatabaseReference closed_group_database;

    public ClosedGroup() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClosedGroup.
     */
    // TODO: Rename and change types and number of parameters
    public static ClosedGroup newInstance(String param1, String param2) {
        ClosedGroup fragment = new ClosedGroup();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        closed_group_database = FirebaseDatabase.getInstance().getReference().child("Closed Groups");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout ll =  (LinearLayout) inflater.inflate(R.layout.fragment_closed_group, container, false);

        ListView closed_list = (ListView) ll.findViewById(R.id.closed_list_view);
        closed_list.setAdapter(new FirebaseListAdapter<Group>(getActivity(), Group.class, android.R.layout.simple_list_item_1, closed_group_database) {// Populate view as needed
            @Override
            protected void populateView(View view, Group g, int position) {
                ((TextView) view.findViewById(android.R.id.text1)).setText(g.getName());
            }
        });
        return ll;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
