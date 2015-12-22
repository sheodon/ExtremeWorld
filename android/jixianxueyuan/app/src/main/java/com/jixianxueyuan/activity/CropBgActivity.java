package com.jixianxueyuan.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.isseiaoki.simplecropview.CropImageView;
import com.jixianxueyuan.R;
import com.jixianxueyuan.util.BitmapUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by pengchao on 12/22/15.
 */
public class CropBgActivity extends Activity {
    @InjectView(R.id.cropImageView)CropImageView cropImageView;

    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_avatar_activity);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        imagePath = intent.getStringExtra("imagePath");
        if (imagePath == null){
            finish();
        }

        cropImageView.setImageBitmap(BitmapUtils.getSmallBitmap(imagePath));
    }

    @OnClick(R.id.crop_avatar_done_button)void onClick(){

        Bitmap bitmap = cropImageView.getCroppedBitmap();
        //ACache aCache = ACache.get(this);
        //aCache.put("cropAvatar", bitmap);
        String filePath = BitmapUtils.saveBitmapToFile(CropBgActivity.this, bitmap);

        Intent intent = new Intent();
        intent.putExtra("filePath", filePath);
        setResult(RESULT_OK,intent);
        finish();
    }
}
