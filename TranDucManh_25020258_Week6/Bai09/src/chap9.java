package TranDucManh_25020258_Week6.Bai09.src;


interface AudioPlayable {
    void playAudio(String file );
}
interface VideoPlayable {
    void playVideo(String file );
}


class MediaPlayer {
    public AudioPlayable audio ;
    public VideoPlayable video ; 
    public MediaPlayer (AudioPlayable audio, VideoPlayable video){
        this.audio = audio ;
        this.video = video ;
    }
} 
class AudioPlayer implements AudioPlayable  {
    @Override
    public void playAudio(String file ){
        System.out.println("AUDIO loading : " + file );
    }
}
class VideoPlayer implements VideoPlayable {
    @Override
    public void playVideo (String file ){
        System.out.println("VIDEO loading : " + file );
    }
}


public class chap9 {
    public static void main(String[] args) {
        AudioPlayable myAudio = new AudioPlayer();
        VideoPlayable myVideo = new VideoPlayer();

        MediaPlayer player = new MediaPlayer(myAudio, myVideo);


        player.audio.playAudio("nhac_dragon_ball.mp3");
        player.video.playVideo("phim_hanh_dong.mp4");
    }
}
