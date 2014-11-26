package cn.edu.gdmec.s07131027.propertanimation;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv;
	private Button btAlpha, btTranslate, btScale, btRotate, btAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.textView1);
        btAlpha = (Button) findViewById(R.id.button1);
        btTranslate = (Button) findViewById(R.id.button2);
        btScale = (Button) findViewById(R.id.button3);
        btRotate = (Button) findViewById(R.id.button4);
        btAll = (Button) findViewById(R.id.button5);
        
        btAlpha.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.alpha_animator);
				animator.setTarget(tv);
				
				animator.start();
			}
		});
        
        btTranslate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transate_animator);
				animator.setTarget(tv);
				
				animator.start();
				
			}
		});
        btScale.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.scale_animator);
				animator.setTarget(tv);
				
				animator.start();
			}
		});
        btRotate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animator animator = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotation_animator);
				animator.setTarget(tv);
				
				animator.start();
			}
		});
        btAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AnimatorSet set = new AnimatorSet();
				Animator alpha = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.alpha_animator);
				Animator transate = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.transate_animator);
				Animator scale = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.scale_animator);
				Animator rotation = AnimatorInflater.loadAnimator(MainActivity.this, R.animator.rotation_animator);
				
				set.play(alpha).after(transate).after(scale).after(rotation);
				set.setTarget(tv);
				set.start();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
