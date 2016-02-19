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


public class StartFragment extends Fragment {

    /**
     * PictureFragment View item - imageView
     */
    private ImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the StartFragment View
        RelativeLayout startScreen = (RelativeLayout) inflater.inflate(R.layout.start_fragment, container, false);

        // Set up and populate the quiz directions.
        TextView quizDirections = (TextView) startScreen.findViewById(R.id.quizDirections);
        quizDirections.setText("\n\n\nQuestion 1: Famous Art\n" +
                                "Quesiton 2: Word Problem\n\n" +
                                "You will be given your score along with which questions you answered " +
                                "correctly or incorrectly once you've completed the quiz. You will have " +
                                "the option of restarting the quiz after each of the questions has been" +
                                " attempted. Good luck!");

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
