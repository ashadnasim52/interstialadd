package ashad.app.torch.flashlight.interstialadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd interstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        loadinterstitial();

        // Listener for Ad
        interstitial.setAdListener(new AdListener()
        {
            // When Closed Ad, Load new Ad
            @Override
            public void onAdClosed()
            {
                super.onAdClosed();
                loadinterstitial();
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitialAd();

    }

    private void loadinterstitial()
    {
        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
    }

    // Show Interstitial Ad
    private void showInterstitialAd()
    {
        // return, if Ad data is no loaded
        if (!interstitial.isLoaded()) {
            Toast.makeText(this, "Not loaded", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show Ad
        interstitial.show();
    }


}
