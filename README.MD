
0.使用demo :

[https://github.com/mi-anna/libgdx-support-demo](https://github.com/mi-anna/libgdx-support-demo "https://github.com/mi-anna/libgdx-support-demo")

1.编译该工程：

    mvn clean install -Dmaven.test.skip

2.把生成的libgdx-game-engine-support-0.0.1.jar 复制到ligGdx项目*-core的libs文件夹下，如果没有该文件夹就新建一个

3.修改ligGdx工程的依赖
进入到libGdx项目：找到build.gradle文件：在project(":core")的dependencies中增加：
    
    compile files("libs/libgdx-game-engine-support-0.0.1.jar")
 

4.将*-core项目的程序入口类继承GameEngine
比如：

    public class MyGdxGame extends GameEngine{
    …………………..
    public MyGdxGame() { }
    	public MyGdxGame(GameEvent event) {
    		super(event);
    	}
    …………………..
    }

调用：

    mainGame.getEvent().onEvent2Android("hi bad body");//发送消息到android
    其中mainGame是类MyGdxGame的引用


5.*-android项目
5.1-新建类TestGameEvent继承GameEventAdapter<MyGdxGame>
代码如下：

    public class TestGameEvent extends GameEventAdapter<MyGdxGame> {
    	Context context;
    	public TestGameEvent(Context context) {
    		this.context = context;
    	}
    	Handler mHandler = new Handler() {
    		public void handleMessage(android.os.Message msg) {
    			Toast.makeText(context, (String)msg.obj, Toast.LENGTH_SHORT).show();
    		};
    	};
    
    	@Override
    	public void onEvent2Android(String msg) {
    		System.out.println(msg);
    		Message message = Message.obtain();
    		message.obj = msg;
    		message.what = 1;
    		mHandler.sendMessage(message);
    	}
    	@Override
    	public void onEvent2LibGdx(String msg) {
    		getGameEngine().setScreen(getGameEngine().getStartScreen());
    	}
    }


5.2-修改入口类public class AndroidLauncher extends AndroidApplication

代码如下：

    public class AndroidLauncher extends AndroidApplication {
    	Button mButton;
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.activity_main)
    		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
    		// initialize(new MyGdxGame(), config);
    		final TestGameEvent testGameEvent = new TestGameEvent(getApplicationContext());
    		final MyGdxGame myGdxGame = new MyGdxGame(testGameEvent);
    		SurfaceView gameView = (SurfaceView) initializeForView(myGdxGame, config);
    		addContentView(gameView, createLayoutParams());
    		mButton = (Button) findViewById(R.id.btn);
    		mButton.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				testGameEvent.onEvent2LibGdx("hello");
    			}
    		});
    	}
    	protected FrameLayout.LayoutParams createLayoutParams() {
    		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
    				android.view.ViewGroup.LayoutParams.MATCH_PARENT, 800);
    		layoutParams.gravity = Gravity.CENTER;
    		return layoutParams;
    	}
    }



5.3-XML文件修改layout/activity_main.xml
代码如下：

    <?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal" >
    	<LinearLayout
        	android:layout_width="match_parent"
        	android:layout_height="match_parent" >
        	<Button
            	android:id="@+id/btn"
            	android:text="你我一下"
            	android:layout_width="wrap_content"
            	android:layout_height="wrap_content" />
    	</LinearLayout>
	</RelativeLayout>
