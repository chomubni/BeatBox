package com.example.ivan.beatbox;

import android.media.SoundPool;

/**
 * Created by ivan on 9/5/17.
 */

public class Sound {
    private String mAssetsPath;
    private String mName;
    private SoundPool mSoundId;

    public Sound(String assetsPath) {
        mAssetsPath = assetsPath;
        String[] components = assetsPath.split("/");
        String fileName = components[components.length-1];
        mName = fileName.replace(".wav","");
    }

    public String getAssetsPath() {
        return mAssetsPath;
    }

    public String getName() {
        return mName;
    }

    public SoundPool getSoundId() {
        return mSoundId;
    }

    public void setSoundId(SoundPool soundId) {
        mSoundId = soundId;
    }
}
