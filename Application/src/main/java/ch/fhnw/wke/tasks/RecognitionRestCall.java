package ch.fhnw.wke.tasks;

import android.graphics.Bitmap;
import android.util.Log;

import ch.fhnw.wke.Config;
import ch.fhnw.wke.dto.ImageData;
import ch.fhnw.wke.dto.RecognitionResultData;
import ch.fhnw.wke.util.Util;

public class RecognitionRestCall extends AbstractRestCall<Bitmap, Void, RecognitionResultData> {

    @Override
    protected RecognitionResultData doInBackground(Bitmap... bitmaps) {
        try {
            Bitmap bitmap = bitmaps[0];
            RecognitionResultData recognitionResultData = getRestTemplate().postForObject(Config.REST_ENDPOINT_RECOGNIZE_WORKPIECE,
                    new ImageData(0, "", Util.bitmapToBase64(bitmap)), RecognitionResultData.class);
            return recognitionResultData;
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), e.getMessage(), e);
        }
        return null;
    }

}