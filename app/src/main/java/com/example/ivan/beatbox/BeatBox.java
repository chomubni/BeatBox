package com.example.ivan.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
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

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssets = context.getAssets();
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
                String assetPath = SOUNDS_FOLDER + "/" + fileName;
                Sound sound = new Sound(assetPath);
                mSounds.add(sound);
            }
        }
    }

    public List<Sound> getSounds(){
        return mSounds;
    }
}
