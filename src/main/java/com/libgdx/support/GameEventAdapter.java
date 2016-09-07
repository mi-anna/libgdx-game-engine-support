package com.libgdx.support;

/**
 * 
 * @Title: GameEventAdapter.java 
 * @Description: 
 * <pre>
 *  实现了接口 {@link GameEvent}
 *  并且可以获取到GameEngine的引用···哦！！！
 * </pre>
 * @author shimanqiang
 */
public class GameEventAdapter<T extends GameEngine> implements GameEvent {
	
	@SuppressWarnings("unchecked")
	protected T getGameEngine() {
		return (T) GameEngineManager.getInstance().getGameEngine();
	}

	@Override
	public void onEvent2Android(String msg) {
	}

	@Override
	public void onEvent2LibGdx(String msg) {
	}

}
