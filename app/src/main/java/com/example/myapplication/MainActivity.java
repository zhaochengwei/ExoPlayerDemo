package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.browse.MediaBrowser;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class MainActivity extends AppCompatActivity {

    protected StyledPlayerView playerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView=findViewById(R.id.player_view);
        playerView.requestFocus();

        ExoPlayer player = new ExoPlayer.Builder(MainActivity.this).build();
        // Build the media item.
        MediaItem mediaItem = MediaItem.fromUri("/storage/emulated/0/DCIM/test.mp4");
        // Set the media item to be played.
        player.setMediaItem(mediaItem);
        // Prepare the player.
        player.prepare();
        player.setRepeatMode(Player.REPEAT_MODE_OFF); //循环播放单个视频 Player.REPEAT_MODE_ONE; //列表循环 Player.REPEAT_MODE_ALL;);
        // Start the playback.
        player.play();
        playerView.setPlayer(player);

        player.release();
    }
}