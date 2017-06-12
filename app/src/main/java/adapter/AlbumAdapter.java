package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigapp.bigappcompany.R;

/**
 * Created by Others on 5/21/2017.
 */

public class AlbumAdapter extends PagerAdapter
{
    private int[] album_images=new int[]{R.mipmap.game_of_thrones,R.mipmap.toystory,R.mipmap.house,R.mipmap.wall};
    Context mContext;
    private LayoutInflater layoutInflater;
    public AlbumAdapter(Context context)
    {
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return album_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(album_images[position]);
        ((ViewPager) container).addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView)object);
    }
}
