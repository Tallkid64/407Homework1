package cs407.cs407_homework1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextFragment extends Fragment {

    // CheckBoxes for each potential answer
    private CheckBox answer1;
    private CheckBox answer2;
    private CheckBox answer3;
    private CheckBox answer4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Create a RelativeLayout screen for manipulating the TextFragment View
        RelativeLayout textScreen = (RelativeLayout) inflater.inflate(R.layout.text_fragment, container, false);

        // Set up the View's TextView for the question dialog
        TextView question = (TextView) textScreen.findViewById(R.id.question2);
        question.setText("Which are The Office quotes");

        answer1 = (CheckBox) textScreen.findViewById(R.id.checkBox1);
        answer2 = (CheckBox) textScreen.findViewById(R.id.checkBox2);
        answer3 = (CheckBox) textScreen.findViewById(R.id.checkBox3);
        answer4 = (CheckBox) textScreen.findViewById(R.id.checkBox4);

        // Set up TextFragment View's 'Finish Quiz' button with an action listener
        Button startQuiz = (Button) textScreen.findViewById(R.id.text_fragment_submit);
        startQuiz.setClickable(true);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Call the finishQuiz method of the StartActivity
                ((StartActivity)getActivity()).finishQuiz((answer1.isChecked() && !answer2.isChecked() && answer3.isChecked() && answer4.isChecked()));
            }
        });

        return textScreen;
    }
}
