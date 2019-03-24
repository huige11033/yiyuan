package com.team.azusa.yiyuan.utils.glide;

import android.util.Config;
import android.util.Log;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.team.azusa.yiyuan.utils.HttpSSLUtils;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static de.greenrobot.event.EventBus.TAG;

/**
 * A simple model loader for fetching media over http/https using OkHttp.
 */
public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    private final Call.Factory client;

    // Public API.
    @SuppressWarnings("WeakerAccess")
    public OkHttpUrlLoader(@NonNull Call.Factory client) {
        this.client = client;
    }

    @Override
    public boolean handles(@NonNull GlideUrl url) {
        return true;
    }

    @Override
    public LoadData<InputStream> buildLoadData(@NonNull GlideUrl model, int width, int height,
                                               @NonNull Options options) {
        return new LoadData<>(model, new OkHttpStreamFetcher(client, model));
    }

    /**
     * The default factory for {@link OkHttpUrlLoader}s.
     */
    // Public API.
    @SuppressWarnings("WeakerAccess")
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile Call.Factory internalClient;
        private final Call.Factory client;

        private static Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = createHttpClient();
                    }
                }
            }
            return internalClient;
        }

        /**
         * Constructor for a new Factory that runs requests using a static singleton client.
         */
        public Factory() {
            this(getInternalClient());
        }

        /**
         * Constructor for a new Factory that runs requests using given client.
         *
         * @param client this is typically an instance of {@code OkHttpClient}.
         */
        public Factory(@NonNull Call.Factory client) {
            this.client = client;
        }

        @NonNull
        @Override
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new OkHttpUrlLoader(client);
        }

        @Override
        public void teardown() {
            // Do nothing, this instance doesn't own the client.
        }
    }

    private static OkHttpClient createHttpClient() {
        // 日志拦截器
        HttpLoggingInterceptor mLogInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

            @Override
            public void log(@NonNull String message) {
                Log.d(TAG, "request result: = " + message);
            }
        });
        if (Config.DEBUG) {
            mLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            mLogInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        // SSL无证书校验，全信任
        HttpSSLUtils.SSLParams sslParams = HttpSSLUtils.getSslSocketFactory(null, null, null);

        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .followRedirects(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(mLogInterceptor)
                .hostnameVerifier(sslParams.getUnSafeHostnameVerifier())
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                .build();
    }
}
