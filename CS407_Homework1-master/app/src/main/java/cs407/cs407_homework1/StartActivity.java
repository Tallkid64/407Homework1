package cs407.cs407_homework1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    /**
     * Integer for tracking a user's score
     */
    public static int score = 0;

    /**
     * Booleans to track correct answers
     */
    public static boolean answer1 = false;
    public static boolean answer2 = false;

    /**
     * Global fragments to assign into the FrameLayout fragment container.
     * They are global to avoid reinstantiating new Fragments each time
     * the user restarts the quiz
     */
    private StartFragment startFragment = new StartFragment();
    private PictureFragment pictureFragment = new PictureFragment();
    private TextFragment textFragment = new TextFragment();
    private ResultFragment resultFragment = new ResultFragment();

    /**
     * Global fragment transaction manager used to manage fragment
     * visibility in the FrameLayout.
     */
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Add the 'fragment_container' to the StartActivity FrameLayout.
        // Fill this frame_container with the StartFragment for display.
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, startFragment).commit();

    }

    /**
     * This method is called when the user presses the 'Start Quiz' button
     * in the StartFragment View. This method is responsible for restarting
     * the quiz's state (reset score, booleans) and replacing the StartFragment
     * with the PictureFragment for quiz question one.
     */
    public void startQuiz() {

        // Reset score
        score = 0;
        answer1 = false;
        answer2 = false;

        // Use the FragmentManager to switch Fragments on the screen
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, pictureFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    /**
     * This method is called when the user presses the 'Submit Answer' button
     * in the PictureFragment View. This method is responsible for determining
     * if the user has given the correct answer for question one, as well as
     * replacing the PictureFragment with the TextFragment for quiz question two.
     */
    public void nextQuestion(String answer, String response) {

        // Increment score if answer one response is correct
        if (answer.equalsIgnoreCase(response) || answer.equalsIgnoreCase("THE " + response)) {
            score++;
            answer1 = true;
            //Toast.makeText(StartActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, textFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void finishQuiz(boolean response) {

        // Increment score if answer two response is correct
        if (response) {
            score++;
            answer2 = true;
            //Toast.makeText(StartActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, resultFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    /**
     * This method is used for debbuging purposes, specifically
     * allowing Fragments to display Toast messages.
     * @param message
     */
    public void showToast(String message) {
        Toast.makeText(StartActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
