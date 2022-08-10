package com.cst2335.mycovidapplication;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Used to display saved query results when listview item is clicked.
 * @author Junnias
 * @version 1.0
 * @see Fragment
 * @see PastQueries
 * @see ResultsActivity
 */
public class DetailsFragment extends Fragment {

    String qResults = "";
    int id = 0;
    String msgDetails = "";
    TextView resultsDetails;
    TextView messageDetails;
    TextView msgId;
    Button hide;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            if (getArguments() != null) {
                id = getArguments().getInt("id", 0);
                msgDetails = getArguments().getString("message", "message details");
                qResults = getArguments().getString("results", "query results");
            }
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflated = inflater.inflate(R.layout.activity_details_fragment, container, false);

        return inflated;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        //set values
        messageDetails = (TextView) view.findViewById(R.id.msg_title);
        msgId = view.findViewById(R.id.msg_id);
        resultsDetails = view.findViewById(R.id.query_results);
        resultsDetails.setMovementMethod(new ScrollingMovementMethod());
        hide = (Button) view.findViewById(R.id.hide_button);

        messageDetails.setText(msgDetails);
        String displayId = "ID = " + id;
        msgId.setText(displayId);
        resultsDetails.setText(qResults);

        // hide fragment acts as a back button, that will remove fragment and terminate the activity.
        hide.setOnClickListener(click -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setReorderingAllowed(true);
            ft.remove(this);
            ft.commit();

            getActivity().finish();
        });

    }
}
