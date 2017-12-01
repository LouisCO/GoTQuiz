package com.example.android.gotquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the reset button is clicked.
     */
    public void retakeQuiz(View view) {

        RadioGroup swordGroup=findViewById(R.id.sword);
        swordGroup.clearCheck();

        CheckBox stormbornCBox=findViewById(R.id.stormborn);
        stormbornCBox.setChecked(false);

        CheckBox unburntCBox=findViewById(R.id.unburnt);
        unburntCBox.setChecked(false);

        CheckBox queenCBox=findViewById(R.id.queen);
        queenCBox.setChecked(false);

        CheckBox silverCBox=findViewById(R.id.silver);
        silverCBox.setChecked(false);

        EditText dwName=findViewById(R.id.direwolf_name);
        dwName.setText(null);

        RadioGroup jorahGroup=findViewById(R.id.jorah);
        jorahGroup.clearCheck();

        RadioGroup martellGroup=findViewById(R.id.martell);
        martellGroup.clearCheck();

        RadioGroup valarGroup=findViewById(R.id.valar);
        valarGroup.clearCheck();

        CheckBox hCBox=findViewById(R.id.hound);
        hCBox.setChecked(false);

        CheckBox mountCBox=findViewById(R.id.mountain);
        mountCBox.setChecked(false);

        CheckBox spiderCBox=findViewById(R.id.spider);
        spiderCBox.setChecked(false);

        CheckBox eunuchCBox=findViewById(R.id.eunuch);
        eunuchCBox.setChecked(false);

        RadioGroup kingGroup=findViewById(R.id.king);
        kingGroup.clearCheck();

        EditText guardNumber=findViewById(R.id.kings_guards);
        guardNumber.setText(null);

        CheckBox dragonCBox=findViewById(R.id.dragonglass);
        dragonCBox.setChecked(false);

        CheckBox obsidianCBox=findViewById(R.id.obsidian);
        obsidianCBox.setChecked(false);

        CheckBox valyrianCBox=findViewById(R.id.valyrian);
        valyrianCBox.setChecked(false);

        RadioGroup religionGroup=findViewById(R.id.religion);
        religionGroup.clearCheck();

        RadioGroup mottoGroup=findViewById(R.id.motto);
        mottoGroup.clearCheck();

        ScrollView scrollView=findViewById(R.id.scroll_view);
        scrollView.fullScroll(ScrollView.FOCUS_UP);


    }


    /**
     * This method is called when the "submit" button is clicked.
     */
    public void showScore(View view) {

        RadioButton iceRButton=findViewById(R.id.ice);
        boolean isIceChecked=iceRButton.isChecked();

        CheckBox stormbornCBox=findViewById(R.id.stormborn);
        boolean isStormbornChecked=stormbornCBox.isChecked();

        CheckBox unburntCBox=findViewById(R.id.unburnt);
        boolean isUnburntChecked=unburntCBox.isChecked();

        CheckBox silverCBox=findViewById(R.id.silver);
        boolean isSilverChecked=silverCBox.isChecked();

        RadioButton grayscaleButton=findViewById(R.id.scale_dis);
        boolean isGrayscaleChecked=grayscaleButton.isChecked();

        EditText dwName=findViewById(R.id.direwolf_name);
        String dWname=dwName.getText().toString();

        RadioButton sunButton=findViewById(R.id.sun);
        boolean isSunChecked=sunButton.isChecked();

        RadioButton dieButton=findViewById(R.id.must_die);
        boolean isDieChecked=dieButton.isChecked();

        CheckBox spiderCBox=findViewById(R.id.spider);
        boolean isSpiderChecked=spiderCBox.isChecked();

        CheckBox eunuchCBox=findViewById(R.id.eunuch);
        boolean isEunuchChecked=eunuchCBox.isChecked();

        RadioButton aerisButton=findViewById(R.id.aeris);
        boolean isAerisChecked=aerisButton.isChecked();

        EditText guardNumber=findViewById(R.id.kings_guards);
        String guardNum=guardNumber.getText().toString();

        CheckBox dragonCBox=findViewById(R.id.dragonglass);
        boolean isDragonglassChecked=dragonCBox.isChecked();

        CheckBox obsidianCBox=findViewById(R.id.obsidian);
        boolean isObsidianChecked=obsidianCBox.isChecked();

        CheckBox valyrianCBox=findViewById(R.id.valyrian);
        boolean isValyrianChecked=valyrianCBox.isChecked();

        RadioButton relButton=findViewById(R.id.faith);
        boolean isFaith=relButton.isChecked();

        RadioButton mottoButton=findViewById(R.id.roar);
        boolean isRoar=mottoButton.isChecked();


        int points=calculateScore(isIceChecked, isStormbornChecked, isUnburntChecked, isSilverChecked, isGrayscaleChecked, isDirewolf(dWname), isSunChecked, isDieChecked, isSpiderChecked, isEunuchChecked, isAerisChecked, isKingsguard(guardNum), isDragonglassChecked, isObsidianChecked, isValyrianChecked, isFaith, isRoar);

        if (points == 17) {
            Toast.makeText(this, getString(R.string.result4, points), Toast.LENGTH_SHORT).show();
        } else if (points < 5) {
            Toast.makeText(this, getString(R.string.result1, points), Toast.LENGTH_LONG).show();
        } else if (points > 12) {
            Toast.makeText(this, getString(R.string.result3, points), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.result2, points), Toast.LENGTH_LONG).show();
        }

    }


    private boolean isDirewolf(String dwName) {
        return (dwName.contains("Nymeria"));
    }

    private boolean isKingsguard(String guardNum) {
        return (guardNum.contentEquals("7"));
    }


    /**
     * @param isIceChecked/
     * @param isStormbornChecked/
     * @param isUnburntChecked/
     * @param isSilverChecked/
     * @param isDirewolf/
     * @param isSunChecked/
     * @param isGrayscaleChecked/
     * @param isDieChecked/
     * @param isSpiderChecked/
     * @param isEunuchChecked/
     * @param isAerisChecked/
     * @param isKingsguard/
     * @param isDragonglassChecked /
     * @param isObsidianChecked/
     * @param isValyrianChecked    /
     * @param isFaith              /
     * @param isRoar               /
     *                             <p>
     *                             <p>
     *                             * @return total points
     */
    public int calculateScore(boolean isIceChecked, boolean isStormbornChecked, boolean isUnburntChecked, boolean isSilverChecked, boolean isDirewolf, boolean isSunChecked, boolean isGrayscaleChecked, boolean isDieChecked, boolean isSpiderChecked, boolean isEunuchChecked, boolean isAerisChecked, boolean isKingsguard, boolean isDragonglassChecked, boolean isObsidianChecked, boolean isValyrianChecked, boolean isFaith, boolean isRoar) {

        int points=0;

        if (isIceChecked) {
            points+=1;
        }
        if (isStormbornChecked) {
            points+=1;
        }
        if (isUnburntChecked) {
            points+=1;
        }
        if (isSilverChecked) {
            points+=1;
        }
        if (isDirewolf) {
            points+=1;
        }
        if (isSunChecked) {
            points+=1;
        }
        if (isGrayscaleChecked) {
            points+=1;
        }
        if (isDieChecked) {
            points+=1;
        }
        if (isSpiderChecked) {
            points+=1;
        }
        if (isEunuchChecked) {
            points+=1;
        }
        if (isAerisChecked) {
            points+=1;
        }
        if (isKingsguard) {
            points+=1;
        }
        if (isDragonglassChecked) {
            points+=1;
        }
        if (isObsidianChecked) {
            points+=1;
        }
        if (isValyrianChecked) {
            points+=1;
        }
        if (isFaith) {
            points+=1;
        }
        if (isRoar) {
            points+=1;
        }

        return points;
    }
}

