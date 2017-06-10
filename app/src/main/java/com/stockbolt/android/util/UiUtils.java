package com.stockbolt.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.stockbolt.android.R;

import java.io.File;

import static com.stockbolt.android.util.SharedPreferenceUtil.context;


/**
 * Created by guobin.zheng on 2015/6/16.
 * <p/>
 * UI工具
 */
public class UiUtils {
    /**
     * Convert Dp to Pixel
     */
    public static int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

    /**
     * 重设 view 的宽高
     */
    public static void setViewLayoutParams(View view, int nWidth, int nHeight) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp.height != nHeight || lp.width != nWidth) {
            lp.width = nWidth;
            lp.height = nHeight;
            view.setLayoutParams(lp);
        }
    }


    /**
     * 加载图片，设置宽高，解决加载大图片OOM问题
     *
     * @param sdv         VIEW
     * @param strImageUrl 图片加载地址
     * @param nWidth      宽
     * @param nHeight     高
     */
    public static void setImageToView(SimpleDraweeView sdv, String strImageUrl, int nWidth, int nHeight) {
        Uri uri = null;
        if (!TextUtils.isEmpty(strImageUrl))
            uri = Uri.parse(strImageUrl);
        setImageUriToView(sdv, uri, nWidth, nHeight);
    }

    /**
     * 加载图片，设置宽高，解决加载大图片OOM问题
     *
     * @param sdv     VIEW
     * @param nWidth  宽
     * @param nHeight 高
     */
    public static void setFileImageToView(SimpleDraweeView sdv, File file, int nWidth, int nHeight) {
        Uri uri = null;
        if (file != null && file.exists())
            uri = Uri.fromFile(file);
        setImageUriToView(sdv, uri, nWidth, nHeight);
    }

    private static void setImageUriToView(SimpleDraweeView sdv, Uri uri, int nWidth, int nHeight) {
        setViewLayoutParams(sdv, nWidth, nHeight);
//        if (uri == null) {
//            sdv.setImageURI(null);
//            return;
//        }
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setAutoRotateEnabled(true)
                .setResizeOptions(new ResizeOptions(nWidth, nHeight))//调整大小
                .setLocalThumbnailPreviewsEnabled(true)
                .build();
        PipelineDraweeController controller = (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                .setOldController(sdv.getController())
                .setImageRequest(request)
                .build();
        sdv.setController(controller);
    }

    public static void setSurfaceToView(Context mContext, SimpleDraweeView sdv, String strImageUrl, int nWidth, int nHeight) {
        if (TextUtils.isEmpty(strImageUrl))
            strImageUrl = UriUtil.getResPath(mContext, R.mipmap.icon_surface_green);
        setImageToView(sdv, strImageUrl, nWidth, nHeight);
    }

    public static void setSurfaceToView(Context mContext, SimpleDraweeView sdv, String strImageUrl) {
        if (TextUtils.isEmpty(strImageUrl))
            strImageUrl = UriUtil.getResPath(mContext, R.mipmap.icon_surface_green);
        setImageToView(sdv, strImageUrl);
    }

    /**
     * 加载图片，设置宽高，解决加载大图片OOM问题
     *
     * @param resources   资源
     * @param sdv         VIEW
     * @param strImageUrl 图片加载地址
     * @param nDpWidth    宽 必须是DP!!!!
     * @param nDpHeight   高 必须是DP!!!!
     */
    public static void setImageToViewByDp(Resources resources, SimpleDraweeView sdv, String strImageUrl, int nDpWidth, int nDpHeight) {
        int nWidth = dpToPx(nDpWidth, resources);
        int nHeight = dpToPx(nDpHeight, resources);
        setImageToView(sdv, strImageUrl, nWidth, nHeight);
    }

    /**
     * 加载图片
     *
     * @param sdv         VIEW
     * @param strImageUrl 图片加载地址
     */
    public static void setImageToView(SimpleDraweeView sdv, String strImageUrl) {
        sdv.setImageURI(TextUtils.isEmpty(strImageUrl) ? null : Uri.parse(strImageUrl));
    }

    public static Drawable getDrawable(Context mContext, int nDrawableID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return mContext.getResources().getDrawable(nDrawableID, mContext.getTheme());
        } else {
            return mContext.getResources().getDrawable(nDrawableID);
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void getListViewSize(ListView myListView) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);
        // print height of adapter on log
        Log.i("height of listItem:", String.valueOf(totalHeight));
    }

    public static int getLineHeight(TextView tv, String desc) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size); // Get full screen width
        int screenWidth = size.x;
        int eightyPercent = (screenWidth * 80) / 100; // Calculate 80% of it
        float textWidth = tv.getPaint().measureText(desc);
        int numberOfLines = ((int) textWidth/eightyPercent) + 1;
        return numberOfLines;
    }

    /**
     * Returns a CharSequence that concatenates the specified array of CharSequence
     * objects and then applies a list of zero or more tags to the entire range.
     *
     * @param content an array of character sequences to apply a style to
     * @param tags the styled span objects to apply to the content
     *        such as android.text.style.StyleSpan
     *
     */
    private static CharSequence apply(CharSequence[] content, Object... tags) {
        SpannableStringBuilder text = new SpannableStringBuilder();
        openTags(text, tags);
        for (CharSequence item : content) {
            text.append(item);
        }
        closeTags(text, tags);
        return text;
    }

    /**
     * Iterates over an array of tags and applies them to the beginning of the specified
     * Spannable object so that future text appended to the text will have the styling
     * applied to it. Do not call this method directly.
     */
    private static void openTags(Spannable text, Object[] tags) {
        for (Object tag : tags) {
            text.setSpan(tag, 0, 0, Spannable.SPAN_MARK_MARK);
        }
    }

    /**
     * "Closes" the specified tags on a Spannable by updating the spans to be
     * endpoint-exclusive so that future text appended to the end will not take
     * on the same styling. Do not call this method directly.
     */
    private static void closeTags(Spannable text, Object[] tags) {
        int len = text.length();
        for (Object tag : tags) {
            if (len > 0) {
                text.setSpan(tag, 0, len, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                text.removeSpan(tag);
            }
        }
    }

    /**
     * Returns a CharSequence that applies boldface to the concatenation
     * of the specified CharSequence objects.
     */
    public static CharSequence bold(CharSequence... content) {
        return apply(content, new StyleSpan(Typeface.BOLD));
    }

    /**
     * Returns a CharSequence that applies italics to the concatenation
     * of the specified CharSequence objects.
     */
    public static CharSequence italic(CharSequence... content) {
        return apply(content, new StyleSpan(Typeface.ITALIC));
    }

    /**
     * Returns a CharSequence that applies a foreground color to the
     * concatenation of the specified CharSequence objects.
     */
    public static CharSequence color(int color, CharSequence... content) {
        return apply(content, new ForegroundColorSpan(color));
    }
}
