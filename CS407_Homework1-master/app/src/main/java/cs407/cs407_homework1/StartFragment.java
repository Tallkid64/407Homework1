package cs407.cs407_homework1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the StartFragment View
        RelativeLayout startScreen = (RelativeLayout) inflater.inflate(R.layout.startFrag, container, false);

        // Set up StartFragment View's 'Start Quiz' button with an action listener
        Button startQuiz = (Button) startScreen.findViewById(R.id.startQuiz);
        startQuiz.setClickable(true);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StartActivity)getActivity()).startQuiz();
            }
        });

        return startScreen;
    }

}
