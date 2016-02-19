package cs407.cs407_homework1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Graham on 2/14/2016.
 */
public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the ResultFragment View
        RelativeLayout resultScreen = (RelativeLayout) inflater.inflate(R.layout.result_fragment, container, false);

        // Set up the View's two ImageViews for displaying whether a user submitted the correct answer.
        // Green checkmark for correct answers, red exes for incorrect answers.
        ImageView answer1 = (ImageView) resultScreen.findViewById(R.id.question1_image);
        ImageView answer2 = (ImageView) resultScreen.findViewById(R.id.question2_image);

        // Assign the images based on response correctness
        if (((StartActivity)getActivity()).answer1) {
            answer1.setImageResource(R.mipmap.ic_correct);
        } else {
            answer1.setImageResource(R.mipmap.ic_incorrect);
        }

        if (((StartActivity)getActivity()).answer2) {
            answer2.setImageResource(R.mipmap.ic_correct);
        } else {
            answer2.setImageResource(R.mipmap.ic_incorrect);
        }

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
