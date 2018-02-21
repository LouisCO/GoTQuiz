package com.example.android.gotquiz;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    boolean IsAudioOn;
    String position="position";
    MediaPlayer mTune;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Starts playing theme at app start
        MediaPlayer tune=MediaPlayer.create(this, R.raw.got_theme);
        tune.start();
        tune.setLooping(true);
        // initialize member MediaPlayer
        mTune=tune;
    }

    /**
     * This method is invoked to save the current playback position.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(position, mTune.getCurrentPosition());
        mTune.stop();
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This method is called to restore the current playback position.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        int pos=savedInstanceState.getInt(position);
        mTune.seekTo(pos);
        mTune.setLooping(true);
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * This method is called to stop the music on app exit
     */
    @Override
    protected void onStop() {
        super.onStop();
        mTune.release();
    }


    /**
     * This method is called when mute/unmute button is clicked.
     */
    public void sound(View v) {
        AudioManager audio=(AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        ImageView note=findViewById(R.id.mute);

        if (IsAudioOn) {
            IsAudioOn=false;
            assert audio != null;
            audio.setStreamMute(AudioManager.STREAM_MUSIC, false); // for unmute
            note.setImageResource(R.drawable.ic_note);

        } else {
            IsAudioOn=true;
            assert audio != null;
            audio.setStreamMute(AudioManager.STREAM_MUSIC, true);  //for mute
            note.setImageResource(R.drawable.ic_nonote);
        }
    }


    /**
     * This method is called when the reset button is clicked.
     */
    public void retakeQuiz(View view) {
        Intent MainActivity=getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        assert MainActivity != null;
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }


    /**
     * This method checks if all questions are answered
     *
     * @param isMartellChecked   /
     * @param isMottoChecked     /
     * @param isReligionChecked  /
     * @param isValarChecked     /
     * @param isVarysChecked     /
     * @param isWeaponChecked    /
     * @param isSwordChecked/
     * @param isDaenerysChecked/
     * @param isNymeria/
     * @param isJorahChecked     /
     * @param isKingChecked      /
     * @param isKnightsNum       /
     * @return quiz checked
     */
    private boolean isQuizChecked(boolean isSwordChecked, boolean isDaenerysChecked, boolean isNymeria, boolean isJorahChecked, boolean isKnightsNum, boolean isMartellChecked, boolean isValarChecked, boolean isVarysChecked, boolean isKingChecked, boolean isWeaponChecked, boolean isReligionChecked, boolean isMottoChecked) {
        return isSwordChecked && isDaenerysChecked && isNymeria && isJorahChecked && isKnightsNum && isMartellChecked && isValarChecked && isVarysChecked && isKingChecked && isWeaponChecked && isReligionChecked && isMottoChecked;
    }

    /**
     * This method checks if Q1 is answered
     */
    private boolean isSwordChecked() {

        RadioButton iceRButton=findViewById(R.id.ice);
        boolean isIceChecked=iceRButton.isChecked();

        RadioButton needleRButton=findViewById(R.id.needle);
        boolean isNeedleChecked=needleRButton.isChecked();

        RadioButton longclawRButton=findViewById(R.id.longclaw);
        boolean isLongclawChecked=longclawRButton.isChecked();

        RadioButton oathkRButton=findViewById(R.id.oathkeeper);
        boolean isOathkChecked=oathkRButton.isChecked();

        return isIceChecked || isNeedleChecked || isLongclawChecked || isOathkChecked;
    }

    /**
     * This method checks if Q2 is answered
     */
    private boolean isDaenerysChecked() {

        CheckBox stormbornCBox=findViewById(R.id.stormborn);
        boolean isStormbornChecked=stormbornCBox.isChecked();

        CheckBox unburntCBox=findViewById(R.id.unburnt);
        boolean isUnburntChecked=unburntCBox.isChecked();

        CheckBox queenCBox=findViewById(R.id.queen);
        boolean isQueenChecked=queenCBox.isChecked();

        CheckBox silverCBox=findViewById(R.id.silver);
        boolean isSilverChecked=silverCBox.isChecked();

        return isStormbornChecked || isUnburntChecked || isQueenChecked || isSilverChecked;
    }

    /**
     * This method checks if Q3 is answered
     */
    private boolean isJorahChecked() {
        RadioButton paleButton=findViewById(R.id.mere_dis);
        boolean isPaleChecked=paleButton.isChecked();

        RadioButton grayscaleButton=findViewById(R.id.scale_dis);
        boolean isGrayscaleChecked=grayscaleButton.isChecked();

        RadioButton springButton=findViewById(R.id.sickness_dis);
        boolean isSicknessChecked=springButton.isChecked();

        RadioButton plagueButton=findViewById(R.id.plague_dis);
        boolean isPlagueChecked=plagueButton.isChecked();

        return isPaleChecked || isGrayscaleChecked || isSicknessChecked || isPlagueChecked;
    }

    /**
     * This method checks if Q4 is answered
     *
     * @param dWname /
     */
    private boolean isNymeria(String dWname) {
        return !dWname.contentEquals("");
    }

    /**
     * This method checks if Q5 is answered
     *
     * @param guardNum /
     */
    private boolean isKnightsNum(String guardNum) {
        return !guardNum.contentEquals("");
    }

    /**
     * This method checks if Q6 is answered
     */
    private boolean isMartellChecked() {
        RadioButton highgButton=findViewById(R.id.highgarden);
        boolean isHighgChecked=highgButton.isChecked();

        RadioButton dragonstButton=findViewById(R.id.dragonst);
        boolean isDragonstChecked=dragonstButton.isChecked();

        RadioButton sunButton=findViewById(R.id.sun);
        boolean isSunChecked=sunButton.isChecked();

        RadioButton volButton=findViewById(R.id.volantis);
        boolean isVolChecked=volButton.isChecked();

        return isHighgChecked || isDragonstChecked || isSunChecked || isVolChecked;
    }

    /**
     * This method checks if Q7 is answered
     */
    private boolean isValarChecked() {
        RadioButton serveButton=findViewById(R.id.must_serve);
        boolean isDieChecked=serveButton.isChecked();

        RadioButton todayButton=findViewById(R.id.must_today);
        boolean isTodayChecked=todayButton.isChecked();

        RadioButton dieButton=findViewById(R.id.must_die);
        boolean isMdieChecked=dieButton.isChecked();

        RadioButton winButton=findViewById(R.id.must_win);
        boolean isWinChecked=winButton.isChecked();

        return isDieChecked || isTodayChecked || isMdieChecked || isWinChecked;
    }

    /**
     * This method checks if Q8 is answered
     */
    private boolean isVarysChecked() {
        CheckBox houndCBox=findViewById(R.id.hound);
        boolean isHoundChecked=houndCBox.isChecked();

        CheckBox mountCBox=findViewById(R.id.mountain);
        boolean isMountChecked=mountCBox.isChecked();

        CheckBox spiderCBox=findViewById(R.id.spider);
        boolean isSpiderChecked=spiderCBox.isChecked();

        CheckBox eunuchCBox=findViewById(R.id.eunuch);
        boolean isEunuchChecked=eunuchCBox.isChecked();

        return isHoundChecked || isMountChecked || isSpiderChecked || isEunuchChecked;
    }

    /**
     * This method checks if Q9 is answered
     */
    private boolean isKingChecked() {
        RadioButton aegonButton=findViewById(R.id.aegon);
        boolean isAegonChecked=aegonButton.isChecked();

        RadioButton aerisButton=findViewById(R.id.aeris);
        boolean isAerisChecked=aerisButton.isChecked();

        RadioButton aemonButton=findViewById(R.id.aemon);
        boolean isAemonChecked=aemonButton.isChecked();

        RadioButton rhaegarButton=findViewById(R.id.rhaegar);
        boolean isRhaegChecked=rhaegarButton.isChecked();

        return isAegonChecked || isAerisChecked || isAemonChecked || isRhaegChecked;
    }

    /**
     * This method checks if Q10 is answered
     */
    private boolean isWeaponChecked() {
        CheckBox dragonCBox=findViewById(R.id.dragonglass);
        boolean isDragonglassChecked=dragonCBox.isChecked();

        CheckBox obsidianCBox=findViewById(R.id.obsidian);
        boolean isObsidianChecked=obsidianCBox.isChecked();

        CheckBox dragonstoneCBox=findViewById(R.id.dragonstone);
        boolean isDragonstoneChecked=dragonstoneCBox.isChecked();

        CheckBox valyrianCBox=findViewById(R.id.valyrian);
        boolean isValyrianChecked=valyrianCBox.isChecked();

        return isDragonglassChecked || isObsidianChecked || isDragonstoneChecked || isValyrianChecked;
    }

    /**
     * This method checks if Q11 is answered
     */
    private boolean isReligionChecked() {
        RadioButton oldButton=findViewById(R.id.old_gods);
        boolean isOld=oldButton.isChecked();

        RadioButton relButton=findViewById(R.id.faith);
        boolean isFaith=relButton.isChecked();

        RadioButton drownedButton=findViewById(R.id.drowned_god);
        boolean isDrowned=drownedButton.isChecked();

        RadioButton lightButton=findViewById(R.id.lord_of_light);
        boolean isLight=lightButton.isChecked();

        return isOld || isFaith || isDrowned || isLight;
    }

    /**
     * This method checks if Q12 is answered
     */
    private boolean isMottoChecked() {
        RadioButton familyButton=findViewById(R.id.family);
        boolean isFamily=familyButton.isChecked();

        RadioButton mottoButton=findViewById(R.id.roar);
        boolean isRoar=mottoButton.isChecked();

        RadioButton debtsButton=findViewById(R.id.debts);
        boolean isDebts=debtsButton.isChecked();

        RadioButton furyButton=findViewById(R.id.fury);
        boolean isFury=furyButton.isChecked();

        return isFamily || isRoar || isDebts || isFury;
    }

    /**
     * This method is called when the "submit" button is clicked."
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

        EditText guardNumber=findViewById(R.id.kings_guards);
        String guardNum=guardNumber.getText().toString();

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

        if (points == 17 && isQuizChecked(isSwordChecked(), isDaenerysChecked(), isNymeria(dWname), isJorahChecked(), isKnightsNum(guardNum), isMartellChecked(), isValarChecked(), isVarysChecked(), isKingChecked(), isWeaponChecked(), isReligionChecked(), isMottoChecked()))
            Toast.makeText(this, getString(R.string.result4, points), Toast.LENGTH_SHORT).show();
        else if (points < 5 && isQuizChecked(isSwordChecked(), isDaenerysChecked(), isNymeria(dWname), isJorahChecked(), isKnightsNum(guardNum), isMartellChecked(), isValarChecked(), isVarysChecked(), isKingChecked(), isWeaponChecked(), isReligionChecked(), isMottoChecked()))
            Toast.makeText(this, getString(R.string.result1, points), Toast.LENGTH_LONG).show();
        else if (points >= 11 && points < 17 && isQuizChecked(isSwordChecked(), isDaenerysChecked(), isNymeria(dWname), isJorahChecked(), isKnightsNum(guardNum), isMartellChecked(), isValarChecked(), isVarysChecked(), isKingChecked(), isWeaponChecked(), isReligionChecked(), isMottoChecked()))
            Toast.makeText(this, getString(R.string.result3, points), Toast.LENGTH_LONG).show();
        else if (points >= 5 && points < 11 && isQuizChecked(isSwordChecked(), isDaenerysChecked(), isNymeria(dWname), isJorahChecked(), isKnightsNum(guardNum), isMartellChecked(), isValarChecked(), isVarysChecked(), isKingChecked(), isWeaponChecked(), isReligionChecked(), isMottoChecked()))
            Toast.makeText(this, getString(R.string.result2, points), Toast.LENGTH_LONG).show();
        else Toast.makeText(this, getString(R.string.omission), Toast.LENGTH_LONG).show();
    }

    /**
     * This method checks answer to Q4
     *
     * @param dwName/
     * @return the exact name
     */
    private boolean isDirewolf(String dwName) {

        return (dwName.contains("Nymeria"));
    }

    /**
     * This method checks answer to Q5
     *
     * @param guardNum/
     * @return the number
     */
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
     * @return total points
     */
    private int calculateScore(boolean isIceChecked, boolean isStormbornChecked,
                               boolean isUnburntChecked, boolean isSilverChecked, boolean isDirewolf, boolean isSunChecked,
                               boolean isGrayscaleChecked, boolean isDieChecked, boolean isSpiderChecked,
                               boolean isEunuchChecked, boolean isAerisChecked, boolean isKingsguard,
                               boolean isDragonglassChecked, boolean isObsidianChecked, boolean isValyrianChecked,
                               boolean isFaith, boolean isRoar) {

        int points=0;

        if (isIceChecked) points++;
        if (isStormbornChecked) points++;
        if (isUnburntChecked) points++;
        if (isSilverChecked) points++;
        if (isDirewolf) points++;
        if (isSunChecked) points++;
        if (isGrayscaleChecked) points++;
        if (isDieChecked) points++;
        if (isSpiderChecked) points++;
        if (isEunuchChecked) points++;
        if (isAerisChecked) points++;
        if (isKingsguard) points++;
        if (isDragonglassChecked) points++;
        if (isObsidianChecked) points++;
        if (isValyrianChecked) points++;
        if (isFaith) points++;
        if (isRoar) points++;

        return points;
    }
}

