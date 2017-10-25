# AresProject
1:圆形头像View控件：RoundImageView
GitHub:https://github.com/AresCool/RoundImageView
使用：
RoundImageView imageView = (RoundImageView) findViewById(R.id.round_imageview);
imageView.setImageResource(R.mipmap.android, Color.RED, 10, true);
    <com.wx.roundimageview.RoundImageView
        xmlns:app="http://schemas.android.com/apk/res/com.wx.roundimageview.demo"
        android:id="@+id/round_imageview1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:src="@mipmap/ic_launcher"
        app:border_color="#ff0000"
        app:border_width="2dp"
        app:circle="true"
        />
