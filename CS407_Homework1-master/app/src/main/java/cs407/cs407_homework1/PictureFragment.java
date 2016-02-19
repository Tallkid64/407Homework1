package cs407.cs407_homework1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class PictureFragment extends Fragment {

    /**
     * Constant Strings for assigning correct answers
     * for the picture question of the quiz
     */
    private static final String answer = "Wisconsin";


    /**
     * String for assigning correct answer once determined
     * by the random number generator
     */
    private String correct_answer = "";

    /**
     * PictureFragment View item - question1_response
     */
    private EditText response;

    /**
     * PictureFragment View item - imageView
     */
    private ImageView mImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the PictureFragment View
        RelativeLayout pictureScreen = (RelativeLayout) inflater.inflate(R.layout.picture_fragment, container, false);

        // Set up the View's EditText for user response input
        response = (EditText) pictureScreen.findViewById(R.id.question1_response);
        response.setText("");

        // Set up the View's ImageView
        mImageView = (ImageView) pictureScreen.findViewById(R.id.pictureImage);

        if (mImageView != null) {

                correct_answer = answer;
                mImageView.setImageResource(R.mipmap.map);

        }

        // Set up the View's 'Submit Answer' button with a action listener
        Button nextQuestion = (Button) pictureScreen.findViewById(R.id.picture_fragment_submit);
        nextQuestion.setClickable(true);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Call the nextQuestion method of the StartActivity
                ((StartActivity)getActivity()).nextQuestion(correct_answer, response.getText().toString());
            }
        });

        return pictureScreen;
    }
}
