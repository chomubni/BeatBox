package com.example.ivan.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 9/5/17.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    private void loadSounds(){
        String[] soundsName = null;
        try {
            soundsName = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG,"Found " + soundsName.length + " sounds");
        }
        catch (IOException ioe){
            Log.e(TAG,"Could not list assets",ioe);
        }
        if(soundsName!=null) {
            for (String fileName : soundsName) {
                try{
                String assetPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);}
                catch (IOException ioe){
                    Log.e(TAG, "Couldn't load sound " + fileName,ioe);
                }
            }
        }
    }

    private void load(Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetsPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
