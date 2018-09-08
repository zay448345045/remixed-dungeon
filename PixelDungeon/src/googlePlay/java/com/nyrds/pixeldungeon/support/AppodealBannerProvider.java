package com.nyrds.pixeldungeon.support;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.BannerView;
import com.nyrds.pixeldungeon.ml.EventCollector;
import com.watabou.noosa.Game;

class AppodealBannerProvider implements AdsUtilsCommon.IBannerProvider {

    @Override
    public void displayBanner() {

        AppodealRewardVideo.init();
        Appodeal.cache(Game.instance(), Appodeal.BANNER);

        Appodeal.setBannerCallbacks(new AppodealBannerCallbacks());

        BannerView adView = Appodeal.getBannerView(Game.instance());
        Game.instance().getLayout().addView(adView, 0);

        Appodeal.show(Game.instance(), Appodeal.BANNER_VIEW);
    }

    private class AppodealBannerCallbacks implements BannerCallbacks {
        @Override
        public void onBannerLoaded(int i, boolean b) {

        }

        @Override
        public void onBannerFailedToLoad() {
            EventCollector.logEvent("banner", "appodeal_no_banner");
            AdsUtilsCommon.bannerFailed(AppodealBannerProvider.this);
        }

        @Override
        public void onBannerShown() {

        }

        @Override
        public void onBannerClicked() {

        }
    }
}
