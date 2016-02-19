package cs407.cs407_homework1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the ResultFragment View
        RelativeLayout resultScreen = (RelativeLayout) inflater.inflate(R.layout.finalFrag, container, false);

        // Display their final score
        TextView finalScore = (TextView) resultScreen.findViewById(R.id.numericScore);
        finalScore.setText(((StartActivity)getActivity()).score + " / 2");

        // Set up TextFragment View's 'Restart Quiz' button with an action listener
        Button restartQuiz = (Button) resultScreen.findViewById(R.id.restartQuiz);
        restartQuiz.setClickable(true);
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((StartActivity) getActivity()).showToast("Clicked restart.");
                ((StartActivity) getActivity()).startQuiz();
            }
        });

        // Set up TextFragment View's 'Exit Quiz' button with an action listener
        Button exitQuiz = (Button) resultScreen.findViewById(R.id.exitQuiz);
        exitQuiz.setClickable(true);
        exitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((StartActivity) getActivity()).showToast("Clicked exit.");
                ((StartActivity)getActivity()).finish();
            }
        });

        return resultScreen;
    }
}
