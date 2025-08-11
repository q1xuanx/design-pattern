package Structual_Patterns;

import java.util.List;

public class ProxyPattern {

    public static interface ThirdPartyYoutube {
        List<String> getVideos();
        String downLoadVideos(int id);
    }

    public static class ThirdPartyYoutubeImpl implements ThirdPartyYoutube {

        @Override
        public List<String> getVideos() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String downLoadVideos(int id) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }


    public static class ThirdPartyYoutubeProxy {
        private ThirdPartyYoutube thirdPartyYoutube;
        private List<String> videos;
        private String videoInfo;

        public ThirdPartyYoutubeProxy(ThirdPartyYoutube thirdPartyYoutube) {
            this.thirdPartyYoutube = thirdPartyYoutube;
        }

        public List<String> getVideos() {
            if (videos == null) {
                videos = thirdPartyYoutube.getVideos();
            }
            return videos;
        }

        public String getVideoInfo(int id) {
            if (videoInfo == null) {
                videoInfo = thirdPartyYoutube.downLoadVideos(id);
            }
            return videoInfo;
        }
    }


    public static void main(String[] args) {
        ThirdPartyYoutube thirdPartyYoutube = new ThirdPartyYoutubeImpl();
        ThirdPartyYoutubeProxy proxy = new ThirdPartyYoutubeProxy(thirdPartyYoutube);

        proxy.getVideos();
    }
}
