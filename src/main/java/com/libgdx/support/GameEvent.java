package com.libgdx.support;

/**
 * 
 * @Title: GameEvent.java 
 * @Description: 
 * <pre>
 *  该接口是android和libGdx通讯的基石,
 *  通常希望继承子类{@link com.mygdx.tools.GameEventAdapter<T extends GameEngine>}
 * </pre>
 * @author shimanqiang
 */
public interface GameEvent {

	/**
	 * 从ligGdx调用android的事件方法
	 * @param msg
	 */
	void onEvent2Android(String msg);

	/**
	 * 从android调用ligGdx的事件方法
	 * @param msg
	 */
	void onEvent2LibGdx(String msg);
}
